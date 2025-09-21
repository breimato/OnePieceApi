package es.api.onepiece.core.internal.domain.sword;

import es.api.onepiece.core.internal.domain.sword.enums.SwordCategoryTypeEnum;
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

    /** The type. */
    @NotNull
    private SwordCategoryTypeEnum type;

    /** The description. */
    @NotNull
    private String description;
}
