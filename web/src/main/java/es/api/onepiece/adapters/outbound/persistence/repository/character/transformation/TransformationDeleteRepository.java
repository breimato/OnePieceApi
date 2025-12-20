package es.api.onepiece.adapters.outbound.persistence.repository.character.transformation;

import es.api.onepiece.adapters.outbound.persistence.mybatis.character.TransformationMyBatisMapper;
import es.api.onepiece.core.ports.outbound.character.transformation.DeleteTransformationPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The Class TransformationDeleteRepository.
 */
@Component
@RequiredArgsConstructor
public class TransformationDeleteRepository implements DeleteTransformationPersistencePort {

    /** The transformation my batis mapper. */
    private final TransformationMyBatisMapper transformationMyBatisMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void execute(@NotNull final Integer id) {
        this.transformationMyBatisMapper.deleteAttacksByTransformationId(id);
        this.transformationMyBatisMapper.deleteTransformation(id);
    }
}
