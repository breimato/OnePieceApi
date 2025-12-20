package es.api.onepiece.adapters.outbound.persistence.repository.character.attack;

import es.api.onepiece.adapters.outbound.persistence.mapper.character.AttackMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.AttackMyBatisMapper;
import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.vo.character.attack.UpdateAttackVo;
import es.api.onepiece.core.ports.outbound.character.attack.FindAttacksPersistencePort;
import es.api.onepiece.core.ports.outbound.character.attack.UpdateAttackPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class AttackUpdateRepository.
 */
@Component
@RequiredArgsConstructor
public class AttackUpdateRepository implements UpdateAttackPersistencePort {

    /** The find attacks persistence port. */
    private final FindAttacksPersistencePort findAttacksPersistencePort;

    /** The attack my batis mapper. */
    private final AttackMyBatisMapper attackMyBatisMapper;

    /** The attack mapper. */
    private final AttackMapper attackMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Attack execute(@Valid final UpdateAttackVo updateAttackVo) {

        final var attackExists = this.findAttacksPersistencePort.exists(updateAttackVo.getId());

        if (BooleanUtils.isFalse(attackExists)) {

            throw new CharacterException
                    (ExceptionMessageConstants.ATTACK_NOT_FOUND_CODE_ERROR,
                    ExceptionMessageConstants.ATTACK_NOT_FOUND_MESSAGE_ERROR);
        }

        final var attackEntity = this.attackMapper.toAttackEntity(updateAttackVo);

        this.attackMyBatisMapper.updateAttack(attackEntity);

        final var updatedAttackEntity = this.attackMyBatisMapper.findById(updateAttackVo.getId());

        return this.attackMapper.toAttack(updatedAttackEntity);
    }
}
