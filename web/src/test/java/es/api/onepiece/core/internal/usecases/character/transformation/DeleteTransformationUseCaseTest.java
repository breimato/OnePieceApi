package es.api.onepiece.core.internal.usecases.character.transformation;

import es.api.onepiece.core.ports.outbound.character.transformation.DeleteTransformationPersistencePort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * The Class DeleteTransformationUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class DeleteTransformationUseCaseTest {

    /** The delete transformation use case. */
    @InjectMocks
    DeleteTransformationUseCase deleteTransformationUseCase;

    /** The delete transformation persistence port. */
    @Mock
    DeleteTransformationPersistencePort deleteTransformationPersistencePort;

    /**
     * Test execute when valid id then deletes transformation.
     */
    @Test
    void testExecute_whenValidId_thenDeletesTransformation() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        this.deleteTransformationUseCase.execute(id);

        // Then
        verify(this.deleteTransformationPersistencePort, times(1)).execute(id);
    }
}
