package es.api.onepiece.adapters.outbound.persistence.entities.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Class BaseCharacterEntity.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseCharacterEntity implements Serializable {

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

    /** The height. */
    private Integer height;

    /** The age. */
    private Integer age;

    /** The bounty. */
    private Long bounty;

    /** The image. */
    private String image;

    /** The status. */
    private String status;

    /** The fruit list. */
    private List<String> fruitList;

    /** The haki list. */
    private List<String> hakiList;

    /** The transformation list. */
    private List<String> transformationList;

    /** The affiliation name. */
    private String affiliationName;
}
