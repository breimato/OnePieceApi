package es.api.onepiece.core.ports.outbound.character.transformation;

import es.api.onepiece.core.internal.domain.character.Transformation;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * The Interface FindTransformationsPersistencePort.
 */
public interface FindTransformationsPersistencePort {

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

    /**
     * Exists.
     *
     * @param id the id
     * @return the boolean
     */
    boolean exists(@NotNull Integer id);
}
