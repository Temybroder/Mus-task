package com.project.drone.musalasoft.drone.battery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BatteryService {

    private final BatteryRepository batteryRepository;

    @Autowired
    public BatteryService(BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }

    public List<Battery_level> getBatteryLevel(){
        return batteryRepository.findAll();
    }
}
