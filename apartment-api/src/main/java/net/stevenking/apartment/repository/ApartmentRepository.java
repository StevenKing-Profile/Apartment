package net.stevenking.apartment.repository;

import net.stevenking.apartment.data.Apartment;
import net.stevenking.apartment.data.FloorPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    List<Apartment> findApartmentByFloorPlan(FloorPlan floorPlan);

    List<String> findRoomNumberByFloorPlan(FloorPlan floorPlan);

    Apartment findApartmentByRoomNumberAndAndFloorPlan();
}

