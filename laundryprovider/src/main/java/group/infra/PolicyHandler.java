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
    LaundryHistoryRepository laundryHistoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentApproved'"
    )
    public void wheneverPaymentApproved_세탁물접수됨(
        @Payload PaymentApproved paymentApproved
    ) {
        PaymentApproved event = paymentApproved;
        System.out.println(
            "\n\n##### listener 세탁물접수됨 : " + paymentApproved + "\n\n"
        );

        // Sample Logic //
        LaundryHistory.세탁물접수됨(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CollectionMethodChanged'"
    )
    public void wheneverCollectionMethodChanged_수거방법변경처리(
        @Payload CollectionMethodChanged collectionMethodChanged
    ) {
        CollectionMethodChanged event = collectionMethodChanged;
        System.out.println(
            "\n\n##### listener 수거방법변경처리 : " +
            collectionMethodChanged +
            "\n\n"
        );

        // Sample Logic //
        LaundryHistory.수거방법변경처리(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentCanceled'"
    )
    public void wheneverPaymentCanceled_세탁물접수취소(
        @Payload PaymentCanceled paymentCanceled
    ) {
        PaymentCanceled event = paymentCanceled;
        System.out.println(
            "\n\n##### listener 세탁물접수취소 : " + paymentCanceled + "\n\n"
        );

        // Sample Logic //
        LaundryHistory.세탁물접수취소(event);
    }
    // keep

}
