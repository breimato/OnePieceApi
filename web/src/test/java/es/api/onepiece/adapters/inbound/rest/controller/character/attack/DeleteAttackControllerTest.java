package es.api.onepiece.adapters.inbound.rest.controller.character.attack;

import es.api.onepiece.core.ports.inbound.character.attack.DeleteAttackPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class DeleteAttackControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class DeleteAttackControllerTest {

    /** The delete attack controller. */
    @InjectMocks
    DeleteAttackController deleteAttackController;

    /** The delete attack port. */
    @Mock
    DeleteAttackPort deleteAttackPort;

    /**
     * Test delete attack v1 when called then returns no content.
     */
    @Test
    void testDeleteAttackV1_whenCalled_thenReturnsNoContent() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        doNothing().when(this.deleteAttackPort).execute(id);

        final var response = this.deleteAttackController.deleteAttackV1(id);

        // Then
        verify(this.deleteAttackPort, times(1)).execute(id);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
