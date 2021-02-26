package ru.alfa.checkratesapi.client.giphy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreviewGif {

    private String url;

    private String width;

    private String height;

    private String size;
}