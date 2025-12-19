package es.api.onepiece.core.internal.usecases.fruit;

import es.api.onepiece.core.ports.outbound.fruit.DeleteFruitPersistencePort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * The Class DeleteFruitUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class DeleteFruitUseCaseTest {

    /** The delete fruit use case. */
    @InjectMocks
    DeleteFruitUseCase deleteFruitUseCase;

    /** The delete fruit persistence port. */
    @Mock
    DeleteFruitPersistencePort deleteFruitPersistencePort;


    /**
     * Test execute when called then deletes fruit.
     */
    @Test
    void testExecute_whenCalled_thenDeletesFruit() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        this.deleteFruitUseCase.execute(id);

        // Then
        verify(this.deleteFruitPersistencePort, times(1)).execute(id);
    }
}
