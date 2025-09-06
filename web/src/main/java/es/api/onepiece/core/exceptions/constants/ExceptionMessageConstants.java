package es.api.onepiece.core.exceptions.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/** The Class ExceptionMessageConstants. */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessageConstants {

  /** The constant CAMPAIGN_STATE_CODE_ERROR. */
  public static final String CAMPAIGN_STATE_CODE_ERROR = "HA-CAMP-001";

  /** The constant CAMPAIGN_STATE_MESSAGE_ERROR. */
  public static final String CAMPAIGN_STATE_MESSAGE_ERROR =
      "Error in Campaign State, State should be DRAFT or PUBLISHED";

  /** The constant CONSTRAINT_VIOLATION_CODE_ERROR. */
  public static final String CONSTRAINT_VIOLATION_CODE_ERROR = "HA-CONS-001";

  /** The constant CAMPAIGN_DELETE_CODE_ERROR. */
  public static final String CAMPAIGN_DELETE_CODE_ERROR = "HA-CAMP-002";

  /** The constant CAMPAIGN_DELETE_MESSAGE_ERROR. */
  public static final String CAMPAIGN_DELETE_MESSAGE_ERROR =
      "Error deleting campaign and its related entities";
}
