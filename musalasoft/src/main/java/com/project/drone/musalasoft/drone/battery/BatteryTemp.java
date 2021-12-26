package com.project.drone.musalasoft.drone.battery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class BatteryTemp {
    @Bean
    CommandLineRunner commandLineRunB (BatteryRepository repository){
        return args -> {
            Battery_level level1 = new Battery_level(
                    7L,
                    42,
                    LocalDate.of(2000, 04, 02),
                    null
            );
            Battery_level level2 = new Battery_level(
                    9L,
                    83,
                    LocalDate.of(2000, 04, 02),
                    null
            );
            repository.saveAll(List.of(level1, level2));
        };
    }
}
