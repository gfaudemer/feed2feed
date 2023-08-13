package org.kakamu.feed2feed.externals.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Message")
public class MessageEntity {

    @Id
    String guid;

    public String getGuid(){
        return guid;
    }

    public void setGuid(String guid){
        this.guid = guid;
    }
}
