package net.stevenking.apartment.repository;

import net.stevenking.apartment.data.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Long> {

}
