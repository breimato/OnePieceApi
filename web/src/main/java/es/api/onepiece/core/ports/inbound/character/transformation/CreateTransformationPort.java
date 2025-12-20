package es.api.onepiece.core.ports.inbound.character.transformation;

import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.internal.vo.character.transformation.CreateTransformationVo;
import jakarta.validation.Valid;

/**
 * The Interface CreateTransformationPort.
 */
public interface CreateTransformationPort {

    /**
     * Creates the transformation.
     *
     * @param createTransformationVo the create transformation vo
     * @return the transformation
     */
    Transformation execute(@Valid CreateTransformationVo createTransformationVo);
}
