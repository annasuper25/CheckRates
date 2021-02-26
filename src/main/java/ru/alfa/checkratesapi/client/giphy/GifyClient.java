package ru.alfa.checkratesapi.client.giphy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alfa.checkratesapi.client.giphy.dto.GifyResponse;

import static ru.alfa.checkratesapi.configuration.CheckRatesProperties.GIFY_RANDOM_ENDPOINT;

@FeignClient(
        name = "gify-client",
        url = GIFY_RANDOM_ENDPOINT
)
public interface GifyClient {

    @GetMapping
    GifyResponse getRandomGif(@RequestParam(value = "api_key") String apiKey,
                              @RequestParam(value = "tag") String tag);
}