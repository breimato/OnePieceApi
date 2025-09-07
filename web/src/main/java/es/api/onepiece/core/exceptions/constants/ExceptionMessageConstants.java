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
  public static final String CHARACTER_STATUS_MESSAGE_ERROR =
      "Error in Character Status, Status should be ALIVE, DEAD or UNKNOWN";

  /** The Constant FRUIT_TYPE_CODE_ERROR. */
  public static final String FRUIT_TYPE_CODE_ERROR = "OP-FRUIT-001";

  /** The Constant FRUIT_TYPE_MESSAGE_ERROR. */
  public static final String FRUIT_TYPE_MESSAGE_ERROR =
          "Error in Fruit Type, Type should be , PARAMECIA, LOGIA, ZOAN, MYTHICAL_ZOAN, ANCIENT_ZOAN," +
                  " or ARTIFICIAL_ZOAN ";

  /** The Constant CONSTRAINT_VIOLATION_CODE_ERROR. */
  public static final String CONSTRAINT_VIOLATION_CODE_ERROR = "OP-CONS-001";

}
