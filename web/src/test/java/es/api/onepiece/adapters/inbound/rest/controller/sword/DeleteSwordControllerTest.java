package es.api.onepiece.adapters.inbound.rest.controller.sword;

import es.api.onepiece.core.ports.inbound.sword.DeleteSwordPort;
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
 * The Class DeleteSwordControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class DeleteSwordControllerTest {

    /** The delete sword controller. */
    @InjectMocks
    DeleteSwordController deleteSwordController;

    /** The delete sword port. */
    @Mock
    DeleteSwordPort deleteSwordPort;

    /**
     * Test delete sword v1 when called then returns no content.
     */
    @Test
    void testDeleteSwordV1_whenCalled_thenReturnsNoContent() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        doNothing().when(this.deleteSwordPort).execute(id);

        final var response = this.deleteSwordController.deleteSwordV1(id);

        // Then
        verify(this.deleteSwordPort, times(1)).execute(id);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
