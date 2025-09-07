package es.api.onepiece.adapters.outbound.persistence.entities;

import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * The Class CharacterEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial private static final long serialVersionUID = 1L;


    /** The id. */
    private Integer id;

    /** The name. */
    private String name;

    
    /** The description. */
    private String description;

    /** The height. */
    
    private Integer height;

    /** The age. */
    
    private Integer age;

    /** The bounty. */
    
    private Long bounty;

    /** The image. */
    
    private String image;

    /** The status. */
    
    private CharacterStatusTypeEnum status;

    /** The fruits. */
    
    private List<FruitEntity> fruits;

    /** The debut. */
    
    private DebutEntity debut;

}
