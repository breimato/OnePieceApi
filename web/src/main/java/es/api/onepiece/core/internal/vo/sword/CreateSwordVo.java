package es.api.onepiece.core.internal.vo.sword;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * The Class CreateSwordVo.
 */
@Builder
@AllArgsConstructor
@Data
public class CreateSwordVo {

    /** The name. */
    @NotNull
    private final String name;

    /** The description. */
    private final String description;

    /** The black sword. */
    private final Boolean blackSword;

    /** The status id. */
    @NotNull
    private final Integer statusId;

    /** The category id. */
    private final Integer categoryId;

    /** The debut id. */
    private final Integer debutId;
}
