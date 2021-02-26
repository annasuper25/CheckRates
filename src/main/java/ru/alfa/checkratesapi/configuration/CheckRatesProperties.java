package ru.alfa.checkratesapi.configuration;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "main")
public class CheckRatesProperties {

    private String rateAppId;
    private String giffyAppId;
    private String currency;
    private String rateUpTag;
    private String rateDownTag;
    private String rateFlatTag;
    private Boolean checkEqualsRatesEnabled;
    private String htmlPage;
    public static final String OPEN_RATE_ENDPOINT = "https://openexchangerates.org/api";
    public static final String GIFY_RANDOM_ENDPOINT = "api.giphy.com/v1/gifs/random";
}
