package es.api.onepiece.adapters.outbound.persistence.entities.boat;

import es.api.onepiece.adapters.outbound.persistence.entities.character.AffiliationEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Class BoatEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoatEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

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
    private String boatType;
    
    /** The debut. */
    @NotNull
    private DebutEntity debut;
    
    /** The affiliation. */
    @NotNull
    private AffiliationEntity affiliation;
}
