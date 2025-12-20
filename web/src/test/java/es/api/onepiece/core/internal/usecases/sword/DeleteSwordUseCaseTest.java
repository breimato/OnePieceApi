package es.api.onepiece.core.internal.usecases.sword;

import es.api.onepiece.core.ports.outbound.sword.DeleteSwordPersistencePort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.*;

/**
 * The Class DeleteSwordUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class DeleteSwordUseCaseTest {

    /** The delete sword use case. */
    @InjectMocks
    DeleteSwordUseCase deleteSwordUseCase;

    /** The delete sword persistence port. */
    @Mock
    DeleteSwordPersistencePort deleteSwordPersistencePort;

    /**
     * Test execute when called then calls persistence port.
     */
    @Test
    void testExecute_whenCalled_thenCallsPersistencePort() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        doNothing().when(this.deleteSwordPersistencePort).execute(id);

        // Then
        assertThatCode(() -> this.deleteSwordUseCase.execute(id))
                .doesNotThrowAnyException();

        verify(this.deleteSwordPersistencePort, times(1)).execute(id);
    }
}
