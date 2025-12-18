package es.api.onepiece.adapters.outbound.persistence.entities.character;

import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Class CharacterSummaryEntity.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterSummaryEntity implements Serializable {

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
    private CharacterStatusEntity status;

    /** The fruits. */
    @Valid
    private List<FruitEntity> fruits;

    /** The hakis. */
    @Valid
    private List<HakiEntity> hakis;

    /** The transformations. */
    @Valid
    private List<TransformationEntity> transformations;

    /** The affiliations. */
    @Valid
    private List<AffiliationEntity> affiliations;

    /** The titles. */
    @Valid
    private List<CharacterTitleEntity> titles;

    /** The jobs. */
    @Valid
    private List<JobEntity> jobs;

    /** The swords. */
    @Valid
    private List<es.api.onepiece.adapters.outbound.persistence.entities.sword.SwordEntity> swords;

    /** The attacks. */
    @Valid
    private List<AttackEntity> attacks;
}
