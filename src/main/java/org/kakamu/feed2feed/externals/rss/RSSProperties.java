package org.kakamu.feed2feed.externals.rss;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@ConfigurationProperties(prefix = "rss")
public record RSSProperties(
        @NotNull
        List<String> urls
) {}
