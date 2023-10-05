package com.neoris.neorisms.infrastructure.repository;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import com.neoris.neorisms.infrastructure.adapter.entity.BrandEntity;
import com.neoris.neorisms.infrastructure.adapter.entity.PriceEntity;
import com.neoris.neorisms.infrastructure.adapter.exception.NoContentException;
import com.neoris.neorisms.infrastructure.adapter.repository.PriceCrudRepository;
import com.neoris.neorisms.infrastructure.adapter.repository.PricePortAdp;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PricePortAdpTest {

  private static final String DATE_FORMAT = "yyyy-MM-dd-HH.mm.ss";
  @InjectMocks private PricePortAdp pricePortAdp;
  @Mock private PriceCrudRepository priceCrudRepository;

  @Test
  void findPricesSuccessfully() throws ParseException {

    BrandEntity brand = new BrandEntity();
    brand.setIdBrand(1L);
    brand.setName("Zara");

    List<PriceEntity> priceList = new ArrayList<>();
    PriceEntity price = new PriceEntity();
    price.setPrice(35.50F);
    price.setBrandId(1L);
    price.setStartDate(
        new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-06-14-00.00.00").getTime()));
    price.setEndDate(
        new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-12-31-23.59.59").getTime()));
    price.setIdPrices(1L);
    price.setCurr("EUR");
    price.setIdBrandPKEntity(brand);
    price.setPriceList(1L);
    price.setProductId(35455L);
    price.setPriority(1L);
    priceList.add(price);

    when(priceCrudRepository.findAllPricesMatches(any(), anyLong(), anyLong()))
        .thenReturn(priceList);

    pricePortAdp.findPrices(
        new SimpleDateFormat(DATE_FORMAT).parse("2020-06-14-10.00.00"),
        Long.valueOf(35455),
        Long.valueOf(1));

    verify(priceCrudRepository, atLeast(1)).findAllPricesMatches(any(), anyLong(), anyLong());
  }

  @Test
  void findPricesNoContent() throws ParseException {

    when(priceCrudRepository.findAllPricesMatches(any(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());

    assertThrows(
        NoContentException.class,
        () ->
            pricePortAdp.findPrices(
                new SimpleDateFormat(DATE_FORMAT).parse("2020-06-14-10.00.00"),
                Long.valueOf(35455),
                Long.valueOf(1)));

    verify(priceCrudRepository, atLeast(1)).findAllPricesMatches(any(), anyLong(), anyLong());
  }
}
