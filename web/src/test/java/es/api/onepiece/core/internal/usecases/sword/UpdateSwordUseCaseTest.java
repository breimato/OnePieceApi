package es.api.onepiece.core.internal.usecases.sword;

import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.internal.vo.sword.UpdateSwordVo;
import es.api.onepiece.core.ports.outbound.sword.UpdateSwordPersistencePort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class UpdateSwordUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class UpdateSwordUseCaseTest {

    /** The update sword use case. */
    @InjectMocks
    UpdateSwordUseCase updateSwordUseCase;

    /** The update sword persistence port. */
    @Mock
    UpdateSwordPersistencePort updateSwordPersistencePort;

    /**
     * Test execute when valid request then returns sword.
     */
    @Test
    void testExecute_whenValidRequest_thenReturnsSword() {

        // Given
        final var updateSwordVo = Instancio.create(UpdateSwordVo.class);
        final var sword = Instancio.create(Sword.class);

        // When
        when(this.updateSwordPersistencePort.execute(updateSwordVo)).thenReturn(sword);

        final var result = this.updateSwordUseCase.execute(updateSwordVo);

        // Then
        verify(this.updateSwordPersistencePort, times(1)).execute(updateSwordVo);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(sword);
    }
}
