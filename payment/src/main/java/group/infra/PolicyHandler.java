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

    @Autowired
    PaymentHistoryRepository paymentHistoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LaundryCollectionRequestCanceled'"
    )
    public void wheneverLaundryCollectionRequestCanceled_결제취소(
        @Payload LaundryCollectionRequestCanceled laundryCollectionRequestCanceled
    ) {
        LaundryCollectionRequestCanceled event =
            laundryCollectionRequestCanceled;
        System.out.println(
            "\n\n##### listener 결제취소 : " +
            laundryCollectionRequestCanceled +
            "\n\n"
        );

        // Sample Logic //
        PaymentHistory.결제취소(event);
    }
    // keep

}
