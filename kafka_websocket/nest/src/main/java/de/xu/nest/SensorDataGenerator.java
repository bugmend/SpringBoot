package de.xu.nest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SensorDataGenerator {

    private final KafkaTemplate<String, SensorData> kafkaTemplate;

    private final List<String> sensors = Arrays.asList("Bedroom", "Living Room", "Kitchen");

    @Autowired
    public SensorDataGenerator(KafkaTemplate<String, SensorData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 20000)
    public void generateSensorData() {
        for (String sensorId : sensors) {
            SensorData sensorData = new SensorData(
                    null,
                    sensorId,
                    ThreadLocalRandom.current().nextDouble(15, 45),
                    ThreadLocalRandom.current().nextInt(30, 80),
                    ThreadLocalRandom.current().nextInt(100, 1000)
            );

            kafkaTemplate.send("sensor-data", sensorData.getSensorId(), sensorData);
            System.out.println("Generated Sensor Data: " + sensorData);
        }
    }
}