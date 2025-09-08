package es.api.onepiece.core.internal.domain.sword;

import es.api.onepiece.core.internal.domain.debut.Debut;
import es.api.onepiece.core.internal.domain.sword.enums.SwordStatusEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Sword.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sword {

    /** The id. */
    @NotNull
    private Integer id;

    /** The name. */
    @NotNull
    private String name;

    /** The description. */
    @NotNull
    private String description;

    /** The black sword. */
    @NotNull
    private Boolean blackSword;

    /** The sword status. */
    @NotNull
    private SwordStatusEnum swordStatus;

    /** The category. */
    @NotNull
    private SwordCategory category;

    /** The debut. */
    @NotNull
    private Debut debut;
}
