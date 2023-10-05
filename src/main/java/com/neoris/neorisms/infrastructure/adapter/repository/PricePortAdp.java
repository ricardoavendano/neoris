package com.neoris.neorisms.infrastructure.adapter.repository;

import com.neoris.neorisms.domain.model.ResponseDTO;
import com.neoris.neorisms.domain.port.PricePort;
import com.neoris.neorisms.infrastructure.adapter.entity.PriceEntity;
import com.neoris.neorisms.infrastructure.adapter.exception.NoContentException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PricePortAdp implements PricePort {

  private final PriceCrudRepository priceCrudRepository;

  public PricePortAdp(PriceCrudRepository priceCrudRepository) {
    this.priceCrudRepository = priceCrudRepository;
  }

  @Override
  public ResponseDTO findPrices(Date applicationDate, Long productId, Long brandId) {
    Timestamp ts = new Timestamp(applicationDate.getTime());

    List<PriceEntity> prices =
        this.priceCrudRepository.findAllPricesMatches(ts, productId, brandId);

    if (prices.isEmpty()) {
      throw new NoContentException("No content");
    }

    ResponseDTO response = new ResponseDTO();
    response.setApplicationDate(ts.toString());
    response.setBrandId(prices.get(0).getBrandId());
    response.setBrandName(prices.get(0).getIdBrandPKEntity().getName());
    response.setStartDate(prices.get(0).getStartDate().toString());
    response.setEndDate(prices.get(0).getEndDate().toString());
    response.setProductId(prices.get(0).getProductId());
    response.setPrice(prices.get(0).getPrice());
    response.setPriceList(prices.get(0).getPriceList());
    return response;
  }
}
