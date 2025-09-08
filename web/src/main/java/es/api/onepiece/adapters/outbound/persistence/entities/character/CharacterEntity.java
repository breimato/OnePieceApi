package es.api.onepiece.adapters.outbound.persistence.entities.character;

import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    
    private CharacterStatusTypeEnum status;

    /** The race. */
    
    private RaceEntity race;

    /** The fruits. */
    
    private List<FruitEntity> fruits;

    /** The hakis. */
    
    private List<HakiEntity> hakis;

    /** The titles. */
    
    private List<CharacterTitleEntity> titles;

    /** The jobs. */
    
    private List<JobEntity> jobs;

    /** The affiliations. */
    
    private List<CharacterAffiliationEntity> affiliations;

    /** The debut. */
    
    private DebutEntity debut;

}
