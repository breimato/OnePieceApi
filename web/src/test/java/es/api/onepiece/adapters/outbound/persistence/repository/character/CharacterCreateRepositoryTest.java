package es.api.onepiece.adapters.outbound.persistence.repository.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.CharacterMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The Class CharacterCreateRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class CharacterCreateRepositoryTest {

    /** The character my batis mapper. */
    @Mock
    CharacterMyBatisMapper characterMyBatisMapper;

    /** The character mapper. */
    @Mock
    CharacterMapper characterMapper;

    /** The character create repository. */
    @InjectMocks
    CharacterCreateRepository characterCreateRepository;

    /**
     * Test execute when vo has all lists populated then inserts character and all
     * related entities.
     */
    @Test
    void testExecute_whenVoHasAllListsPopulated_thenInsertsCharacterAndAllRelatedEntities() {

        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);
        final var characterEntity = Instancio.create(CharacterEntity.class);
        final var character = Instancio.create(Character.class);

        // When
        when(this.characterMapper.toCharacterEntityFromVo(createCharacterVo)).thenReturn(characterEntity);
        when(this.characterMyBatisMapper.getCharacterById(characterEntity.getId())).thenReturn(characterEntity);
        when(this.characterMapper.toCharacter(characterEntity)).thenReturn(character);

        final var result = this.characterCreateRepository.execute(createCharacterVo);

        // Then
        verify(this.characterMapper, times(1)).toCharacterEntityFromVo(createCharacterVo);
        verify(this.characterMyBatisMapper, times(1)).insertCharacter(characterEntity);
        verify(this.characterMyBatisMapper, times(1)).insertFruits(characterEntity.getId(), createCharacterVo.getFruitIds());
        verify(this.characterMyBatisMapper, times(1)).insertHakis(characterEntity.getId(), createCharacterVo.getHakiIds());
        verify(this.characterMyBatisMapper, times(1)).insertTitles(characterEntity.getId(), createCharacterVo.getTitleIds());
        verify(this.characterMyBatisMapper, times(1)).insertJobs(characterEntity.getId(), createCharacterVo.getJobIds());
        verify(this.characterMyBatisMapper, times(1)).insertAffiliations(characterEntity.getId(),
                createCharacterVo.getCharacterAffiliations());
        verify(this.characterMyBatisMapper, times(1)).insertSwords(characterEntity.getId(), createCharacterVo.getSwordIds());
        verify(this.characterMyBatisMapper, times(1)).insertTransformations(characterEntity.getId(),
                createCharacterVo.getTransformationIds());
        verify(this.characterMyBatisMapper, times(1)).insertAttacks(characterEntity.getId(), createCharacterVo.getAttackIds());
        verify(this.characterMyBatisMapper, times(1)).getCharacterById(characterEntity.getId());
        verify(this.characterMapper, times(1)).toCharacter(characterEntity);

        assertThat(result).isEqualTo(character);
    }

    /**
     * Test execute when vo has no related entities then inserts only character.
     */
    @Test
    void testExecute_whenVoHasNoRelatedEntities_thenInsertsOnlyCharacter() {

        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);
        createCharacterVo.setFruitIds(Collections.emptyList());
        createCharacterVo.setHakiIds(Collections.emptyList());
        createCharacterVo.setTitleIds(Collections.emptyList());
        createCharacterVo.setJobIds(Collections.emptyList());
        createCharacterVo.setCharacterAffiliations(Collections.emptyList());
        createCharacterVo.setSwordIds(Collections.emptyList());
        createCharacterVo.setTransformationIds(Collections.emptyList());
        createCharacterVo.setAttackIds(Collections.emptyList());

        final var characterEntity = Instancio.create(CharacterEntity.class);
        final var character = Instancio.create(Character.class);

        // When
        when(this.characterMapper.toCharacterEntityFromVo(createCharacterVo)).thenReturn(characterEntity);
        when(this.characterMyBatisMapper.getCharacterById(characterEntity.getId())).thenReturn(characterEntity);
        when(this.characterMapper.toCharacter(characterEntity)).thenReturn(character);

        final var result = this.characterCreateRepository.execute(createCharacterVo);

        // Then
        verify(this.characterMapper).toCharacterEntityFromVo(createCharacterVo);
        verify(this.characterMyBatisMapper).insertCharacter(characterEntity);
        verify(this.characterMyBatisMapper, times(0)).insertFruits(characterEntity.getId(),
                createCharacterVo.getFruitIds());
        verify(this.characterMyBatisMapper, times(0)).insertHakis(characterEntity.getId(),
                createCharacterVo.getHakiIds());
        verify(this.characterMyBatisMapper, times(0)).insertTitles(characterEntity.getId(),
                createCharacterVo.getTitleIds());
        verify(this.characterMyBatisMapper, times(0)).insertJobs(characterEntity.getId(),
                createCharacterVo.getJobIds());
        verify(this.characterMyBatisMapper, times(0)).insertAffiliations(characterEntity.getId(),
                createCharacterVo.getCharacterAffiliations());
        verify(this.characterMyBatisMapper, times(0)).insertSwords(characterEntity.getId(),
                createCharacterVo.getSwordIds());
        verify(this.characterMyBatisMapper, times(0)).insertTransformations(characterEntity.getId(),
                createCharacterVo.getTransformationIds());
        verify(this.characterMyBatisMapper, times(0)).insertAttacks(characterEntity.getId(),
                createCharacterVo.getAttackIds());
        verify(this.characterMyBatisMapper).getCharacterById(characterEntity.getId());
        verify(this.characterMapper).toCharacter(characterEntity);

        assertThat(result).isEqualTo(character);
    }
}
