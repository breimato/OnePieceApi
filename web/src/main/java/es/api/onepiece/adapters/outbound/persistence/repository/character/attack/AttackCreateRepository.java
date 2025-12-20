package es.api.onepiece.adapters.outbound.persistence.repository.character.attack;

import es.api.onepiece.adapters.outbound.persistence.mapper.character.AttackMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.AttackMyBatisMapper;
import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.vo.character.attack.CreateAttackVo;
import es.api.onepiece.core.ports.outbound.character.attack.CreateAttackPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The Class AttackCreateRepository.
 */
@Component
@RequiredArgsConstructor
public class AttackCreateRepository implements CreateAttackPersistencePort {

    /** The attack my batis mapper. */
    private final AttackMyBatisMapper attackMyBatisMapper;

    /** The attack mapper. */
    private final AttackMapper attackMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Attack execute(@Valid final CreateAttackVo createAttackVo) {

        final var attackEntity = this.attackMapper.toAttackEntity(createAttackVo);

        this.attackMyBatisMapper.insertAttack(attackEntity);

        final var createdAttackEntity = this.attackMyBatisMapper.findById(attackEntity.getId());

        return this.attackMapper.toAttack(createdAttackEntity);
    }
}
