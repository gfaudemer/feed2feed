package org.kakamu.feed2feed.externals.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "Message")
@Data
public class MessageEntity {

    @Id
    String guid;

}
