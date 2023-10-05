package com.neoris.neorisms.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDTO {

  private String brandName;
  private String startDate;
  private String endDate;
  private Long productId;
  private Long brandId;
  private Long priceList;
  private String applicationDate;
  private Float price;
}
