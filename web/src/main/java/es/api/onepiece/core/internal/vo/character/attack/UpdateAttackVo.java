package es.api.onepiece.core.internal.vo.character.attack;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * The Class UpdateAttackVo.
 */
@Builder
@AllArgsConstructor
@Data
public class UpdateAttackVo {

    /** The id. */
    @NotNull
    private final Integer id;

    /** The name. */
    private final String name;

    /** The description. */
    private final String description;

    /** The character id. */
    private final Integer characterId;

    /** The transformation id. */
    private final Integer transformationId;

    /** The debut id. */
    private final Integer debutId;
}
