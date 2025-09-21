package es.api.onepiece.core.internal.domain.character.enums;

import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * The Enum CharacterAffiliationRoleEnum.
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum CharacterAffiliationRoleEnum {
    
    /** The crewmate. */
    CREWMATE(1),
    
    /** The captain. */
    CAPTAIN(2),
    
    /** The vicecaptain. */
    VICECAPTAIN(3);

    /** The id. */
    private final Integer id;

    /**
     * Gets the by name.
     *
     * @param name the name
     * @return the by name
     */
    public static CharacterAffiliationRoleEnum getByName(final String name) {
        try {
            return CharacterAffiliationRoleEnum.valueOf(name);
        } catch (final CharacterException exception) {
            log.error(ExceptionMessageConstants.CHARACTER_AFFILIATION_ROLE_MESSAGE_ERROR, exception);
            throw new CharacterException(
                ExceptionMessageConstants.CHARACTER_AFFILIATION_ROLE_CODE_ERROR,
                ExceptionMessageConstants.CHARACTER_AFFILIATION_ROLE_MESSAGE_ERROR);
        }
    }

    /**
     * Gets the by type.
     *
     * @param characterAffiliationRole the character affiliation role
     * @return the by type
     */
    public static String getByType(final CharacterAffiliationRoleEnum characterAffiliationRole) {
        try {
            return characterAffiliationRole.name();
        } catch (final CharacterException exception) {
            log.error(ExceptionMessageConstants.CHARACTER_AFFILIATION_ROLE_MESSAGE_ERROR, exception);
            throw new CharacterException(
                ExceptionMessageConstants.CHARACTER_AFFILIATION_ROLE_CODE_ERROR,
                ExceptionMessageConstants.CHARACTER_AFFILIATION_ROLE_MESSAGE_ERROR);
        }
    }
}
