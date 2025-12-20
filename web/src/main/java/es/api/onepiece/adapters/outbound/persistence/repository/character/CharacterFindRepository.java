package es.api.onepiece.adapters.outbound.persistence.repository.character;

import es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.CharacterMapper;
import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.character.CharacterSummary;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.ports.outbound.character.FindCharactersPersistencePort;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * The Class CharacterFindRepository.
 */
@Component
@AllArgsConstructor
public class CharacterFindRepository implements FindCharactersPersistencePort {

    /** The character my batis mapper. */
    private final CharacterMyBatisMapper characterMyBatisMapper;

    /** The character mapper. */
    private final CharacterMapper characterMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CharacterSummary> findAll() {

        final var characterSummaryEntities = this.characterMyBatisMapper.findAll();

        if (Objects.isNull(characterSummaryEntities)){
            throw new CharacterException(
                    ExceptionMessageConstants.CHARACTER_NOT_FOUND_CODE_ERROR,
                    ExceptionMessageConstants.CHARACTER_NOT_FOUND_MESSAGE_ERROR);
        }
        return this.characterMapper.toCharacterSummaryList(characterSummaryEntities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Character findById(@NotNull final Integer id) {

        final var characterEntity = this.characterMyBatisMapper.getCharacterById(id);

        if (Objects.isNull(characterEntity)){
            throw new CharacterException(
                    ExceptionMessageConstants.CHARACTER_NOT_FOUND_CODE_ERROR,
                    ExceptionMessageConstants.CHARACTER_NOT_FOUND_MESSAGE_ERROR);
        }
        return this.characterMapper.toCharacter(characterEntity);
    }

    @Override
    public boolean exists(@NotNull final Integer id) {
        return this.characterMyBatisMapper.exists(id);
    }
}
