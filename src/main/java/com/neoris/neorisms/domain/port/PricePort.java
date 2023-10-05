package com.neoris.neorisms.domain.port;

import com.neoris.neorisms.domain.model.ResponseDTO;
import java.util.Date;

public interface PricePort {

  ResponseDTO findPrices(Date applicationDate, Long productId, Long brandId);
}
