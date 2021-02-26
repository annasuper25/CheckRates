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
public class DownsizedSmall {

    private String mp4;

    private String width;

    private String height;

    @JsonProperty("mp4_size")
    private String mp4Size;

}