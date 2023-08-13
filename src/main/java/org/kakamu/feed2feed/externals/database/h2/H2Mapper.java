package org.kakamu.feed2feed.externals.database.h2;

import org.kakamu.feed2feed.domain.message.Message;
import org.kakamu.feed2feed.externals.database.entities.MessageEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface H2Mapper {

    default MessageEntity map(Message message){
        var entity = new MessageEntity();
        entity.setGuid(message.getGuid());
        return entity;
    }

    List<MessageEntity> map(List<Message> messages);
}
