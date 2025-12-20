package es.api.onepiece.core.ports.inbound.character.transformation;

import es.api.onepiece.core.internal.domain.character.Transformation;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * The Interface GetTransformationsPort.
 */
public interface GetTransformationsPort {

    /**
     * Find all.
     *
     * @return the list
     */
    List<Transformation> findAll();

    /**
     * Find by id.
     *
     * @param id the id
     * @return the transformation
     */
    Transformation findById(@NotNull Integer id);
}
