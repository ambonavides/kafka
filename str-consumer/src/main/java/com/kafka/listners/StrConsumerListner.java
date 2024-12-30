package com.kafka.listners;

import com.kafka.custom.StrConsumerCustomListner;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListner {

    @SneakyThrows
    @StrConsumerCustomListner(groupId = "group-1")
    public void create(String message) {
       log.info("CREATE ::: Receive message {}", message);
       throw new IllegalAccessException("This is an exception");
    }

    @StrConsumerCustomListner(groupId = "group-1")
    public void log(String message) {
        log.info("LOG ::: Receive message {}", message);
    }

    @KafkaListener(groupId = "group-2",
            topics = "str-topic",
            containerFactory = "validMassageContainerFactory")
    public void history(String message) {
        log.info("HISTORY ::: Receive message {}", message);
    }

}
