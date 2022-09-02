package group.domain;

import group.PaymentApplication;
import group.domain.PaymentApproved;
import group.domain.PaymentCanceled;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PaymentHistory_table")
@Data
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long laundryId;

    @PostPersist
    public void onPostPersist() {
        PaymentCanceled paymentCanceled = new PaymentCanceled(this);
        paymentCanceled.publishAfterCommit();

        PaymentApproved paymentApproved = new PaymentApproved(this);
        paymentApproved.publishAfterCommit();
    }

    public static PaymentHistoryRepository repository() {
        PaymentHistoryRepository paymentHistoryRepository = PaymentApplication.applicationContext.getBean(
            PaymentHistoryRepository.class
        );
        return paymentHistoryRepository;
    }

    public static void 결제취소(
        LaundryCollectionRequestCanceled laundryCollectionRequestCanceled
    ) {
        /** Example 1:  new item 
        PaymentHistory paymentHistory = new PaymentHistory();
        repository().save(paymentHistory);

        */

        /** Example 2:  finding and process
        
        repository().findById(laundryCollectionRequestCanceled.get???()).ifPresent(paymentHistory->{
            
            paymentHistory // do something
            repository().save(paymentHistory);


         });
        */

    }
}
