package es.api.onepiece.adapters.inbound.rest.controller.character;

import es.api.onepiece.core.internal.usecases.character.DeleteCharacterUseCase;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * The Class DeleteCharacterControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class DeleteCharacterControllerTest {

    /** The delete character controller. */
    @InjectMocks
    DeleteCharacterController deleteCharacterController;

    /** The delete character use case. */
    @Mock
    DeleteCharacterUseCase deleteCharacterUseCase;

    /**
     * Test delete character v1 when called then returns no content.
     */
    @Test
    void testDeleteCharacterV1_whenCalled_thenReturnsNoContent() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        final var response = this.deleteCharacterController.deleteCharacterV1(id);

        // Then
        verify(this.deleteCharacterUseCase, times(1)).execute(id);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
