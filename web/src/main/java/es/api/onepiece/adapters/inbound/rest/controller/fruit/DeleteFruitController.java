package es.api.onepiece.adapters.inbound.rest.controller.fruit;

import es.api.onepiece.core.internal.usecases.fruit.DeleteFruitUseCase;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.DeleteFruitV1Api;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class DeleteFruitController.
 */
@RestController
@Validated
@RequiredArgsConstructor
public class DeleteFruitController implements DeleteFruitV1Api {

    /** The delete fruit use case. */
    private final DeleteFruitUseCase deleteFruitUseCase;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> deleteFruitV1(@NotNull final Integer id) {
        this.deleteFruitUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
