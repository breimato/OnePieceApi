package es.api.onepiece.adapters.outbound.persistence.entities.character;

import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

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
    @NotNull
    private Integer id;
    
    /** The name. */
    @NotNull
    private String name;
    
    /** The description. */
    @NotNull
    private String description;
    
    /** The debut. */
    @NotNull
    private DebutEntity debut;
    
    /** The character. */
    @NotNull
    private CharacterEntity character;
    
    /** The transformation. */
    private TransformationEntity transformation;
}
