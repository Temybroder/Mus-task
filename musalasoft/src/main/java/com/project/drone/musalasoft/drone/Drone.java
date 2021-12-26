package com.project.drone.musalasoft.drone;

import com.project.drone.musalasoft.drone.battery.Battery_level;
import com.project.drone.musalasoft.medication.Medication;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Drone {
    @Id
    @SequenceGenerator(
            name = "drone_sequence",
            sequenceName = "drone_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "drone_sequence"
    )
    private Long drone_id;
    private String model;
    private Integer weight_limit;
    private String battery_capacity;
    private String state;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "fk_medication_id")
    List<Medication> medications = new ArrayList<>();
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "fk_battery_id")
    List<Battery_level> Drone_Battery_level = new ArrayList<>();

    public Drone(String model, Integer weight_limit, String battery_capacity, String state, List<Medication> medications, List<Battery_level> drone_Battery_level) {
        this.model = model;
        this.weight_limit = weight_limit;
        this.battery_capacity = battery_capacity;
        this.state = state;
        this.medications = medications;
        Drone_Battery_level = drone_Battery_level;
    }

    public Drone() {
    }

    public Drone(Long drone_id, String model, Integer weight_limit, String battery_capacity, String state, List<Medication> medications, List<Battery_level> drone_Battery_level) {
        this.drone_id = drone_id;
        this.model = model;
        this.weight_limit = weight_limit;
        this.battery_capacity = battery_capacity;
        this.state = state;
        this.medications = medications;
        Drone_Battery_level = drone_Battery_level;
    }


    public Long getDrone_id() {
        return drone_id;
    }

    public void setDrone_id(Long drone_id) {
        this.drone_id = drone_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getWeight_limit() {
        return weight_limit;
    }

    public void setWeight_limit(Integer weight_limit) {
        this.weight_limit = weight_limit;
    }

    public String getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(String battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public List<Battery_level> getDrone_Battery_level() {
        return Drone_Battery_level;
    }

    public void setDrone_Battery_level(List<Battery_level> drone_Battery_level) {
        Drone_Battery_level = drone_Battery_level;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "drone_id=" + drone_id +
                ", model='" + model + '\'' +
                ", weight_limit=" + weight_limit +
                ", battery_capacity='" + battery_capacity + '\'' +
                ", state='" + state + '\'' +
                ", medications=" + medications +
                ", Drone_Battery_level=" + Drone_Battery_level +
                '}';
    }
}
