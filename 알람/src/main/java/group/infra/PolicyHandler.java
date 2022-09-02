package group.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import group.config.kafka.KafkaProcessor;
import group.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_카톡알림처리(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener 카톡알림처리 : " + deliveryStarted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryRequestCanceled'"
    )
    public void wheneverDeliveryRequestCanceled_카톡알림처리(
        @Payload DeliveryRequestCanceled deliveryRequestCanceled
    ) {
        DeliveryRequestCanceled event = deliveryRequestCanceled;
        System.out.println(
            "\n\n##### listener 카톡알림처리 : " +
            deliveryRequestCanceled +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LaundryCollectionRequested'"
    )
    public void wheneverLaundryCollectionRequested_카톡알림처리(
        @Payload LaundryCollectionRequested laundryCollectionRequested
    ) {
        LaundryCollectionRequested event = laundryCollectionRequested;
        System.out.println(
            "\n\n##### listener 카톡알림처리 : " +
            laundryCollectionRequested +
            "\n\n"
        );
        // Sample Logic //

    }
    // keep

}
