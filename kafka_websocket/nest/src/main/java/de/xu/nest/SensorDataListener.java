package de.xu.nest;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SensorDataListener {

    private final SimpMessagingTemplate messagingTemplate;

    public SensorDataListener(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "smart-group")
    public void consumeSensorData(SensorData sensorData) {
        System.out.println("Received SensorData: " + sensorData);
        if (sensorData.getTemperature() > 30) {
            String alertMessage = "Alert! Sensor " + sensorData.getSensorId() +
                    " reported temperature: " + sensorData.getTemperature() + "°C";
            messagingTemplate.convertAndSend("/topic/alerts", alertMessage);
            System.out.println("Broadcasted Alert: " + alertMessage);
        }
    }
}