package org.kakamu.feed2feed.repositories;

import org.kakamu.feed2feed.domain.Message;
import org.kakamu.feed2feed.externals.database.DatabaseAdapter;
import org.kakamu.feed2feed.externals.rss.RSSFeedReader;
import org.kakamu.feed2feed.externals.XClientApi;
import org.kakamu.feed2feed.externals.rss.RSSMapper;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageRepository {

    private static final RSSMapper mapper = Mappers.getMapper(RSSMapper.class);
    private static final Logger logger = LoggerFactory.getLogger(MessageRepository.class);

    private final RSSFeedReader rssFeedReader;
    private final DatabaseAdapter databaseAdapter;
    private final XClientApi xClientApi;

    public MessageRepository(RSSFeedReader rssFeedReader,
                             DatabaseAdapter databaseAdapter,
                             XClientApi xClientApi){
        this.databaseAdapter = databaseAdapter;
        this.rssFeedReader = rssFeedReader;
        this.xClientApi = xClientApi;
    }

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
        return lastMessages.stream().filter(databaseAdapter::doesNotExist).toList();
    }

    public void writeMessages(List<Message> newMessages) {
    }

    public void save(List<Message> newMessages) {
        databaseAdapter.save(newMessages);
    }
}
