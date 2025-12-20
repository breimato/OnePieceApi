package es.api.onepiece.adapters.inbound.rest.controller.character.transformation;

import es.api.onepiece.core.internal.usecases.character.transformation.DeleteTransformationUseCase;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.DeleteTransformationV1Api;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class DeleteTransformationController.
 */
@RestController
@Validated
@RequiredArgsConstructor
public class DeleteTransformationController implements DeleteTransformationV1Api {

    /** The delete transformation use case. */
    private final DeleteTransformationUseCase deleteTransformationUseCase;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> deleteTransformationV1(@NotNull final Integer id) {
        this.deleteTransformationUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
