package es.api.onepiece.core.internal.vo.character.attack;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * The Class CreateAttackVo.
 */
@Builder
@AllArgsConstructor
@Data
public class CreateAttackVo {

    /** The name. */
    @NotNull
    private final String name;

    /** The description. */
    private final String description;

    /** The character id. */
    @NotNull
    private final Integer characterId;

    /** The transformation id. */
    private final Integer transformationId;

    /** The debut id. */
    @NotNull
    private final Integer debutId;
}
