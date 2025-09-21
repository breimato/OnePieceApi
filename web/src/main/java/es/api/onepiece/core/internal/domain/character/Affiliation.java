package es.api.onepiece.core.internal.domain.character;

import es.api.onepiece.core.internal.domain.boat.Boat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    /** The boats. */
    @Valid
    private List<Boat> boats;
}
