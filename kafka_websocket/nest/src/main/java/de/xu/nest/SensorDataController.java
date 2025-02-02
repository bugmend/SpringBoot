package de.xu.nest;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@CrossOrigin(origins = "*")
public class SensorDataController {

    private final SensorDataRepository repository;
    private final SimpMessagingTemplate messagingTemplate;

    public SensorDataController(SensorDataRepository repository, SimpMessagingTemplate messagingTemplate) {
        this.repository = repository;
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping
    public List<SensorData> getAllSensorData() {
        return repository.findAll();
    }

    @PostMapping
    public void addSensorData(@RequestBody SensorData sensorData) {
        repository.save(sensorData);
        if (sensorData.getTemperature() > 30) {
            String alertMessage = "Alert! Sensor " + sensorData.getSensorId() +
                    " reported temperature: " + sensorData.getTemperature() + "°C";
            messagingTemplate.convertAndSend("/topic/alerts", alertMessage);
        }
    }
}