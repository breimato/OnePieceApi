package es.api.onepiece.core.internal.vo.fruit;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * The Class CreateFruitVo.
 */
@Builder
@AllArgsConstructor
@Data
public class CreateFruitVo {

    /** The name. */
    @NotNull
    private final String name;

    /** The description. */
    @NotNull
    private final String description;

    /** The image. */
    private final String image;

    /** The type id. */
    @NotNull
    private final Integer typeId;
}
