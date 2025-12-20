package es.api.onepiece.adapters.inbound.rest.controller.sword;

import es.api.onepiece.core.internal.usecases.sword.DeleteSwordUseCase;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.DeleteSwordV1Api;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class DeleteSwordController.
 */
@RestController
@Validated
@RequiredArgsConstructor
public class DeleteSwordController implements DeleteSwordV1Api {

    /** The delete sword use case. */
    private final DeleteSwordUseCase deleteSwordUseCase;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> deleteSwordV1(@NotNull final Integer id) {
        this.deleteSwordUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
