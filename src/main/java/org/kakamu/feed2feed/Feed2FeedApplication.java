package org.kakamu.feed2feed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Feed2FeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(Feed2FeedApplication.class,args);
    }
}
