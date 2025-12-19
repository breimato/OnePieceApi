package es.api.onepiece.core.internal.usecases.character;

import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.services.CharacterValidationService;
import es.api.onepiece.core.internal.vo.character.UpdateCharacterVo;
import es.api.onepiece.core.ports.outbound.character.UpdateCharacterPersistencePort;
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
 * The Class UpdateCharacterUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class UpdateCharacterUseCaseTest {

    /** The update character persistence port. */
    @Mock
    UpdateCharacterPersistencePort updateCharacterPersistencePort;

    /** The character validation service. */
    @Mock
    CharacterValidationService characterValidationService;

    /** The update character use case. */
    @InjectMocks
    UpdateCharacterUseCase updateCharacterUseCase;

    /**
     * Test execute when valid then updates character.
     */
    @Test
    void testExecute_whenValid_thenUpdatesCharacter() {
        // Given
        final var updateCharacterVo = Instancio.create(UpdateCharacterVo.class);
        final var character = Instancio.create(Character.class);

        // When
        when(this.updateCharacterPersistencePort.execute(updateCharacterVo)).thenReturn(character);

        final var result = this.updateCharacterUseCase.execute(updateCharacterVo);

        // Then
        verify(this.characterValidationService, times(1)).checkUpdateRules(updateCharacterVo);
        verify(this.updateCharacterPersistencePort, times(1)).execute(updateCharacterVo);

        assertThat(result).isEqualTo(character);
    }
}
