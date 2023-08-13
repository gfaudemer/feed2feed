package org.kakamu.feed2feed.scheduled;

import lombok.AllArgsConstructor;
import org.kakamu.feed2feed.domain.Feed2FeedService;
import org.kakamu.feed2feed.utils.DateUtils;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

import java.util.Date;

@Component
@AllArgsConstructor
public class Scheduler {

    private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);

    private final Feed2FeedService feed2FeedService;

    @Scheduled(cron = "${feed2feed.scheduler.cron}")
    public void copyLastMessages(){
        Date startDate = new Date();
        logger.info("Waking up: {}", DateUtils.dateFormat.format(startDate));

        int nbMessagesCopied = feed2FeedService.readFromMastodonAndCopy();

        logger.info("Going to sleep, treatmentTime {}ms, nb messages copied {}", DateUtils.treatmentTime(startDate), nbMessagesCopied);
    }
}
