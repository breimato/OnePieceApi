package es.api.onepiece.adapters.outbound.persistence.repository.character;

import es.api.onepiece.adapters.outbound.persistence.mapper.character.CharacterMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import es.api.onepiece.core.ports.outbound.character.CreateCharacterPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The Class CharacterCreateRepository.
 */
@Component
@RequiredArgsConstructor
public class CharacterCreateRepository implements CreateCharacterPersistencePort {

    /** The character my batis mapper. */
    private final CharacterMyBatisMapper characterMyBatisMapper;

    /** The character mapper. */
    private final CharacterMapper characterMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Character create(@Valid final CreateCharacterVo createCharacterVo) {

        final var characterEntity = this.characterMapper.toCharacterEntityFromVo(createCharacterVo);

        this.characterMyBatisMapper.insertCharacter(characterEntity);

        if (CollectionUtils.isNotEmpty(createCharacterVo.getFruitIds())) {
            this.characterMyBatisMapper.insertFruits(characterEntity.getId(), createCharacterVo.getFruitIds());
        }

        return this.characterMapper.toCharacter(characterEntity);
    }
}
