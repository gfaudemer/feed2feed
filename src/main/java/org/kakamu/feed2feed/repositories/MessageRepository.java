package org.kakamu.feed2feed.repositories;

import org.kakamu.feed2feed.domain.Message;
import org.kakamu.feed2feed.externals.DatabaseAdapter;
import org.kakamu.feed2feed.externals.rss.RSSFeedReader;
import org.kakamu.feed2feed.externals.XClientApi;
import org.kakamu.feed2feed.externals.rss.RSSMapper;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class MessageRepository {
    @Autowired
    private RSSFeedReader rssFeedReader;
    @Autowired
    private DatabaseAdapter databaseAdapter;
    @Autowired
    private XClientApi xClientApi;

    private static final RSSMapper mapper = Mappers.getMapper(RSSMapper.class);

    private static final Logger logger = LoggerFactory.getLogger(MessageRepository.class);

    @Value("${Feed2X.nLastMessages}")
    private int nLastMessages;

    public List<Message> readLastMessages() {
        var lastMessages = mapper.map(rssFeedReader.getLastMessages(nLastMessages));
        if(logger.isDebugEnabled()) {
            lastMessages.stream().map(Message::toString).forEach(logger::debug);
        }
        return lastMessages;
    }

    public List<Message> filterAlreadyTreated(List<Message> lastMessages) {
        return Collections.emptyList();
    }

    public void writeMessages(List<Message> newMessages) {
    }

    public void save(List<Message> newMessages) {
    }
}
