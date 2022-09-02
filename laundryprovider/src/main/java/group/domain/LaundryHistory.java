package group.domain;

import group.LaundryproviderApplication;
import group.domain.DeliveryRequestCanceled;
import group.domain.DeliveryStarted;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "LaundryHistory_table")
@Data
public class LaundryHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long laundryId;

    @PostPersist
    public void onPostPersist() {
        DeliveryRequestCanceled deliveryRequestCanceled = new DeliveryRequestCanceled(
            this
        );
        deliveryRequestCanceled.publishAfterCommit();

        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    public static LaundryHistoryRepository repository() {
        LaundryHistoryRepository laundryHistoryRepository = LaundryproviderApplication.applicationContext.getBean(
            LaundryHistoryRepository.class
        );
        return laundryHistoryRepository;
    }

    public static void 세탁물접수됨(PaymentApproved paymentApproved) {
        /** Example 1:  new item 
        LaundryHistory laundryHistory = new LaundryHistory();
        repository().save(laundryHistory);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentApproved.get???()).ifPresent(laundryHistory->{
            
            laundryHistory // do something
            repository().save(laundryHistory);


         });
        */

    }

    public static void 수거방법변경처리(
        CollectionMethodChanged collectionMethodChanged
    ) {
        /** Example 1:  new item 
        LaundryHistory laundryHistory = new LaundryHistory();
        repository().save(laundryHistory);

        */

        /** Example 2:  finding and process
        
        repository().findById(collectionMethodChanged.get???()).ifPresent(laundryHistory->{
            
            laundryHistory // do something
            repository().save(laundryHistory);


         });
        */

    }

    public static void 세탁물접수취소(PaymentCanceled paymentCanceled) {
        /** Example 1:  new item 
        LaundryHistory laundryHistory = new LaundryHistory();
        repository().save(laundryHistory);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentCanceled.get???()).ifPresent(laundryHistory->{
            
            laundryHistory // do something
            repository().save(laundryHistory);


         });
        */

    }
}
