package com.mitocode.shop.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaCartClassSpringDataRepository extends JpaRepository<CartJpaEntity, Integer> {
    //    @Query("SELECT c FROM CartJpaEntity c WHERE c.customerId = ?1")
    Optional<CartJpaEntity> findByCustomerId(Integer customerId);
}
