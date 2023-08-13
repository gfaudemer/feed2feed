package org.kakamu.feed2feed.externals.database;

import lombok.AllArgsConstructor;
import org.kakamu.feed2feed.domain.message.Message;
import org.kakamu.feed2feed.externals.database.h2.H2Mapper;
import org.kakamu.feed2feed.externals.database.h2.H2MessageRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class DatabaseAdapter {

    private static final H2Mapper mapper = Mappers.getMapper(H2Mapper.class);

    private final H2MessageRepository h2MessageRepository;

    public boolean doesNotExist(Message message){
        return Optional.ofNullable(h2MessageRepository.findByGuid(message.getGuid())).isEmpty();
    }

    public void save(List<Message> newMessages) {
        h2MessageRepository.saveAll(mapper.map(newMessages));
    }
}
