package group.domain;

import group.PickupApplication;
import group.domain.LaundryCollectionRequested;
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

    private String pickupMethod;

    private String status;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        group.external.PaymentHistory paymentHistory = new group.external.PaymentHistory();
        // mappings goes here
        PickupApplication.applicationContext
            .getBean(group.external.PaymentHistoryService.class)
            .pay(paymentHistory);

        LaundryCollectionRequested laundryCollectionRequested = new LaundryCollectionRequested(
            this
        );
        laundryCollectionRequested.publishAfterCommit();
    }

    public static LaundryHistoryRepository repository() {
        LaundryHistoryRepository laundryHistoryRepository = PickupApplication.applicationContext.getBean(
            LaundryHistoryRepository.class
        );
        return laundryHistoryRepository;
    }

    public void cancellation() {
        LaundryCollectionRequestCanceled laundryCollectionRequestCanceled = new LaundryCollectionRequestCanceled(
            this
        );
        laundryCollectionRequestCanceled.publishAfterCommit();
    }

    public void changeMethodToPickup(
        ChangeMethodToPickupCommand changeMethodToPickupCommand
    ) {
        CollectionMethodChanged collectionMethodChanged = new CollectionMethodChanged(
            this
        );
        collectionMethodChanged.publishAfterCommit();
    }

    public static void updateStatus(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        LaundryHistory laundryHistory = new LaundryHistory();
        repository().save(laundryHistory);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(laundryHistory->{
            
            laundryHistory // do something
            repository().save(laundryHistory);


         });
        */

    }
}
