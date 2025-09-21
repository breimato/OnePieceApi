package es.api.onepiece.adapters.outbound.persistence.entities.character;

import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.sword.SwordEntity;
import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

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
public class CharacterEntity extends BaseCharacterEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial private static final long serialVersionUID = 1L;

    /** The status. */
    @NotNull
    private CharacterStatusTypeEnum status;

    /** The race. */
    @NotNull
    private RaceEntity race;

    /** The fruits. */
    @Valid
    private List<FruitEntity> fruits;

    /** The hakis. */
    @Valid
    private List<HakiEntity> hakis;

    /** The titles. */
    @Valid
    private List<CharacterTitleEntity> titles;

    /** The swords. */
    @Valid
    private List<SwordEntity> swords;

    /** The transformations. */
    @Valid
    private List<TransformationEntity> transformations;

    /** The attacks. */
    @Valid
    private List<AttackEntity> attacks;

    /** The jobs. */
    @Valid
    private List<JobEntity> jobs;

    /** The affiliations. */
    @Valid
    private List<CharacterAffiliationEntity> affiliations;

    /** The debut. */
    @NotNull
    private DebutEntity debut;

}
