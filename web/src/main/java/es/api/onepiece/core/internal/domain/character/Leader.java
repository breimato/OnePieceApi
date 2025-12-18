package es.api.onepiece.core.internal.domain.character;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Leader.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Leader {

    /** The id. */
    @NotNull
    private Integer id;

    /** The name. */
    @NotNull
    private String name;

    /** The description. */
    private String description;

    /** The image. */
    private String image;
}
