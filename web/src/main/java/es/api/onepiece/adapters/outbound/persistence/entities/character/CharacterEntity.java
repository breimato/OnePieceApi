package es.api.onepiece.adapters.outbound.persistence.entities.character;

import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.sword.SwordEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * The Class CharacterEntity.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterEntity implements Serializable {

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

    /** The status id. */
    private Integer statusId;

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
    private List<AffiliationEntity> affiliations;
}