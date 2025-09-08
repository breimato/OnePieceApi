package es.api.onepiece.core.internal.domain.character;

import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;
import es.api.onepiece.core.internal.domain.debut.Debut;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * The Class Character.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Character extends BaseCharacter {

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
