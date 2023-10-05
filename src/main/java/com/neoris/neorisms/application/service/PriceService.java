package com.neoris.neorisms.application.service;

import com.neoris.neorisms.domain.model.ResponseDTO;
import java.util.Date;

public interface PriceService {
  ResponseDTO findPrices(Date applicationDate, Long productId, Long brandId);
}
