package es.api.onepiece.adapters.outbound.persistence.repository.character.attack;

import es.api.onepiece.adapters.outbound.persistence.mapper.character.AttackMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.AttackMyBatisMapper;
import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.ports.outbound.character.attack.FindAttacksPersistencePort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * The Class AttackFindRepository.
 */
@Component
@RequiredArgsConstructor
public class AttackFindRepository implements FindAttacksPersistencePort {

    /** The attack my batis mapper. */
    private final AttackMyBatisMapper attackMyBatisMapper;

    /** The attack mapper. */
    private final AttackMapper attackMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Attack> findAll() {
        final var attackEntities = this.attackMyBatisMapper.findAll();
        return this.attackMapper.toAttackList(attackEntities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Attack findById(@NotNull final Integer id) {
        final var attackEntity = this.attackMyBatisMapper.findById(id);
        if (Objects.isNull(attackEntity)) {
            throw new CharacterException(ExceptionMessageConstants.ATTACK_NOT_FOUND_CODE_ERROR,
                    ExceptionMessageConstants.ATTACK_NOT_FOUND_MESSAGE_ERROR);
        }
        return this.attackMapper.toAttack(attackEntity);
    }

    /**
     * Exists.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean exists(@NotNull final Integer id) {
        return this.attackMyBatisMapper.exists(id);
    }
}
