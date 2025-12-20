package es.api.onepiece.adapters.outbound.persistence.repository.character.transformation;

import es.api.onepiece.adapters.outbound.persistence.mapper.character.TransformationMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.TransformationMyBatisMapper;
import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.ports.outbound.character.transformation.FindTransformationsPersistencePort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * The Class TransformationFindRepository.
 */
@Component
@RequiredArgsConstructor
public class TransformationFindRepository implements FindTransformationsPersistencePort {

    /** The transformation my batis mapper. */
    private final TransformationMyBatisMapper transformationMyBatisMapper;

    /** The transformation mapper. */
    private final TransformationMapper transformationMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Transformation> findAll() {
        final var transformationEntities = this.transformationMyBatisMapper.findAll();
        return this.transformationMapper.toTransformationList(transformationEntities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Transformation findById(@NotNull final Integer id) {
        final var transformationEntity = this.transformationMyBatisMapper.findById(id);
        if (Objects.isNull(transformationEntity)) {
            throw new CharacterException(ExceptionMessageConstants.TRANSFORMATION_NOT_FOUND_CODE_ERROR,
                    ExceptionMessageConstants.TRANSFORMATION_NOT_FOUND_MESSAGE_ERROR);
        }
        return this.transformationMapper.toTransformation(transformationEntity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean exists(@NotNull final Integer id) {
        return this.transformationMyBatisMapper.exists(id);
    }
}
