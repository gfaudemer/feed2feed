package org.kakamu.feed2feed.externals.database;

import lombok.AllArgsConstructor;
import org.kakamu.feed2feed.domain.Message;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class DatabaseAdapter {

    private static final H2Mapper mapper = Mappers.getMapper(H2Mapper.class);

    private final MessageH2Repository messageH2Repository;

    public boolean doesNotExist(Message message){
        return Optional.ofNullable(messageH2Repository.findByGuid(message.getGuid())).isEmpty();
    }

    public void save(List<Message> newMessages) {
        messageH2Repository.saveAll(mapper.map(newMessages));
    }
}
