package group.infra;

import group.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class LaundryHistoryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<LaundryHistory>> {

    @Override
    public EntityModel<LaundryHistory> process(
        EntityModel<LaundryHistory> model
    ) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/cancellation")
                .withRel("cancellation")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/changemethodtopickup"
                )
                .withRel("changemethodtopickup")
        );

        return model;
    }
}
