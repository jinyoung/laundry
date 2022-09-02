package group.infra;

import group.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/laundryHistories")
@Transactional
public class LaundryHistoryController {

    @Autowired
    LaundryHistoryRepository laundryHistoryRepository;

    @RequestMapping(
        value = "laundryHistories/{id}/cancellation",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public LaundryHistory cancellation(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /laundryHistory/cancellation  called #####");
        Optional<LaundryHistory> optionalLaundryHistory = laundryHistoryRepository.findById(
            id
        );

        optionalLaundryHistory.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        LaundryHistory laundryHistory = optionalLaundryHistory.get();
        laundryHistory.cancellation();

        laundryHistoryRepository.save(laundryHistory);
        return laundryHistory;
    }

    @RequestMapping(
        value = "laundryHistories/{id}/changemethodtopickup",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public LaundryHistory changeMethodToPickup(
        @PathVariable(value = "id") Long id,
        @RequestBody ChangeMethodToPickupCommand changeMethodToPickupCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /laundryHistory/changeMethodToPickup  called #####"
        );
        Optional<LaundryHistory> optionalLaundryHistory = laundryHistoryRepository.findById(
            id
        );

        optionalLaundryHistory.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        LaundryHistory laundryHistory = optionalLaundryHistory.get();
        laundryHistory.changeMethodToPickup(changeMethodToPickupCommand);

        laundryHistoryRepository.save(laundryHistory);
        return laundryHistory;
    }
    // keep
}
