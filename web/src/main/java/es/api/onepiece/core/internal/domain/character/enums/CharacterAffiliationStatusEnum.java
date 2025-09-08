package es.api.onepiece.core.internal.domain.character.enums;

import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * The Enum CharacterAffiliationStatusEnum.
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum CharacterAffiliationStatusEnum {

    /** The current. */
    CURRENT(1),
    
    /** The former. */
    FORMER(2),
    
    /** The allied. */
    ALLIED(3);

    /** The id. */
    private final Integer id;

    /**
     * Gets the by name.
     *
     * @param name the name
     * @return the by name
     */
    public static CharacterAffiliationStatusEnum getByName(final String name) {
        try {
            return CharacterAffiliationStatusEnum.valueOf(name);
        } catch (final Exception exception) {
            log.error(ExceptionMessageConstants.CHARACTER_STATUS_MESSAGE_ERROR, exception);
            throw new CharacterException(
                ExceptionMessageConstants.CHARACTER_STATUS_CODE_ERROR,
                ExceptionMessageConstants.CHARACTER_STATUS_MESSAGE_ERROR);
        }
    }

    /**
     * Gets the by type.
     *
     * @param type the type
     * @return the by type
     */
    public static String getByType(final CharacterAffiliationStatusEnum type) {
        try {
            return type.name();
        } catch (final RuntimeException exception) {
            log.error(ExceptionMessageConstants.CHARACTER_STATUS_MESSAGE_ERROR, exception);
            throw new CharacterException(
                ExceptionMessageConstants.CHARACTER_STATUS_CODE_ERROR,
                ExceptionMessageConstants.CHARACTER_STATUS_MESSAGE_ERROR);
        }
    }
}
