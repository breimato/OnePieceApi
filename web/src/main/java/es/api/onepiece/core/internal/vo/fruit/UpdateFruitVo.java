package es.api.onepiece.core.internal.vo.fruit;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * The Class UpdateFruitVo.
 */
@Builder
@AllArgsConstructor
@Data
public class UpdateFruitVo {

    /** The id. */
    @NotNull
    private final Integer id;

    /** The name. */
    private final String name;

    /** The description. */
    private final String description;

    /** The image. */
    private final String image;

    /** The type id. */
    private final Integer typeId;
}
