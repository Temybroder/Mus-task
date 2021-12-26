package com.project.drone.musalasoft.drone;

import com.project.drone.musalasoft.drone.battery.Battery_level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DroneService {

    private final DroneRepository droneRepository;

    @Autowired
    public DroneService(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    public List<Drone> getDrones(){
        return droneRepository.findAll();
    }

    // Find Drone By State
    public List<Drone>getDronesByState(String state){
        return droneRepository.findDroneByState(state);
    }

    public void registerDrone(Drone drone) {
        Optional<Drone> DroneById = droneRepository.findDroneById(drone.getDrone_id());
        if(DroneById.isPresent()){
            // Throw simple exception. In production, should use Custom exceptions
            throw new IllegalStateException("Drone already registered");
        }
        droneRepository.save(drone);
    }

    // Load Drone with Medication
    @Transactional
    public void loadMedication(Long drone_id, ArrayList medications) {
        Drone drone =droneRepository.findDroneById(drone_id)
                .orElseThrow(() -> new IllegalStateException("Drone does not exist, hence can not be loaded"));
        // Prevent Drone from Over-weight
        Integer medication_weight = 0;
        // Using for-loop since loop depends only on one value; Time-complexity is minimal and constant - O(n)
            for (int i = 0; i < medications.size(); i++){
                medication_weight += medications.get(i).getWeight();
            }
            if(medications != null && medication_weight < drone.getWeight_limit()){
                drone.setMedications(medications);
            }
         throw new IllegalStateException("Error: Ensure Medications are loaded, and within weight limit");
    }

    public List<Drone> getDroneMedications(Long drone_id) {
     return droneRepository.fetchDroneById(drone_id);

    }

    public int getBatteryLevel(Long drone_id) {
        Optional result = droneRepository.findDroneById(drone_id);
        public List<Battery_level> getBatteryLog(){

        }

    }
}
