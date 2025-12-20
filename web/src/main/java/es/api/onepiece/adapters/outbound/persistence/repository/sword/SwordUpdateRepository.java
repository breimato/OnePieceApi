package es.api.onepiece.adapters.outbound.persistence.repository.sword;

import es.api.onepiece.adapters.outbound.persistence.mapper.sword.SwordMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.sword.SwordMyBatisMapper;
import es.api.onepiece.core.exceptions.SwordException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.internal.vo.sword.UpdateSwordVo;
import es.api.onepiece.core.ports.outbound.sword.UpdateSwordPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class SwordUpdateRepository.
 */
@Component
@RequiredArgsConstructor
public class SwordUpdateRepository implements UpdateSwordPersistencePort {

    /** The sword my batis mapper. */
    private final SwordMyBatisMapper swordMyBatisMapper;

    /** The sword mapper. */
    private final SwordMapper swordMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Sword execute(@Valid final UpdateSwordVo updateSwordVo) {

        if (BooleanUtils.isFalse(this.swordMyBatisMapper.exists(updateSwordVo.getId()))) {
            throw new SwordException(ExceptionMessageConstants.SWORD_NOT_FOUND_CODE_ERROR,
                    ExceptionMessageConstants.SWORD_NOT_FOUND_MESSAGE_ERROR);
        }

        final var swordEntity = this.swordMapper.toSwordEntityFromUpdate(updateSwordVo);

        this.swordMyBatisMapper.updateSword(swordEntity);

        final var updatedEntity = this.swordMyBatisMapper.findById(updateSwordVo.getId());

        return this.swordMapper.toSword(updatedEntity);
    }
}
