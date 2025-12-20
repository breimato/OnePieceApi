package es.api.onepiece.adapters.inbound.rest.controller.character;

import es.api.onepiece.core.ports.inbound.character.DeleteCharacterPort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.DeleteCharacterV1Api;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class DeleteCharacterController.
 */
@RestController
@Validated
@RequiredArgsConstructor
public class DeleteCharacterController implements DeleteCharacterV1Api {

    /** The delete character port. */
    private final DeleteCharacterPort deleteCharacterPort;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> deleteCharacterV1(@NotNull final Integer id) {
        this.deleteCharacterPort.execute(id);
        return ResponseEntity.noContent().build();
    }
}
