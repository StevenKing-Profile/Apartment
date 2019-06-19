package net.stevenking.apartment.repository;

import net.stevenking.apartment.data.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
