package group.domain;

import group.domain.*;
import group.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CollectionMethodChanged extends AbstractEvent {

    private Long id;
    private String pickupMethod;
    private String status;

    public CollectionMethodChanged(LaundryHistory aggregate) {
        super(aggregate);
    }

    public CollectionMethodChanged() {
        super();
    }
    // keep

}
