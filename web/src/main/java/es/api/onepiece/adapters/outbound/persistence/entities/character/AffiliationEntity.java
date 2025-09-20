package es.api.onepiece.adapters.outbound.persistence.entities.character;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Class AffiliationEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AffiliationEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

    /** The id. */
    @NotNull
    private Integer id;

    /** The leader. */
    @NotNull
    private BaseCharacterEntity leader;

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
