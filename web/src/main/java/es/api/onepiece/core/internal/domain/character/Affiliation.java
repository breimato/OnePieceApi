package es.api.onepiece.core.internal.domain.character;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Affiliation.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Affiliation {

    /** The id. */
    @NotNull
    private Integer id;

    /** The leader. */
    @NotNull
    private BaseCharacter leader;

    /** The name. */
    @NotNull
    private String name;

    /** The description. */
    @NotNull
    private String description;

    /** The total bounty. */
    @NotNull
    private Long totalBounty;

    /** The is active. */
    @NotNull
    private Boolean isActive;
}
