package es.api.onepiece.adapters.outbound.persistence.repository.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterSummaryEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.CharacterMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper;
import es.api.onepiece.core.internal.domain.character.CharacterSummary;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * The Class CharacterFindAllRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class CharacterFindRepositoryTest {

    /** The get character repository. */
    @InjectMocks
    CharacterFindRepository characterFindRepository;

    /** The character my batis mapper. */
    @Mock
    CharacterMyBatisMapper characterMyBatisMapper;

    /** The character mapper. */
    @Mock
    CharacterMapper characterMapper;

    /**
     * Test find all when characters exist then maps and returns domain list.
     */
    @Test
    void testFindAll_whenCharactersExist_thenMapsAndReturnsDomainList() {

        // Given
        final var characterSummaryEntities = Instancio.ofList(CharacterSummaryEntity.class).size(3).create();
        final var characterSummaries = Instancio.ofList(CharacterSummary.class).size(3).create();

        // When
        when(this.characterMyBatisMapper.findAll()).thenReturn(characterSummaryEntities);
        when(this.characterMapper.toCharacterSummaryList(characterSummaryEntities))
                .thenReturn(characterSummaries);

        final var result = this.characterFindRepository.findAll();

        // Then
        verify(this.characterMyBatisMapper, times(1)).findAll();
        verify(this.characterMapper, times(1)).toCharacterSummaryList(characterSummaryEntities);
        assertEquals(characterSummaries, result);
    }

    /**
     * Test find by id when character exists then maps and returns domain.
     */
    @Test
    void testFindById_whenCharacterExists_thenMapsAndReturnsDomain() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var characterEntity = Instancio.create(CharacterEntity.class);
        final var character = Instancio.create(es.api.onepiece.core.internal.domain.character.Character.class);

        // When
        when(this.characterMyBatisMapper.getCharacterById(id)).thenReturn(characterEntity);
        when(this.characterMapper.toCharacter(characterEntity)).thenReturn(character);

        final var result = this.characterFindRepository.findById(id);

        // Then
        verify(this.characterMyBatisMapper, times(1)).getCharacterById(id);
        verify(this.characterMapper, times(1)).toCharacter(characterEntity);
        assertEquals(character, result);
    }

    /**
     * Test exists when character exists then returns true.
     */
    @Test
    void testExists_whenCharacterExists_thenReturnsTrue() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        when(this.characterMyBatisMapper.exists(id)).thenReturn(true);

        final var result = this.characterFindRepository.exists(id);

        // Then
        verify(this.characterMyBatisMapper, times(1)).exists(id);
        assertTrue(result);
    }

}
