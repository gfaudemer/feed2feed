package org.kakamu.feed2feed.externals.database;

import org.kakamu.feed2feed.externals.database.entities.MessageEntity;
import org.springframework.data.repository.CrudRepository;

public interface MessageH2Repository extends CrudRepository<MessageEntity, String> {

    MessageEntity findByGuid(String guid);
}
