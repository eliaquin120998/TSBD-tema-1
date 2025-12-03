package org.eliaquinsystems.maraton.repository;

import org.eliaquinsystems.maraton.entity.Corredor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorredorRepository extends JpaRepository<Corredor, Long> {
}
