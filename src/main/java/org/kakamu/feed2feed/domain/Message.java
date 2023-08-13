package org.kakamu.feed2feed.domain;

import lombok.Data;

@Data
public class Message {

    private String title;
    private String description;
    private String link;
    private String author;
    private String guid;
    private String pubDate;

    @Override
    public String toString(){
        return String.format("""
                {
                  guid: %s,
                  title: %s,
                  description: %s,
                  author: %s,
                  link: %s,
                  pubDate: %s
                }
                """, guid, title, description, author, link, pubDate);
    }
}
