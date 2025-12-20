package es.api.onepiece.core.ports.inbound.character.transformation;

import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.internal.vo.character.transformation.UpdateTransformationVo;
import jakarta.validation.Valid;

/**
 * The Interface UpdateTransformationPort.
 */
public interface UpdateTransformationPort {

    /**
     * Updates the transformation.
     *
     * @param updateTransformationVo the update transformation vo
     * @return the transformation
     */
    Transformation execute(@Valid UpdateTransformationVo updateTransformationVo);
}
