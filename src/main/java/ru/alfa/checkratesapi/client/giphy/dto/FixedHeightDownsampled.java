package ru.alfa.checkratesapi.client.giphy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FixedHeightDownsampled {

    private String url;

    private String width;

    private String height;

    private String size;

    private String webp;

    @JsonProperty("webp_size")
    private String webpSize;
}
