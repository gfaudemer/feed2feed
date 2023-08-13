package org.kakamu.feed2feed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties
@ConfigurationPropertiesScan
public class Feed2FeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(Feed2FeedApplication.class,args);
    }
}
