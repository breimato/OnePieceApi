package es.api.onepiece.core.internal.usecases.character;

import es.api.onepiece.core.ports.outbound.character.DeleteCharacterPersistencePort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * The Class DeleteCharacterUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class DeleteCharacterUseCaseTest {

    /** The delete character persistence port. */
    @Mock
    DeleteCharacterPersistencePort deleteCharacterPersistencePort;

    /** The delete character use case. */
    @InjectMocks
    DeleteCharacterUseCase deleteCharacterUseCase;

    /**
     * Test execute when called then delegates.
     */
    @Test
    void testExecute_whenCalled_thenDelegates() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        this.deleteCharacterUseCase.execute(id);

        // Then
        verify(this.deleteCharacterPersistencePort, times(1)).execute(id);
    }
}
