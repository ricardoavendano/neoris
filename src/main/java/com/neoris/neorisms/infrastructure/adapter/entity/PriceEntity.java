package com.neoris.neorisms.infrastructure.adapter.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prices")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceEntity implements Serializable {

  private static final long serialVersionUID = -5936329650033303260L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, name = "idprices")
  private Long idPrices;

  @JoinColumn(name = "IDBRANDPK", referencedColumnName = "IDBRAND", nullable = false)
  @ManyToOne(optional = false)
  private BrandEntity idBrandPKEntity;

  @Column(nullable = false, name = "brandid")
  private Long brandId;

  @Column(nullable = false, name = "startdate")
  private Timestamp startDate;

  @Column(nullable = false, name = "enddate")
  private Timestamp endDate;

  @Column(nullable = false, name = "pricelist")
  private Long priceList;

  @Column(nullable = false, name = "productid")
  private Long productId;

  @Column(nullable = false, name = "priority")
  private Long priority;

  @Column(nullable = false, name = "price")
  private Float price;

  @Column(nullable = false, name = "curr")
  private String curr;
}
