package org.kakamu.feed2feed.domain;

public class Message {
    private String title;
    private String description;
    private String link;
    private String author;
    private String guid;
    private String pubDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

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
