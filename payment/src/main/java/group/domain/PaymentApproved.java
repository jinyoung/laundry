package group.domain;

import group.domain.*;
import group.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PaymentApproved extends AbstractEvent {

    private Long id;
    private Long laundryId;

    public PaymentApproved(PaymentHistory aggregate) {
        super(aggregate);
    }

    public PaymentApproved() {
        super();
    }
    // keep

}
