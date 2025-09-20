package es.api.onepiece.adapters.outbound.persistence.entities.sword;

import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

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
    private String swordStatus;
    
    /** The category. */
    private SwordCategoryEntity category;
    
    /** The debut. */
    @NotNull
    private DebutEntity debut;
}
