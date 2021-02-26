package ru.alfa.checkratesapi.client.giphy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OriginalStill {

    private String url;

    private String width;

    private String height;

    private String size;

}