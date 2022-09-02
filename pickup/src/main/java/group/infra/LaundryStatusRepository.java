package group.infra;

import group.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "laundryStatuses",
    path = "laundryStatuses"
)
public interface LaundryStatusRepository
    extends PagingAndSortingRepository<LaundryStatus, Long> {
    // keep

}
