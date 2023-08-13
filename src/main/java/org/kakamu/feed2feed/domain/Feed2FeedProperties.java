package org.kakamu.feed2feed.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "feed2feed.domain")
public record Feed2FeedProperties(
        @Min(1)
        @Max(20)
        int nLastMessages
){}
