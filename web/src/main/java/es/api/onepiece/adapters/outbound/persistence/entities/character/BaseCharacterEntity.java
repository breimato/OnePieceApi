package es.api.onepiece.adapters.outbound.persistence.entities.character;

import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * The Class BaseCharacterEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseCharacterEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial private static final long serialVersionUID = 1L;

    /** The id. */
    @NotNull
    private Integer id;

    /** The name. */
    @NotNull
    private String name;
    
    /** The description. */
    @NotNull
    private String description;

    /** The height. */
    
    private Integer height;

    /** The age. */
    
    private Integer age;

    /** The bounty. */
    
    private Long bounty;

    /** The image. */
    
    private String image;

}
