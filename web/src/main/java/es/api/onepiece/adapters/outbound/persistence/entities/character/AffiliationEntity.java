package es.api.onepiece.adapters.outbound.persistence.entities.character;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Integer id;

    /** The leader. */
    private BaseCharacterEntity leader;

    /** The name. */
    private String name;

    /** The description. */
    private String description;

    /** The total bounty. */
    private Long totalBounty;

    /** The is active. */
    private Boolean isActive;
}
