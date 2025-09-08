package es.api.onepiece.core.internal.domain.boat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The Enum BoatTypeEnum.
 */
@Getter
@AllArgsConstructor
public enum BoatTypeEnum {
    
    /** The sloop. */
    SLOOP(1),
    
    /** The caravel. */
    CARAVEL(2),
    
    /** The brig. */
    BRIG(3),
    
    /** The galley. */
    GALLEY(4),
    
    /** The galleon. */
    GALLEON(5),
    
    /** The frigate. */
    FRIGATE(6),
    
    /** The submarine. */
    SUBMARINE(7),
    
    /** The raft. */
    RAFT(8),
    
    /** The other. */
    OTHER(99);

    /** The id. */
    private final Integer id;
}
