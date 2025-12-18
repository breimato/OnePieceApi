package es.api.onepiece.core.internal.domain.character;

import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.domain.sword.Sword;
import java.util.List;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The Class CharacterSummary.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterSummary {

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
    private CharacterStatusTypeEnum status;

    /** The fruits. */
    @Valid
    private List<Fruit> fruits;

    /** The hakis. */
    @Valid
    private List<Haki> hakis;

    /** The transformations. */
    @Valid
    private List<Transformation> transformations;

    /** The affiliations. */
    @Valid
    private List<Affiliation> affiliations;

    /** The titles. */
    @Valid
    private List<CharacterTitle> titles;

    /** The jobs. */
    @Valid
    private List<Job> jobs;

    /** The swords. */
    @Valid
    private List<Sword> swords;

    /** The attacks. */
    @Valid
    private List<Attack> attacks;
}
