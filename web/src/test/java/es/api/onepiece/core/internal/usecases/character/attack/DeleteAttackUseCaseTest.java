package es.api.onepiece.core.internal.usecases.character.attack;

import es.api.onepiece.core.internal.usecases.character.attack.DeleteAttackUseCase;
import es.api.onepiece.core.ports.outbound.character.attack.DeleteAttackPersistencePort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

/**
 * The Class DeleteAttackUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class DeleteAttackUseCaseTest {

    /** The delete attack use case. */
    @InjectMocks
    DeleteAttackUseCase deleteAttackUseCase;

    /** The delete attack persistence port. */
    @Mock
    DeleteAttackPersistencePort deleteAttackPersistencePort;

    /**
     * Test execute when called then deletes attack.
     */
    @Test
    void testExecute_whenCalled_thenDeletesAttack() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        doNothing().when(this.deleteAttackPersistencePort).execute(id);

        this.deleteAttackUseCase.execute(id);

        // Then
        verify(this.deleteAttackPersistencePort, times(1)).execute(id);
    }
}
