package es.api.onepiece.core.internal.domain.fruit;

import es.api.onepiece.core.internal.domain.fruit.enums.FruitTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The Class Fruit.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fruit {

    /** The id. */
    @NotNull
    private Integer id;

    /** The name. */
    @NotNull
    private String name;

    /** The description. */
    @NotNull
    private String description;

    /** The image. */
    private String image;

    /** The type. */
    @NotNull
    private FruitTypeEnum type;
}
