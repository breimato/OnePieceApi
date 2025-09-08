package es.api.onepiece.adapters.outbound.persistence.entities.boat;

import es.api.onepiece.adapters.outbound.persistence.entities.character.AffiliationEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Integer id;
    
    /** The name. */
    private String name;
    
    /** The is alive. */
    private Boolean isAlive;
    
    /** The boat type. */
    private String boatType;
    
    /** The debut. */
    private DebutEntity debut;
    
    /** The affiliation. */
    private AffiliationEntity affiliation;
}
