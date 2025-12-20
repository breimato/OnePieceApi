package es.api.onepiece.core.internal.vo.character.transformation;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * The Class UpdateTransformationVo.
 */
@Builder
@AllArgsConstructor
@Data
public class UpdateTransformationVo {

    /** The id. */
    @NotNull
    private final Integer id;

    /** The name. */
    private final String name;

    /** The description. */
    private final String description;

    /** The character id. */
    private final Integer characterId;

    /** The debut id. */
    private final Integer debutId;
}
