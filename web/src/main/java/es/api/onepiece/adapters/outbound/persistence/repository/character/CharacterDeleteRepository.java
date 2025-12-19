package es.api.onepiece.adapters.outbound.persistence.repository.character;

import es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper;
import es.api.onepiece.core.ports.outbound.character.DeleteCharacterPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The Class CharacterDeleteRepository.
 */
@Component
@RequiredArgsConstructor
public class CharacterDeleteRepository implements DeleteCharacterPersistencePort {

    /** The character my batis mapper. */
    private final CharacterMyBatisMapper characterMyBatisMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void execute(@NotNull final Integer id) {
        this.characterMyBatisMapper.deleteFruitsByCharacterId(id);
        this.characterMyBatisMapper.deleteHakisByCharacterId(id);
        this.characterMyBatisMapper.deleteTitlesByCharacterId(id);
        this.characterMyBatisMapper.deleteJobsByCharacterId(id);
        this.characterMyBatisMapper.deleteAffiliationsByCharacterId(id);
        this.characterMyBatisMapper.deleteSwordsByCharacterId(id);
        this.characterMyBatisMapper.unlinkTransformationsByCharacterId(id);
        this.characterMyBatisMapper.unlinkAttacksByCharacterId(id);
        this.characterMyBatisMapper.deleteCharacter(id);
    }
}
