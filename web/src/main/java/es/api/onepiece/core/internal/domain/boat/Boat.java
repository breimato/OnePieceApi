package es.api.onepiece.core.internal.domain.boat;

import es.api.onepiece.core.internal.domain.character.Affiliation;
import es.api.onepiece.core.internal.domain.boat.enums.BoatTypeEnum;
import es.api.onepiece.core.internal.domain.debut.Debut;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Boat.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Boat {

    /** The id. */
    @NotNull
    private Integer id;

    /** The name. */
    @NotNull
    private String name;

    /** The is alive. */
    @NotNull
    private Boolean isAlive;

    /** The boat type. */
    private BoatTypeEnum boatType;

    /** The debut. */
    @NotNull
    private Debut debut;

    /** The affiliation. */
    @NotNull
    private Affiliation affiliation;
}
