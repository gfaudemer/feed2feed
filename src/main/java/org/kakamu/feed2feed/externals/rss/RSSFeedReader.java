package org.kakamu.feed2feed.externals.rss;

import com.apptasticsoftware.rssreader.Item;
import com.apptasticsoftware.rssreader.RssReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RSSFeedReader {

    @Value("${RSSFeedReader.urls}")
    List<String> urls;

    public List<Item> getLastMessages(int nLastMessages){
        var rssReader = new RssReader();
        return rssReader.read(urls)
                .limit(nLastMessages)
                .toList();
    }
}
