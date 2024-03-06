package com.stock.dataproducer.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StockController {

    private final SimpMessagingTemplate template;
    private final StockService stockService;

    @Scheduled(fixedRate = 5)
    public void sendStockOnTheRegular() {

        long[] stocks = stockService.getStocks();
        template.convertAndSend("/topic/stock", stocks);
    }
}
