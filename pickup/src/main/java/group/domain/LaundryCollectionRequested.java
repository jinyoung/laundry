package group.domain;

import group.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class LaundryCollectionRequested extends AbstractEvent {

    private Long id;
    private String pickupMethod;
    private String status;
}
