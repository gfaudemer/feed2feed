package org.kakamu.feed2feed.externals.rss;

import com.apptasticsoftware.rssreader.Item;
import org.kakamu.feed2feed.domain.message.Message;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface RSSMapper {

    Message map(Item item);

    List<Message> map(List<Item> items);

    default String map(Optional<String> opObj){
        return opObj.orElse(null);
    }

}
