package com.neoris.neorisms.infrastructure.rest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import com.neoris.neorisms.application.service.PriceService;
import com.neoris.neorisms.domain.model.ResponseDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class PriceControllerTest {

  private static final String DATE_FORMAT = "yyyy-MM-dd-HH.mm.ss";
  @InjectMocks private PriceController priceController;
  @Mock private PriceService priceService;

  @Test
  void checkPricesSuccessfully() throws ParseException {

    ResponseDTO responseDTO = new ResponseDTO();

    when(priceService.findPrices(any(), anyLong(), anyLong())).thenReturn(responseDTO);

    ResponseEntity<?> res =
        priceController.checkPrices(
            new SimpleDateFormat(DATE_FORMAT).parse("2020-06-16-21.00.00"),
            Long.valueOf(35455),
            Long.valueOf(1));

    verify(priceService, atLeast(1)).findPrices(any(), anyLong(), anyLong());
    assertEquals(HttpStatus.OK, res.getStatusCode());
  }
}
