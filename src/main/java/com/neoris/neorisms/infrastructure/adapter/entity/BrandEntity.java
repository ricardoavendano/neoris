package com.neoris.neorisms.infrastructure.adapter.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "brand")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandEntity implements Serializable {

  private static final long serialVersionUID = -629636322850605729L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, name = "idbrand")
  private Long idBrand;

  @Column(nullable = false, name = "name")
  private String name;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBrandPKEntity")
  private List<PriceEntity> brandList;
}
