package es.api.onepiece.core.internal.usecases.character;

import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.domain.character.CharacterSummary;
import es.api.onepiece.core.ports.outbound.character.FindCharactersPersistencePort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The Class GetCharactersUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class GetCharactersUseCaseTest {

    /** The find characters persistence port. */
    @Mock
    private FindCharactersPersistencePort findCharactersPersistencePort;

    /** The get characters use case. */
    @InjectMocks
    private GetCharactersUseCase getCharactersUseCase;

    /**
     * Test find all when characters exist then returns domain list.
     */
    @Test
    void testFindAll_whenCharactersExist_thenReturnsDomainList() {
        // Given
        final var characterSummaryList = Instancio.ofList(CharacterSummary.class).size(3).create();

        // When
        when(this.findCharactersPersistencePort.findAll()).thenReturn(characterSummaryList);
        final var actualCharacters = this.getCharactersUseCase.findAll();

        // Then
        verify(this.findCharactersPersistencePort).findAll();
        assertEquals(characterSummaryList, actualCharacters);
    }
}
