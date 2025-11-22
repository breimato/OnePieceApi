package es.api.onepiece.core.exceptions.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * The Class ExceptionMessageConstants.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessageConstants {

    /** The Constant CHARACTER_STATUS_CODE_ERROR. */
    public static final String CHARACTER_STATUS_CODE_ERROR = "OP-CH-001";

    /** The Constant CHARACTER_STATUS_MESSAGE_ERROR. */
    public static final String CHARACTER_STATUS_MESSAGE_ERROR = "Error in Character Status, Status should be ALIVE, DEAD or UNKNOWN";

    /** The Constant CHARACTER_AFFILIATION_ROLE_CODE_ERROR. */
    public static final String CHARACTER_AFFILIATION_ROLE_CODE_ERROR = "OP-CH-002";

    /** The Constant CHARACTER_AFFILIATION_ROLE_MESSAGE_ERROR. */
    public static final String CHARACTER_AFFILIATION_ROLE_MESSAGE_ERROR = "Error in Character Affiliation Role, Role should be CREWMATE, CAPTAIN or VICECAPTAIN";

    /** The Constant CHARACTER_AFFILIATION_STATUS_CODE_ERROR. */
    public static final String CHARACTER_AFFILIATION_STATUS_CODE_ERROR = "OP-CH-003";

    /** The Constant CHARACTER_AFFILIATION_STATUS_MESSAGE_ERROR. */
    public static final String CHARACTER_AFFILIATION_STATUS_MESSAGE_ERROR = "Error in Character Affiliation Status, Status should be CURRENT, FORMER or ALLIED";

    /** The Constant CHARACTER_TITLE_CODE_ERROR. */
    public static final String CHARACTER_TITLE_CODE_ERROR = "OP-CH-004";

    /** The Constant CHARACTER_TITLE_MESSAGE_ERROR. */
    public static final String CHARACTER_TITLE_MESSAGE_ERROR = "Error in Character Title, Title should be SHICHIBUKAI, YONKOU or SUPERNOVA";

    /** The Constant HAKI_TYPE_CODE_ERROR. */
    public static final String HAKI_TYPE_CODE_ERROR = "OP-HAKI-001";

    /** The Constant HAKI_TYPE_MESSAGE_ERROR. */
    public static final String HAKI_TYPE_MESSAGE_ERROR = "Error in Haki Type, Type should be HAOSHOKU, BUSOSHOKU or KENBUNSHOKU";

    /** The Constant BOAT_TYPE_CODE_ERROR. */
    public static final String BOAT_TYPE_CODE_ERROR = "OP-BOAT-001";

    /** The Constant BOAT_TYPE_MESSAGE_ERROR. */
    public static final String BOAT_TYPE_MESSAGE_ERROR = "Error in Boat Type, Type should be SLOOP, CARAVEL, BRIG, GALLEY, GALLEON, FRIGATE, SUBMARINE, RAFT or OTHER";

    /** The Constant SWORD_STATUS_CODE_ERROR. */
    public static final String SWORD_STATUS_CODE_ERROR = "OP-SWORD-001";

    /** The Constant SWORD_STATUS_MESSAGE_ERROR. */
    public static final String SWORD_STATUS_MESSAGE_ERROR = "Error in Sword Status, Status should be NORMAL, GRADED, SUPREME_GRADE, BLACK_BLADE, CURSED, BROKEN or OTHER";

    /** The Constant SWORD_CATEGORY_CODE_ERROR. */
    public static final String SWORD_CATEGORY_CODE_ERROR = "OP-SWORD-CAT-001";

    /** The Constant SWORD_CATEGORY_MESSAGE_ERROR. */
    public static final String SWORD_CATEGORY_MESSAGE_ERROR = "Error in Sword Category, Category should be SAIJO_O_WAZAMONO, O_WAZAMONO or WAZAMONO";

    /** The Constant FRUIT_TYPE_CODE_ERROR. */
    public static final String FRUIT_TYPE_CODE_ERROR = "OP-FRUIT-001";

    /** The Constant FRUIT_TYPE_MESSAGE_ERROR. */
    public static final String FRUIT_TYPE_MESSAGE_ERROR = "Error in Fruit Type, Type should be PARAMECIA, LOGIA, ZOAN, MYTHICAL_ZOAN, ANCIENT_ZOAN or ARTIFICIAL_ZOAN";

    /** The Constant CHARACTER_NOT_FOUND_CODE_ERROR. */
    public static final String CHARACTER_NOT_FOUND_CODE_ERROR = "OP-CH-005";

    /** The Constant CHARACTER_NOT_FOUND_MESSAGE_ERROR. */
    public static final String CHARACTER_NOT_FOUND_MESSAGE_ERROR = "Character not found";

}
