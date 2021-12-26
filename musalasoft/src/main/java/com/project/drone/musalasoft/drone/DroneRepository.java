package com.project.drone.musalasoft.drone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {

    @Query("SELECT s FROM Drone s WHERE s.drone_id = ?1")
    Optional<Drone> findDroneById(Long drone_id);

    @Query("SELECT s FROM Drone s WHERE s.drone_id = ?1")
    Optional<Drone> fetchDroneById(Long drone_id);

    @Query("SELECT s FROM Drone s WHERE s.state = ?1")
    List<Drone> findDroneByState(String state);
}
