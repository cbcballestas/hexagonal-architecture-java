package com.mitocode.shop.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaProductClassSpringDataRepository extends JpaRepository<ProductJpaEntity, String> {

    @Query("SELECT p FROM ProductJpaEntity p WHERE p.name like ?1 or p.description like ?1")
    List<ProductJpaEntity> findByNameOrDescriptionLike(String pattern);
}
