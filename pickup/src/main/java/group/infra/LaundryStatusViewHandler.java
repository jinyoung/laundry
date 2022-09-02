package group.infra;

import group.config.kafka.KafkaProcessor;
import group.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class LaundryStatusViewHandler {

    @Autowired
    private LaundryStatusRepository laundryStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLaundryCollectionRequested_then_CREATE_1(
        @Payload LaundryCollectionRequested laundryCollectionRequested
    ) {
        try {
            if (!laundryCollectionRequested.validate()) return;

            // view 객체 생성
            LaundryStatus laundryStatus = new LaundryStatus();
            // view 객체에 이벤트의 Value 를 set 함
            laundryStatus.setId(laundryCollectionRequested.getId());
            laundryStatus.setStatus("요청됨");
            // view 레파지 토리에 save
            laundryStatusRepository.save(laundryStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_1(
        @Payload DeliveryStarted deliveryStarted
    ) {
        try {
            if (!deliveryStarted.validate()) return;
            // view 객체 조회
            Optional<LaundryStatus> laundryStatusOptional = laundryStatusRepository.findById(
                deliveryStarted.getLaundryId()
            );

            if (laundryStatusOptional.isPresent()) {
                LaundryStatus laundryStatus = laundryStatusOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                laundryStatus.setStatus("완료됨");
                // view 레파지 토리에 save
                laundryStatusRepository.save(laundryStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // keep

}
