package es.api.onepiece.adapters.outbound.persistence.repository.character.transformation;

import es.api.onepiece.adapters.outbound.persistence.mapper.character.TransformationMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.TransformationMyBatisMapper;
import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.internal.vo.character.transformation.CreateTransformationVo;
import es.api.onepiece.core.ports.outbound.character.transformation.CreateTransformationPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The Class TransformationCreateRepository.
 */
@Component
@RequiredArgsConstructor
public class TransformationCreateRepository implements CreateTransformationPersistencePort {

    /** The transformation my batis mapper. */
    private final TransformationMyBatisMapper transformationMyBatisMapper;

    /** The transformation mapper. */
    private final TransformationMapper transformationMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Transformation execute(@Valid final CreateTransformationVo createTransformationVo) {

        final var transformationEntity = this.transformationMapper.toTransformationEntity(createTransformationVo);

        this.transformationMyBatisMapper.insertTransformation(transformationEntity);

        final var createdTransformationEntity = this.transformationMyBatisMapper.findById(transformationEntity.getId());

        return this.transformationMapper.toTransformation(createdTransformationEntity);
    }
}
