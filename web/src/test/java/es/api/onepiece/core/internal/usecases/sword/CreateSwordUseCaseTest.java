package es.api.onepiece.core.internal.usecases.sword;

import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.internal.vo.sword.CreateSwordVo;
import es.api.onepiece.core.ports.outbound.sword.CreateSwordPersistencePort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class CreateSwordUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class CreateSwordUseCaseTest {

    /** The create sword use case. */
    @InjectMocks
    CreateSwordUseCase createSwordUseCase;

    /** The create sword persistence port. */
    @Mock
    CreateSwordPersistencePort createSwordPersistencePort;

    /**
     * Test execute when valid request then returns sword.
     */
    @Test
    void testExecute_whenValidRequest_thenReturnsSword() {

        // Given
        final var createSwordVo = Instancio.create(CreateSwordVo.class);
        final var sword = Instancio.create(Sword.class);

        // When
        when(this.createSwordPersistencePort.execute(createSwordVo)).thenReturn(sword);

        final var result = this.createSwordUseCase.execute(createSwordVo);

        // Then
        verify(this.createSwordPersistencePort, times(1)).execute(createSwordVo);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(sword);
    }
}
