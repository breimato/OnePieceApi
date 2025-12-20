package es.api.onepiece.adapters.outbound.persistence.repository.character.attack;

import es.api.onepiece.adapters.outbound.persistence.mybatis.character.AttackMyBatisMapper;
import es.api.onepiece.core.ports.outbound.character.attack.DeleteAttackPersistencePort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The Class AttackDeleteRepository.
 */
@Component
@RequiredArgsConstructor
public class AttackDeleteRepository implements DeleteAttackPersistencePort {

    /** The attack my batis mapper. */
    private final AttackMyBatisMapper attackMyBatisMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(@NotNull final Integer id) {
        this.attackMyBatisMapper.deleteAttack(id);
    }
}
