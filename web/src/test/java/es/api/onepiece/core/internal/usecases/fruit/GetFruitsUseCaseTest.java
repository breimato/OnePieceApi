package es.api.onepiece.core.internal.usecases.fruit;

import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.ports.outbound.fruit.FindFruitsPersistencePort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The Class GetFruitsUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class GetFruitsUseCaseTest {

    /** The get fruits use case. */
    @InjectMocks
    GetFruitsUseCase getFruitsUseCase;

    /** The find fruits persistence port. */
    @Mock
    FindFruitsPersistencePort findFruitsPersistencePort;


    /**
     * Test find all when called then returns all fruits.
     */
    @Test
    void testFindAll_whenCalled_thenReturnsAllFruits() {

        // Given
        final var fruits = Instancio.ofList(Fruit.class).size(3).create();

        // When
        when(this.findFruitsPersistencePort.findAll()).thenReturn(fruits);

        final var result = this.getFruitsUseCase.findAll();

        // Then
        verify(this.findFruitsPersistencePort, times(1)).findAll();

        assertThat(result).isEqualTo(fruits);
    }

    /**
     * Test find by id when valid id then returns fruit.
     */
    @Test
    void testFindById_whenValidId_thenReturnsFruit() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var fruit = Instancio.create(Fruit.class);

        // When
        when(this.findFruitsPersistencePort.findById(id)).thenReturn(fruit);

        final var result = this.getFruitsUseCase.findById(id);

        // Then
        verify(this.findFruitsPersistencePort, times(1)).findById(id);

        assertThat(result).isEqualTo(fruit);
    }
}
