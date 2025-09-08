package es.api.onepiece.core.internal.domain.sword;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class SwordCategory.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SwordCategory {

    /** The id. */
    @NotNull
    private Integer id;

    /** The name. */
    @NotNull
    private String name;

    /** The description. */
    @NotNull
    private String description;
}
