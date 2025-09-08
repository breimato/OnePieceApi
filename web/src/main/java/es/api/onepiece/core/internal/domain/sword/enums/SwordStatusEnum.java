package es.api.onepiece.core.internal.domain.sword.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * The Enum SwordStatusEnum.
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum SwordStatusEnum {
    
    /** The normal. */
    NORMAL(1),
    
    /** The graded. */
    GRADED(2),
    
    /** The supreme grade. */
    SUPREME_GRADE(3),
    
    /** The black blade. */
    BLACK_BLADE(4),
    
    /** The cursed. */
    CURSED(5),
    
    /** The broken. */
    BROKEN(6),
    
    /** The other. */
    OTHER(99);

    /** The id. */
    private final Integer id;
}
