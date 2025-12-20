package es.api.onepiece.adapters.outbound.persistence.repository.sword;

import es.api.onepiece.adapters.outbound.persistence.mapper.sword.SwordMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.sword.SwordMyBatisMapper;
import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.internal.vo.sword.CreateSwordVo;
import es.api.onepiece.core.ports.outbound.sword.CreateSwordPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The Class SwordCreateRepository.
 */
@Component
@RequiredArgsConstructor
public class SwordCreateRepository implements CreateSwordPersistencePort {

    /** The sword my batis mapper. */
    private final SwordMyBatisMapper swordMyBatisMapper;

    /** The sword mapper. */
    private final SwordMapper swordMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Sword execute(@Valid final CreateSwordVo createSwordVo) {

        final var swordEntity = this.swordMapper.toSwordEntity(createSwordVo);

        this.swordMyBatisMapper.insertSword(swordEntity);

        final var savedEntity = this.swordMyBatisMapper.findById(swordEntity.getId());

        return this.swordMapper.toSword(savedEntity);
    }
}
