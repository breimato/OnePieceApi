package es.api.onepiece.adapters.inbound.rest.controller.character.attack;

import es.api.onepiece.core.internal.usecases.character.attack.DeleteAttackUseCase;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.DeleteAttackV1Api;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class DeleteAttackController.
 */
@Validated
@RestController
@RequiredArgsConstructor
public class DeleteAttackController implements DeleteAttackV1Api {

    /** The delete attack use case. */
    private final DeleteAttackUseCase deleteAttackUseCase;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> deleteAttackV1(@NotNull final Integer id) {

        this.deleteAttackUseCase.execute(id);

        return ResponseEntity.noContent().build();
    }
}
