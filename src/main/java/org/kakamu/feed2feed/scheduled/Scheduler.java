package org.kakamu.feed2feed.scheduled;

import org.kakamu.feed2feed.domain.Feed2FeedService;
import org.kakamu.feed2feed.utils.DateUtils;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

import java.util.Date;

@Component
public class Scheduler {

    private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);

    private final Feed2FeedService feed2FeedService;

    public Scheduler(Feed2FeedService feed2FeedService){
        this.feed2FeedService = feed2FeedService;
    }

    @Scheduled(cron = "${Feed2X.cron}")
    public void copyLastMessages(){
        Date startDate = new Date();
        logger.info("Waking up: {}", DateUtils.dateFormat.format(startDate));

        int nbMessagesCopied = feed2FeedService.readFromMastodonAndCopy();

        logger.info("Going to sleep, treatmentTime {}ms, nb messages copied {}", DateUtils.treatmentTime(startDate), nbMessagesCopied);
    }
}
