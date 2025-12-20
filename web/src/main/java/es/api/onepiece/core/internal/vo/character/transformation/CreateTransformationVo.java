package es.api.onepiece.core.internal.vo.character.transformation;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * The Class CreateTransformationVo.
 */
@Builder
@AllArgsConstructor
@Data
public class CreateTransformationVo {

    /** The name. */
    @NotNull
    private final String name;

    /** The description. */
    private final String description;

    /** The character id. */
    @NotNull
    private final Integer characterId;

    /** The debut id. */
    private final Integer debutId;
}
