package es.api.onepiece.adapters.outbound.persistence.repository.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.CharacterMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper;
import es.api.onepiece.core.internal.domain.character.Character;
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
 * The Class CharacterFindAllRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class CharacterFindAllRepositoryTest {

    /** The character my batis mapper. */
    @Mock
    private CharacterMyBatisMapper characterMyBatisMapper;

    /** The character mapper. */
    @Mock
    private CharacterMapper characterMapper;

    /** The get character repository. */
    @InjectMocks
    private CharacterFindAllRepository characterFindAllRepository;

    /**
     * Test find all when characters exist then maps and returns domain list.
     */
    @Test
    void testFindAll_whenCharactersExist_thenMapsAndReturnsDomainList() {
        
        // Given
        final var characterEntities = Instancio.ofList(CharacterEntity.class).size(3).create();
        final var domainCharacters = Instancio.ofList(Character.class).size(3).create();

        when(characterMyBatisMapper.findAll()).thenReturn(characterEntities);
        when(characterMapper.toCharacterList(characterEntities)).thenReturn(domainCharacters);

        // When
        final var result = characterFindAllRepository.findAll();

        // Then
        assertEquals(domainCharacters, result);
        verify(characterMyBatisMapper).findAll();
        verify(characterMapper).toCharacterList(characterEntities);
    }
}
