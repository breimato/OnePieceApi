package es.api.onepiece.adapters.outbound.persistence.entities.character;

import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Class AttackEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttackEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

    /** The id. */
    private Integer id;
    
    /** The name. */
    private String name;
    
    /** The description. */
    private String description;
    
    /** The debut. */
    private DebutEntity debut;
    
    /** The character. */
    private CharacterEntity character;
    
    /** The transformation. */
    private TransformationEntity transformation;
}
