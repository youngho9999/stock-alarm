package com.stock.dataproducer.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class StockService {

    private long[] stocks = {1000L, 10000L, 50000L, 200000L};
    private final Random random;

    public long[] getStocks() {
        for(int i = 0; i < stocks.length; i++) {
            stocks[i] = stockChange(stocks[i]);
        }
        return stocks;
    }

    private long stockChange(long value) {
        double randomValue = -0.01 + 0.02 * random.nextDouble();
        return Math.round(value + value * randomValue);
    }

}
