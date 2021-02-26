package ru.alfa.checkratesapi.client.giphy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bouncycastle.cms.PasswordRecipientId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("banner_url")
    private String bannerUrl;

    @JsonProperty("profile_url")
    private String profileUrl;

    private String username;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("banner_image")
    private String bannerImage;

    private String description;

    @JsonProperty("is_verified")
    private Boolean isverified;

    @JsonProperty("website_url")
    private String websiteUrl;


    @JsonProperty("instagram_url")
    private String instagramUrl;

}
