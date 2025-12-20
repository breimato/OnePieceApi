package es.api.onepiece.core.internal.usecases.character.attack;

import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.usecases.character.attack.UpdateAttackUseCase;
import es.api.onepiece.core.internal.vo.character.attack.UpdateAttackVo;
import es.api.onepiece.core.ports.outbound.character.attack.UpdateAttackPersistencePort;
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
 * The Class UpdateAttackUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class UpdateAttackUseCaseTest {

    /** The update attack use case. */
    @InjectMocks
    UpdateAttackUseCase updateAttackUseCase;

    /** The update attack persistence port. */
    @Mock
    UpdateAttackPersistencePort updateAttackPersistencePort;

    /**
     * Test execute when valid then updates attack.
     */
    @Test
    void testExecute_whenValid_thenUpdatesAttack() {

        // Given
        final var updateAttackVo = Instancio.create(UpdateAttackVo.class);
        final var attack = Instancio.create(Attack.class);

        // When
        when(this.updateAttackPersistencePort.execute(updateAttackVo)).thenReturn(attack);

        final var result = this.updateAttackUseCase.execute(updateAttackVo);

        // Then
        verify(this.updateAttackPersistencePort, times(1)).execute(updateAttackVo);

        assertThat(result).isEqualTo(attack);
    }
}
