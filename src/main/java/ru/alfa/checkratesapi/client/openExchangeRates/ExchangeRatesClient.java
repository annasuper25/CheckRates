package ru.alfa.checkratesapi.client.openExchangeRates;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alfa.checkratesapi.client.openExchangeRates.dto.ExchangeRatesResponse;

import static ru.alfa.checkratesapi.configuration.CheckRatesProperties.OPEN_RATE_ENDPOINT;

@FeignClient(
        name = "open-exchange-rates-client",
        url = OPEN_RATE_ENDPOINT
)
public interface ExchangeRatesClient {

    @GetMapping("/latest.json")
    ExchangeRatesResponse getLastRates(@RequestParam(value = "app_id") String appId);

    @GetMapping("/historical/{date}.json")
    ExchangeRatesResponse getArchivedCourses(@PathVariable String date,
                                             @RequestParam(value = "app_id") String appId);
}
