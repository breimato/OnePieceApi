package es.api.onepiece.adapters.outbound.persistence.repository.character.transformation;

import es.api.onepiece.adapters.outbound.persistence.mapper.character.TransformationMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.TransformationMyBatisMapper;
import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.internal.vo.character.transformation.UpdateTransformationVo;
import es.api.onepiece.core.ports.outbound.character.transformation.FindTransformationsPersistencePort;
import es.api.onepiece.core.ports.outbound.character.transformation.UpdateTransformationPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class TransformationUpdateRepository.
 */
@Component
@RequiredArgsConstructor
public class TransformationUpdateRepository implements UpdateTransformationPersistencePort {

    /** The find transformations persistence port. */
    private final FindTransformationsPersistencePort findTransformationsPersistencePort;

    /** The transformation my batis mapper. */
    private final TransformationMyBatisMapper transformationMyBatisMapper;

    /** The transformation mapper. */
    private final TransformationMapper transformationMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Transformation execute(@Valid final UpdateTransformationVo updateTransformationVo) {

        final var transformationExists = this.findTransformationsPersistencePort
                .exists(updateTransformationVo.getId());

        if (BooleanUtils.isFalse(transformationExists)) {
            throw new CharacterException(
                    ExceptionMessageConstants.TRANSFORMATION_NOT_FOUND_CODE_ERROR,
                    ExceptionMessageConstants.TRANSFORMATION_NOT_FOUND_MESSAGE_ERROR);
        }

        final var transformationEntity = this.transformationMapper.toTransformationEntity(updateTransformationVo);

        this.transformationMyBatisMapper.updateTransformation(transformationEntity);

        final var updatedTransformationEntity = this.transformationMyBatisMapper
                .findById(updateTransformationVo.getId());

        return this.transformationMapper.toTransformation(updatedTransformationEntity);
    }
}
