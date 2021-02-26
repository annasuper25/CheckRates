package ru.alfa.checkratesapi.client.giphy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GifyResponse {

    private GIF data;

    private Meta meta;
}
