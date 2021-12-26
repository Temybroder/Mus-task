package com.project.drone.musalasoft.drone.battery;

import com.project.drone.musalasoft.drone.Drone;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table
public class Battery_level {
    @Id
    @SequenceGenerator(
            name = "battery_level_sequence",
            sequenceName = "battery_level_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "battery_level_sequence"
    )
    private Long battery_level_id;
    private Integer battery_level;
    private LocalDate time_checked;
    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "fk_drone_id")
    private Drone drone;

    public Battery_level(Long battery_level_id, Integer battery_level, LocalDate time_checked, Drone drone) {
        this.battery_level_id = battery_level_id;
        this.battery_level = battery_level;
        this.time_checked = time_checked;
        this.drone = drone;
    }

    public Battery_level() {
    }

    public Battery_level(Integer battery_level, LocalDate time_checked, Drone drone) {
        this.battery_level = battery_level;
        this.time_checked = time_checked;
        this.drone = drone;
    }

    public Long getBattery_level_id() {
        return battery_level_id;
    }

    public void setBattery_level_id(Long battery_level_id) {
        this.battery_level_id = battery_level_id;
    }

    public Integer getBattery_level() {
        return battery_level;
    }

    public void setBattery_level(Integer battery_level) {
        this.battery_level = battery_level;
    }

    public LocalDate getTime_checked() {
        return time_checked;
    }

    public void setTime_checked(LocalDate time_checked) {
        this.time_checked = time_checked;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    @Override
    public String toString() {
        return "Battery_level{" +
                "battery_level_id=" + battery_level_id +
                ", battery_level=" + battery_level +
                ", time_checked=" + time_checked +
                ", drone=" + drone +
                '}';
    }
}
