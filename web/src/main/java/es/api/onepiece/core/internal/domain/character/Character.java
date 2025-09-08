package es.api.onepiece.core.internal.domain.character;

import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;
import es.api.onepiece.core.internal.domain.debut.Debut;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The Class Character.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Character {

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
    @NotNull
    private Integer height;

    /** The age. */
    @NotNull
    private Integer age;

    /** The bounty. */
    @NotNull
    private Long bounty;

    /** The image. */
    @NotNull
    private String image;

    /** The status. */
    @NotNull
    private CharacterStatusTypeEnum status;

    /** The race. */
    @NotNull
    private Race race;

    /** The fruits. */
    @NotNull
    private List<Fruit> fruits;

    /** The hakis. */
    @NotNull
    private List<Haki> hakis;

    /** The titles. */
    @NotNull
    private List<CharacterTitle> titles;

    /** The jobs. */
    @NotNull
    private List<Job> jobs;

    /** The affiliations. */
    @NotNull
    private List<CharacterAffiliation> affiliations;

    /** The debut. */
    @NotNull
    private Debut debut;


}
