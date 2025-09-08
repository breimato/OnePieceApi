package es.api.onepiece.adapters.outbound.persistence.entities.sword;

import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Class SwordEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SwordEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

    /** The id. */
    private Integer id;
    
    /** The name. */
    private String name;
    
    /** The description. */
    private String description;
    
    /** The black sword. */
    private Boolean blackSword;
    
    /** The sword status. */
    private String swordStatus;
    
    /** The category. */
    private SwordCategoryEntity category;
    
    /** The debut. */
    private DebutEntity debut;
}
