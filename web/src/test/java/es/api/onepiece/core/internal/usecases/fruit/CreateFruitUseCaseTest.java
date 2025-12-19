package es.api.onepiece.core.internal.usecases.fruit;

import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.vo.fruit.CreateFruitVo;
import es.api.onepiece.core.ports.outbound.fruit.CreateFruitPersistencePort;
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
 * The Class CreateFruitUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class CreateFruitUseCaseTest {

    /** The create fruit use case. */
    @InjectMocks
    CreateFruitUseCase createFruitUseCase;

    /** The create fruit persistence port. */
    @Mock
    CreateFruitPersistencePort createFruitPersistencePort;


    /**
     * Test execute when valid then creates fruit.
     */
    @Test
    void testExecute_whenValid_thenCreatesFruit() {

        // Given
        final var createFruitVo = Instancio.create(CreateFruitVo.class);
        final var fruit = Instancio.create(Fruit.class);

        // When
        when(this.createFruitPersistencePort.execute(createFruitVo)).thenReturn(fruit);

        final var result = this.createFruitUseCase.execute(createFruitVo);

        // Then
        verify(this.createFruitPersistencePort, times(1)).execute(createFruitVo);

        assertThat(result).isEqualTo(fruit);
    }
}
