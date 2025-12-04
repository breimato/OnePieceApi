package es.api.onepiece.adapters.outbound.persistence.entities.character;

import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.sword.SwordEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.Valid;

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

    /** The status id. */
    private String statusId;

    /** The race id. */
    private Integer raceId;

    /** The debut id. */
    private Integer debutId;

    /** The status. */
    private CharacterStatusEntity status;

    /** The race. */
    private RaceEntity race;

    /** The debut. */
    private DebutEntity debut;

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

}