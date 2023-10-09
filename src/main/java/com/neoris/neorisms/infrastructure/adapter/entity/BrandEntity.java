package com.neoris.neorisms.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "brand")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
