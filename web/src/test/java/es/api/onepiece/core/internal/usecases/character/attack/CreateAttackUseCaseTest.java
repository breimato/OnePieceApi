package es.api.onepiece.core.internal.usecases.character.attack;

import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.usecases.character.attack.CreateAttackUseCase;
import es.api.onepiece.core.internal.vo.character.attack.CreateAttackVo;
import es.api.onepiece.core.ports.outbound.character.attack.CreateAttackPersistencePort;
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
 * The Class CreateAttackUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class CreateAttackUseCaseTest {

    /** The create attack use case. */
    @InjectMocks
    CreateAttackUseCase createAttackUseCase;

    /** The create attack persistence port. */
    @Mock
    CreateAttackPersistencePort createAttackPersistencePort;

    /**
     * Test execute when valid then creates attack.
     */
    @Test
    void testExecute_whenValid_thenCreatesAttack() {

        // Given
        final var createAttackVo = Instancio.create(CreateAttackVo.class);
        final var attack = Instancio.create(Attack.class);

        // When
        when(this.createAttackPersistencePort.execute(createAttackVo)).thenReturn(attack);

        final var result = this.createAttackUseCase.execute(createAttackVo);

        // Then
        verify(this.createAttackPersistencePort, times(1)).execute(createAttackVo);

        assertThat(result).isEqualTo(attack);
    }
}
