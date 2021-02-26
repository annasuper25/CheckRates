package ru.alfa.checkratesapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.alfa.checkratesapi.client.giphy.GifyClient;
import ru.alfa.checkratesapi.client.giphy.dto.GIF;
import ru.alfa.checkratesapi.client.giphy.dto.GifyResponse;
import ru.alfa.checkratesapi.client.giphy.dto.Images;
import ru.alfa.checkratesapi.client.giphy.dto.Original;
import ru.alfa.checkratesapi.client.openExchangeRates.ExchangeRatesClient;
import ru.alfa.checkratesapi.client.openExchangeRates.dto.ExchangeRatesResponse;
import ru.alfa.checkratesapi.configuration.CheckRatesProperties;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ExchangeRateServiceTest {

    @Autowired
    ExchangeRateService exchangeRateService;

    @Autowired
    CheckRatesProperties properties;

    @MockBean
    GifyClient gifyClient;

    @MockBean
    ExchangeRatesClient exchangeRatesClient;

    private static final String TEST_HTML = "<html> <video controls=\"controls\"\" width=\"500\" height=\"400\" autoplay muted loop > <source src=\"rich.mp4\"> </video> </html>";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Test
    public void shouldReturnRateUpGifWhenRatesIncreased() {
        when(exchangeRatesClient.getLastRates(properties.getRateAppId())).thenReturn(createExchangeRatesResponse(74.5));
        when(exchangeRatesClient.getArchivedCourses(LocalDate.now().minusDays(1).format(FORMATTER), properties.getRateAppId()))
                .thenReturn(createExchangeRatesResponse(73.5));
        when(gifyClient.getRandomGif(properties.getGiffyAppId(), properties.getRateUpTag())).thenReturn(createGifyResponse("rich.mp4"));


    }

    @Test
    public void shouldReturnRateDownGifWhenRatesDecreased() {
        when(exchangeRatesClient.getLastRates(properties.getRateAppId())).thenReturn(createExchangeRatesResponse(74.5));
        when(exchangeRatesClient.getArchivedCourses(LocalDate.now().minusDays(1).format(FORMATTER), properties.getRateAppId()))
                .thenReturn(createExchangeRatesResponse(75.5));
        when(gifyClient.getRandomGif(properties.getGiffyAppId(), properties.getRateDownTag())).thenReturn(createGifyResponse("broke.mp4"));

        String url = exchangeRateService.getGifUrl();

        Assertions.assertEquals("broke.mp4", url);
    }

    @Test
    public void shouldReturnGifUrlIfRatesEqualsAndCheckEqualsRateEnable() {
        when(exchangeRatesClient.getLastRates(properties.getRateAppId())).thenReturn(createExchangeRatesResponse(74.5));
        when(exchangeRatesClient.getArchivedCourses(LocalDate.now().minusDays(1).format(FORMATTER), properties.getRateAppId()))
                .thenReturn(createExchangeRatesResponse(74.5));

        when(gifyClient.getRandomGif(properties.getGiffyAppId(), properties.getRateFlatTag())).thenReturn(createGifyResponse("mem.mp4"));

        String expectedUrl = exchangeRateService.getGifUrl();
        String url = "";

        if (properties.getCheckEqualsRatesEnabled() == Boolean.TRUE) {
            url = properties.getRateFlatTag() + ".mp4";
        }

        Assertions.assertEquals(url, expectedUrl);
    }

    @Test
    public void shouldReturnHtmlWithVideo() {
        when(exchangeRatesClient.getLastRates(properties.getRateAppId())).thenReturn(createExchangeRatesResponse(74.5));
        when(exchangeRatesClient.getArchivedCourses(LocalDate.now().minusDays(1).format(FORMATTER), properties.getRateAppId()))
                .thenReturn(createExchangeRatesResponse(73.5));
        when(gifyClient.getRandomGif(properties.getGiffyAppId(), properties.getRateUpTag())).thenReturn(createGifyResponse("rich.mp4"));

        String url = exchangeRateService.getVideo();

        Assertions.assertEquals(TEST_HTML, url);
    }

    private ExchangeRatesResponse createExchangeRatesResponse(Double rate) {
        Map<String, Double> currency = new HashMap<>();
        currency.put("RUB", rate);

        return ExchangeRatesResponse.builder()
                .rates(currency)
                .build();
    }

    private GifyResponse createGifyResponse(String url) {
        return GifyResponse.builder()
                .data(GIF.builder()
                        .images(Images.builder()
                                .original(Original.builder()
                                        .mp4(url)
                                        .build())
                                .build())
                        .build())
                .build();
    }
}
