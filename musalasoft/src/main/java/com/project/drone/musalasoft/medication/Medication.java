package com.project.drone.musalasoft.medication;

import com.project.drone.musalasoft.drone.Drone;

import javax.persistence.*;

@Entity
@Table
public class Medication {
    @Id
    @SequenceGenerator(
            name = "medication_sequence",
            sequenceName = "medication_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "medication_sequence"
    )
    private Long medication_id;
    private String name;
    private Integer weight;
    private String code;
    private String imagePath;
    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "fk_drone_id")
    private Drone carrier_drone;

    public Medication(Long medication_id, String name, Integer weight, String code, String imagePath, Drone carrier_drone) {
        this.medication_id = medication_id;
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.imagePath = imagePath;
        this.carrier_drone = carrier_drone;
    }

    public Medication() {
    }

    public Medication(String name, Integer weight, String code, String imagePath, Drone carrier_drone) {
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.imagePath = imagePath;
        this.carrier_drone = carrier_drone;
    }

    public Long getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(Long medication_id) {
        this.medication_id = medication_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Drone getCarrier_drone() {
        return carrier_drone;
    }

    public void setCarrier_drone(Drone carrier_drone) {
        this.carrier_drone = carrier_drone;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medication_id=" + medication_id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", code='" + code + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", carrier_drone=" + carrier_drone +
                '}';
    }
}
