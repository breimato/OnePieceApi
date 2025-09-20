package es.api.onepiece.core.internal.domain.character;

import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;
import es.api.onepiece.core.internal.domain.debut.Debut;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;

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
    @Valid
    private List<Fruit> fruits;

    /** The hakis. */
    @Valid
    private List<Haki> hakis;

    /** The titles. */
    @Valid
    private List<CharacterTitle> titles;

    /** The jobs. */
    @Valid
    private List<Job> jobs;

    /** The affiliations. */
    @Valid
    private List<CharacterAffiliation> affiliations;

    /** The debut. */
    @NotNull
    private Debut debut;


}
