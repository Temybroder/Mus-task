package com.project.drone.musalasoft.drone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/drones")
public class DroneController {

    private final DroneService droneService;

    @Autowired
    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @GetMapping(path = "/all")
    public List<Drone>getDrones(){
       return droneService.getDrones();
    }

    //Get Drones Available for Loading; Drone is available
    //when state is equal to "IDLE"
    @GetMapping(path = "/some")
    public List<Drone>getDronesByState(String state){
        return droneService.getDronesByState(state);
    }

    // Get Medications for a particular Drone
    @GetMapping(path = "/some_meds")
    public List<Drone> getDroneMedications(
            @PathVariable("drone_id") Long drone_id
    ){
        return droneService.getDroneMedications(drone_id);
    }

    //Check Drone Battery Level for a given drone
    @GetMapping(path = "/some_meds")
    public int getBatteryLevel(
            @PathVariable("drone_id") Long drone_id
    ){
        return droneService.getBatteryLevel(drone_id);
    }

    //REGISTER DRONE
    @PostMapping
    public void registerDrone(@RequestBody Drone  drone){
        droneService.registerDrone(drone);
    }

    //LOAD DRONE WITH MEDICATIONS
    public void loadMedications(
            @PathVariable("drone_id") Long drone_id,
            @RequestBody(required = true) ArrayList medications
            ){
        droneService.loadMedication(drone_id, medications);
    }
}
