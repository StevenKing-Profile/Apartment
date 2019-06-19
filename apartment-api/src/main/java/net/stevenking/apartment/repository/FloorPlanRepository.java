package net.stevenking.apartment.repository;

import net.stevenking.apartment.data.FloorPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorPlanRepository extends JpaRepository<FloorPlan, Long> {
    List<FloorPlan> findAllFloorPlanByCompany_Id(long id);
}
