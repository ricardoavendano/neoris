package com.neoris.neorisms.application.service;

import com.neoris.neorisms.domain.model.ResponseDTO;
import com.neoris.neorisms.domain.port.PricePort;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class DomainPriceService implements PriceService {

  private final PricePort pricePort;

  public DomainPriceService(PricePort pricePort) {
    this.pricePort = pricePort;
  }

  @Override
  public ResponseDTO findPrices(Date applicationDate, Long productId, Long brandId) {
    return this.pricePort.findPrices(applicationDate, productId, brandId);
  }
}
