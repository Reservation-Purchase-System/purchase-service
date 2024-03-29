package com.nayoon.purchase_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "stockClient", url = "${feign.stockClient.url}")
public interface StockClient {

  /**
   * stock_service에 재고 감소 요청
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/internal/stocks/decrease", consumes = "application/json")
  void decreaseProductStock(@RequestParam(name = "id") Long productId, @RequestParam(name = "quantity") Integer quantity);

  /**
   * stock_service에 재고 증가 요청
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/internal/stocks/increase", consumes = "application/json")
  void increaseProductStock(@RequestParam(name = "id") Long productId, @RequestParam(name = "quantity") Integer quantity);


  /**
   * stock_service에 재고 조회 요청
   */
  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/internal/stocks/{productId}", consumes = "application/json")
  Integer getRemainingProductStock(@PathVariable(name = "productId") Long productId);

}
