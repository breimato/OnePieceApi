package es.api.onepiece.adapters.outbound.persistence.repository.sword;

import es.api.onepiece.adapters.outbound.persistence.mybatis.sword.SwordMyBatisMapper;
import es.api.onepiece.core.ports.outbound.sword.DeleteSwordPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The Class SwordDeleteRepository.
 */
@Component
@RequiredArgsConstructor
public class SwordDeleteRepository implements DeleteSwordPersistencePort {

    /** The sword my batis mapper. */
    private final SwordMyBatisMapper swordMyBatisMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void execute(@NotNull final Integer id) {
        this.swordMyBatisMapper.deleteCharacterSwordsBySwordId(id);
        this.swordMyBatisMapper.deleteSword(id);
    }
}
