package ru.alfa.checkratesapi.client.giphy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Original {

    private String height;

    private String size;

    private String frames;

    private String mp4;

    private String webp;

    @JsonProperty("webp_size")
    private String webpSize;

    private String hash;

    @JsonProperty("mp4_size")
    private String mp4Size;

    private String url;

    private String width;

}