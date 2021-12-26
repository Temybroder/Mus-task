package com.project.drone.musalasoft.medication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class MedicationTemp {
    @Bean
    CommandLineRunner commandLineRunA(MedicationRepository repository){
        return  args -> {
            Medication Aspirin = new Medication(
                    "Medication Aspirin",
                    15,
                    "xd2utw",
                    "/uploads/meds",
                    null

            );
            Medication Paracetamol = new Medication(
                    "Medication Paracetamol",
                    20,
                    "2prwj5",
                    "/uploads/meds",
                    null
            );
            repository.saveAll(List.of(Aspirin, Paracetamol));
        };
    }

}