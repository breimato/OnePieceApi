package es.api.onepiece.adapters.outbound.persistence.entities.fruit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Class FruitEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FruitEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

    /** The id. */
    private Integer id;

    /** The name. */
    private String name;

    /** The description. */
    private String description;

    /** The image. */
    private String image;

    /** The type. */
    private FruitTypeEntity type;
}
