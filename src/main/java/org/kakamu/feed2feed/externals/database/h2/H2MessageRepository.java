package org.kakamu.feed2feed.externals.database.h2;

import org.kakamu.feed2feed.externals.database.entities.MessageEntity;
import org.springframework.data.repository.CrudRepository;

public interface H2MessageRepository extends CrudRepository<MessageEntity, String> {

    MessageEntity findByGuid(String guid);
}
