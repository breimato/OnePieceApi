package es.api.onepiece.adapters.outbound.persistence.repository.character;

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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The Class CharacterFindAllRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class CharacterFindAllRepositoryTest {

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
        final var domainCharacterSummaries = Instancio.ofList(CharacterSummary.class).size(3).create();

        // When
        when(this.characterMyBatisMapper.findAll()).thenReturn(characterSummaryEntities);
        when(this.characterMapper.toCharacterSummaryList(characterSummaryEntities))
                .thenReturn(domainCharacterSummaries);

        final var result = this.characterFindRepository.findAll();

        // Then
        verify(this.characterMyBatisMapper).findAll();
        verify(this.characterMapper).toCharacterSummaryList(characterSummaryEntities);
        assertEquals(domainCharacterSummaries, result);
    }
}
