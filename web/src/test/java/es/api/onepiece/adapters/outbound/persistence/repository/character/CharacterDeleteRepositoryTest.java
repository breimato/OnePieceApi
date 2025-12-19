package es.api.onepiece.adapters.outbound.persistence.repository.character;

import es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * The Class CharacterDeleteRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class CharacterDeleteRepositoryTest {

    /** The character my batis mapper. */
    @Mock
    CharacterMyBatisMapper characterMyBatisMapper;

    /** The character delete repository. */
    @InjectMocks
    CharacterDeleteRepository characterDeleteRepository;

    /**
     * Test execute when called then deletes character and relations.
     */
    @Test
    void testExecute_whenCalled_thenDeletesCharacterAndRelations() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        this.characterDeleteRepository.execute(id);

        // Then
        verify(this.characterMyBatisMapper, times(1)).deleteFruitsByCharacterId(id);
        verify(this.characterMyBatisMapper, times(1)).deleteHakisByCharacterId(id);
        verify(this.characterMyBatisMapper, times(1)).deleteTitlesByCharacterId(id);
        verify(this.characterMyBatisMapper, times(1)).deleteJobsByCharacterId(id);
        verify(this.characterMyBatisMapper, times(1)).deleteAffiliationsByCharacterId(id);
        verify(this.characterMyBatisMapper, times(1)).deleteSwordsByCharacterId(id);
        verify(this.characterMyBatisMapper, times(1)).deleteAttacksByCharacterId(id);
        verify(this.characterMyBatisMapper, times(1)).deleteTransformationsByCharacterId(id);
        verify(this.characterMyBatisMapper, times(1)).deleteCharacter(id);
    }
}
