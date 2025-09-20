package es.api.onepiece.adapters.outbound.persistence.entities.fruit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;



/**
 * The Class FruitTypeEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FruitTypeEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

    /** The id. */
    @NotNull
    private Integer id;
    
    /** The type. */
    @NotNull
    private String type;
}
