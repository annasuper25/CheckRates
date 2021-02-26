package ru.alfa.checkratesapi.client.openExchangeRates.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRatesResponse {

    private String disclaimer;

    private String license;

    private String timestamp;

    private String base;

    private Map<String, Double> rates;


}
