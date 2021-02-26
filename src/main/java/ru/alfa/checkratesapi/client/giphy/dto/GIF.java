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
public class GIF {

    private String type;

    private String id;

    private String slug;

    private String url;

    @JsonProperty("bitly_url")
    private String bitlyUrl;

    @JsonProperty("bitly_gif_url")
    private String bitlyGiffUrl;

    @JsonProperty("embed_url")
    private String embedUrl;

    private String username;

    private String source;

    private String title;

    private String rating;

    @JsonProperty("content_url")
    private String contentUrl;

    @JsonProperty("source_tld")
    private String sourceTld;

    @JsonProperty("source_post_url")
    private String sourcePostUrl;

    //Boolean but in JSON 0
    @JsonProperty("is_sticker")
    private Integer isSticker;

    @JsonProperty("updateDatetime")
    private String update_datetime;

    @JsonProperty("create_datetime")
    private String createDatetime;

    @JsonProperty("import_datetime")
    private String importDatetime;

    @JsonProperty("trending_datetime")
    private String trendingDatetime;

    private Images images;

    private User user;


    @JsonProperty("image_original_url")
    private String imageOriginalUrl;

    @JsonProperty("image_mp4_url")
    private String imageMp4Url;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("image_frames")
    private String imageFrames;

    @JsonProperty("image_width")
    private String imageWidth;

    @JsonProperty("image_height")
    private String imageHeight;

    @JsonProperty("fixed_height_downsampled_url")
    private String fixedHeightDownsampledUrl;

    @JsonProperty("fixed_height_downsampled_width")
    private String fixedHeightDownsampledWidth;

    @JsonProperty("fixed_height_downsampled_height")
    private String fixedHeightDownsampledHeight;

    @JsonProperty("fixed_width_downsampled_url")
    private String fixedWidthDownsampledUrl;

    @JsonProperty("fixed_width_downsampled_width")
    private String fixedWidthDownsampledWidth;

    @JsonProperty("fixed_width_downsampled_height")
    private String fixedWidthDownsampledHeight;


    @JsonProperty("fixed_height_small_url")
    private String fixedHeightSmallUrl;


    @JsonProperty("fixed_height_small_still_url")
    private String fixedHeightSmallStillUrl;


    @JsonProperty("fixed_height_small_width")
    private String fixedHeightSmallWidth;


    @JsonProperty("fixed_height_small_height")
    private String fixedHeightSmallHeight;


    @JsonProperty("fixed_width_small_url")
    private String fixedWidthSmallUrl;


    @JsonProperty("fixed_width_small_still_url")
    private String fixedWidthSmallStillUrl;


    @JsonProperty("fixed_width_small_width")
    private String fixedWidthSmallWidth;


    @JsonProperty("fixedWidthSmallHeight")
    private String fixed_width_small_height;

    private String caption;

}