package com.project.drone.musalasoft.drone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class DroneTemp {
    @Bean
    CommandLineRunner commandLineRunner(DroneRepository repository){
        return  args -> {
            Drone firstDrone = new Drone(
                    "CruiserWeight",
                    200,
                    "35",
                    "IDLE",
                    null,
                    null
            );
            Drone secondDrone = new Drone(
                    "LightWeight",
                    240,
                    "25",
                    "IDLE",
                    null,
                    null
            );
            repository.saveAll(List.of(firstDrone, secondDrone));
        };
    }

}
