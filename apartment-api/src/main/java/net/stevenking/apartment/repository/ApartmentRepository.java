package net.stevenking.apartment.repository;

import net.stevenking.apartment.data.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

}
