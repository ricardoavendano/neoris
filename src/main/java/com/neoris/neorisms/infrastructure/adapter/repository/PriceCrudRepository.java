package com.neoris.neorisms.infrastructure.adapter.repository;

import com.neoris.neorisms.infrastructure.adapter.entity.PriceEntity;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceCrudRepository extends CrudRepository<PriceEntity, Long> {

  @Query(
      "SELECT p FROM PriceEntity p WHERE p.startDate <= :applicationDate AND p.endDate >= :applicationDate AND p.productId = :productId AND p.brandId = :brandId ORDER BY p.priority DESC")
  List<PriceEntity> findAllPricesMatches(
      @Param("applicationDate") Timestamp applicationDate,
      @Param("productId") Long productId,
      @Param("brandId") Long brandId);
}
