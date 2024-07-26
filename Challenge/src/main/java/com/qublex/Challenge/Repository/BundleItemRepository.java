package com.qublex.Challenge.Repository;

import com.qublex.Challenge.Entity.BundleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BundleItemRepository extends JpaRepository<BundleItem, Long> {
    Optional<BundleItem> findByDesignation(String designation);
}
