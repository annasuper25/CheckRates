package ru.alfa.checkratesapi.client.giphy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Images {

    private FixedHeight fixedHeight;

    private FixedHeightStill fixedHeightStill;

    private FixedHeightDownsampled fixedHeightDownsampled;

    private FixedWidth fixedWidth;

    private FixedWidthStill fixedWidthStill;

    private FixedWidthDownsampled fixedWidthDownsampled;

    private FixedHeightSmall fixedHeightSmall;

    private FixedHeightSmallStill fixedHeightSmallStill;

    private FixedWidthSmall fixedWidthSmall;

    private FixedWidthSmallStill fixedWidthSmallStill;

    private Downsized downsized;

    private DownsizedStill downsizedStill;

    private DownsizedLarge downsizedLarge;

    private DownsizedMedium downsizedMedium;

    private DownsizedSmall downsizedSmall;

    private Original original;

    private OriginalStill originalStill;

    private Looping looping;

    private Preview preview;

    private PreviewGif previewGif;

}
