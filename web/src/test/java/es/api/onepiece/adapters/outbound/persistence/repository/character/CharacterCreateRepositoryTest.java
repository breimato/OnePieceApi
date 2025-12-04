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
     * Test create when vo has fruits then inserts character and fruits.
     */
    @Test
    void testCreate_whenVoHasFruits_thenInsertsCharacterAndFruits() {

        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);
        final var characterEntity = Instancio.create(CharacterEntity.class);
        final var character = Instancio.create(Character.class);

        // When
        when(this.characterMapper.toCharacterEntityFromVo(createCharacterVo)).thenReturn(characterEntity);
        when(this.characterMapper.toCharacter(characterEntity)).thenReturn(character);

        final var result = this.characterCreateRepository.create(createCharacterVo);

        // Then
        verify(this.characterMapper, times(1)).toCharacterEntityFromVo(createCharacterVo);
        verify(this.characterMyBatisMapper, times(1)).insertCharacter(characterEntity);
        verify(this.characterMyBatisMapper, times(1)).insertFruits(characterEntity.getId(), createCharacterVo.getFruitIds());
        verify(this.characterMapper, times(1)).toCharacter(characterEntity);

        assertThat(result).isEqualTo(character);
    }

    /**
     * Test create when vo has no fruits then inserts only character.
     */
    @Test
    void testCreate_whenVoHasNoFruits_thenInsertsOnlyCharacter() {

        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);
        createCharacterVo.setFruitIds(Collections.emptyList());

        final var characterEntity = Instancio.create(CharacterEntity.class);
        final var character = Instancio.create(Character.class);

        // When
        when(this.characterMapper.toCharacterEntityFromVo(createCharacterVo)).thenReturn(characterEntity);
        when(this.characterMapper.toCharacter(characterEntity)).thenReturn(character);

        final var result = this.characterCreateRepository.create(createCharacterVo);

        // Then
        verify(this.characterMapper, times(1)).toCharacterEntityFromVo(createCharacterVo);
        verify(this.characterMyBatisMapper, times(1)).insertCharacter(characterEntity);
        verify(this.characterMyBatisMapper, times(0)).insertFruits(characterEntity.getId(), createCharacterVo.getFruitIds());
        verify(this.characterMapper, times(1)).toCharacter(characterEntity);

        assertThat(result).isEqualTo(character);
    }
}