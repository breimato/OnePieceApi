package es.api.onepiece.core.internal.usecases.fruit;

import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.vo.fruit.UpdateFruitVo;
import es.api.onepiece.core.ports.outbound.fruit.UpdateFruitPersistencePort;
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
 * The Class UpdateFruitUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class UpdateFruitUseCaseTest {

    /** The update fruit use case. */
    @InjectMocks
    UpdateFruitUseCase updateFruitUseCase;

    /** The update fruit persistence port. */
    @Mock
    UpdateFruitPersistencePort updateFruitPersistencePort;


    /**
     * Test execute when valid then updates fruit.
     */
    @Test
    void testExecute_whenValid_thenUpdatesFruit() {

        // Given
        final var updateFruitVo = Instancio.create(UpdateFruitVo.class);
        final var fruit = Instancio.create(Fruit.class);

        // When
        when(this.updateFruitPersistencePort.execute(updateFruitVo)).thenReturn(fruit);

        final var result = this.updateFruitUseCase.execute(updateFruitVo);

        // Then
        verify(this.updateFruitPersistencePort, times(1)).execute(updateFruitVo);

        assertThat(result).isEqualTo(fruit);
    }
}
