package com.neoris.neorisms.infrastructure.rest.controller;

import com.neoris.neorisms.application.service.PriceService;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
@Slf4j
public class PriceController {

  private final PriceService priceService;

  public PriceController(PriceService priceService) {
    this.priceService = priceService;
  }

  @GetMapping
  public ResponseEntity<?> checkPrices(
      @RequestParam("applicationDate") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
          Date applicationDate,
      @RequestParam("productId") Long productId,
      @RequestParam("brandId") Long brandId) {

    return new ResponseEntity<>(
        this.priceService.findPrices(applicationDate, productId, brandId), HttpStatus.OK);
  }
}
