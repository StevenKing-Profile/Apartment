package net.stevenking.apartment.repository;

import net.stevenking.apartment.data.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    @Query("SELECT DISTINCT a.apartmentKey.company FROM Apartment a")
    List<String> findDistinctCompany();
}
