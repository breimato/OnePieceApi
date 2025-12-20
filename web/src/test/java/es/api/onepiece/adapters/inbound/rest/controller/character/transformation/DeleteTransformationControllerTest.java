package es.api.onepiece.adapters.inbound.rest.controller.character.transformation;
import es.api.onepiece.core.internal.usecases.character.transformation.DeleteTransformationUseCase;
import es.api.onepiece.adapters.inbound.rest.controller.character.transformation.DeleteTransformationController;
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
 * The Class DeleteTransformationControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class DeleteTransformationControllerTest {

    /** The delete transformation controller. */
    @InjectMocks
    DeleteTransformationController deleteTransformationController;

    /** The delete transformation use case. */
    @Mock
    DeleteTransformationUseCase deleteTransformationUseCase;

    /**
     * Test delete transformation v1 when called then returns no content.
     */
    @Test
    void testDeleteTransformationV1_whenCalled_thenReturnsNoContent() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        final var response = this.deleteTransformationController.deleteTransformationV1(id);

        // Then
        verify(this.deleteTransformationUseCase, times(1)).execute(id);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
