package ru.alfa.checkratesapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alfa.checkratesapi.client.giphy.GifyClient;
import ru.alfa.checkratesapi.client.giphy.dto.GifyResponse;
import ru.alfa.checkratesapi.client.openExchangeRates.dto.ExchangeRatesResponse;
import ru.alfa.checkratesapi.configuration.CheckRatesProperties;
import ru.alfa.checkratesapi.client.openExchangeRates.ExchangeRatesClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Service
public class ExchangeRateService {

    private final CheckRatesProperties properties;
    private final ExchangeRatesClient exchangeRatesClient;
    private final GifyClient gifyClient;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String GIF_URI_REGEX = "GIF_URI";

    public String getVideo() {
        GifyResponse gifyResponse = getRandomGifByTag(getCurrencyComparison(properties.getCurrency()));

        return properties.getHtmlPage().replaceAll(GIF_URI_REGEX, extractUrlWithVideo(gifyResponse));
    }

    public String getGifUrl() {
        return extractUrlWithVideo(getRandomGifByTag(getCurrencyComparison(properties.getCurrency())));
    }

    private Integer getCurrencyComparison(String currency) {
        ExchangeRatesResponse ratesToday = exchangeRatesClient.getLastRates(properties.getRateAppId());
        ExchangeRatesResponse ratesArchived = exchangeRatesClient.getArchivedCourses(getYesterdayDate(), properties.getRateAppId());

        Double rateToday = ratesToday.getRates().get(currency);
        Double rateArchived = ratesArchived.getRates().get(currency);

        return rateToday.compareTo(rateArchived);
    }

    private GifyResponse getRandomGifByTag(Integer compareResult) {
        GifyResponse gif = null;
        if (compareResult == 1) {
            gif = gifyClient.getRandomGif(properties.getGiffyAppId(), properties.getRateUpTag());
        } else if (compareResult == -1) {
            gif = gifyClient.getRandomGif(properties.getGiffyAppId(), properties.getRateDownTag());
        }
        if (properties.getCheckEqualsRatesEnabled() && compareResult == 0) {
            gif = gifyClient.getRandomGif(properties.getGiffyAppId(), properties.getRateFlatTag());
        }

        return gif;
    }

    private String getYesterdayDate() {
        return LocalDate.now().minusDays(1).format(FORMATTER);
    }

    private String extractUrlWithVideo(GifyResponse gif) {
        if (gif != null && gif.getData() != null && gif.getData().getImages() != null
                && gif.getData().getImages().getOriginal() != null && gif.getData().getImages().getOriginal().getMp4() != null) {
            return gif.getData().getImages().getOriginal().getMp4();
        }

        return "";
    }

}
