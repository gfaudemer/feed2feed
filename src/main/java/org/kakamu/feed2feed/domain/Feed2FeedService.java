package org.kakamu.feed2feed.domain;

import org.kakamu.feed2feed.repositories.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Feed2FeedService {

    private static final Logger logger = LoggerFactory.getLogger(Feed2FeedService.class);

    private final MessageRepository messageRepository;

    public Feed2FeedService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public int readFromMastodonAndCopy(){
        logger.debug("Starting treatment");
        var lastMessages = messageRepository.readLastMessages();
        logger.debug("Read last {} messages from RSS, filtering...", lastMessages.size());
        var newMessages = messageRepository.filterAlreadyTreated(lastMessages);
        logger.debug("{} new messages found, writing to X", newMessages.size());
        messageRepository.writeMessages(newMessages);
        logger.debug("Saving messages...");
        messageRepository.save(newMessages);
        logger.debug("End of treatment");
        return newMessages.size();
    }
}
