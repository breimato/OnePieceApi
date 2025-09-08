package es.api.onepiece.adapters.outbound.persistence.entities.character;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Class HakiEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HakiEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

    /** The id. */
    private Integer id;
    
    /** The name. */
    private String name;
    
    /** The description. */
    private String description;
}
