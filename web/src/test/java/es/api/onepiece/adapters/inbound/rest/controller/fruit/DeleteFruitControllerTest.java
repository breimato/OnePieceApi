package es.api.onepiece.adapters.inbound.rest.controller.fruit;

import es.api.onepiece.core.ports.inbound.fruit.DeleteFruitPort;
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
 * The Class DeleteFruitControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class DeleteFruitControllerTest {

    /** The delete fruit controller. */
    @InjectMocks
    DeleteFruitController deleteFruitController;

    /** The delete fruit port. */
    @Mock
    DeleteFruitPort deleteFruitPort;

    /**
     * Test delete fruit v1 when called then returns no content.
     */
    @Test
    void testDeleteFruitV1_whenCalled_thenReturnsNoContent() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        final var response = this.deleteFruitController.deleteFruitV1(id);

        // Then
        verify(this.deleteFruitPort, times(1)).execute(id);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
