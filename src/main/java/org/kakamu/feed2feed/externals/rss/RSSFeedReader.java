package org.kakamu.feed2feed.externals.rss;

import com.apptasticsoftware.rssreader.Item;
import com.apptasticsoftware.rssreader.RssReader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class RSSFeedReader {

    RSSProperties rssProperties;

    public List<Item> getLastMessages(int nLastMessages){
        var rssReader = new RssReader();
        return rssReader.read(rssProperties.urls())
                .limit(nLastMessages)
                .toList();
    }
}
