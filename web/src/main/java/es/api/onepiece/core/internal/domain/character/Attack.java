package es.api.onepiece.core.internal.domain.character;

import es.api.onepiece.core.internal.domain.debut.Debut;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Attack.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attack {

    /** The id. */
    @NotNull
    private Integer id;

    /** The name. */
    @NotNull
    private String name;

    /** The description. */
    @NotNull
    private String description;

    /** The debut. */
    @NotNull
    private Debut debut;

    /** The character. */
    @NotNull
    private Character character;

    /** The transformation. */
    private Transformation transformation;
}
