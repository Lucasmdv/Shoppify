package org.stockify.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stockify.model.entity.ShiftEntity;

@Repository
public interface ShiftRepository extends JpaRepository<ShiftEntity,Long> {
}
