package ru.alfa.checkratesapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.alfa.checkratesapi.service.ExchangeRateService;

@RestController
@RequiredArgsConstructor
public class CheckRateController {

    static final String URL = "/url";
    static final String GIF = "/gif";

    private final ExchangeRateService exchangeRateService;

    @GetMapping(GIF)
    public String getGifByCurrency() {

        return exchangeRateService.getVideo();
    }

    @GetMapping(URL)
    public String getGifUrlByCurrency() {

        return exchangeRateService.getGifUrl();
    }

}
