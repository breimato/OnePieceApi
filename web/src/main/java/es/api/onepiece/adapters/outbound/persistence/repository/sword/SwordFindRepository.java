package es.api.onepiece.adapters.outbound.persistence.repository.sword;

import es.api.onepiece.adapters.outbound.persistence.mapper.sword.SwordMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.sword.SwordMyBatisMapper;
import es.api.onepiece.core.exceptions.SwordException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.ports.outbound.sword.FindSwordsPersistencePort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * The Class SwordFindRepository.
 */
@Component
@RequiredArgsConstructor
public class SwordFindRepository implements FindSwordsPersistencePort {

    /** The sword my batis mapper. */
    private final SwordMyBatisMapper swordMyBatisMapper;

    /** The sword mapper. */
    private final SwordMapper swordMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Sword> findAll() {
        final var swordEntities = this.swordMyBatisMapper.findAll();
        return this.swordMapper.toSwordList(swordEntities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sword findById(@NotNull final Integer id) {
        final var swordEntity = this.swordMyBatisMapper.findById(id);
        if (Objects.isNull(swordEntity)) {
            throw new SwordException(ExceptionMessageConstants.SWORD_NOT_FOUND_CODE_ERROR,
                    ExceptionMessageConstants.SWORD_NOT_FOUND_MESSAGE_ERROR);
        }
        return this.swordMapper.toSword(swordEntity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean exists(@NotNull final Integer id) {
        return this.swordMyBatisMapper.exists(id);
    }
}
