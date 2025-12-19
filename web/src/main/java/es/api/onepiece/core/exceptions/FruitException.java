package es.api.onepiece.core.exceptions;

import lombok.Getter;

import java.io.Serial;

/**
 * The Class FruitException.
 */
@Getter
public class FruitException extends RuntimeException {

  /** The Constant serialVersionUID. */
  @Serial
  private static final long serialVersionUID = 1L;

  /** The Constant FRUIT_NOT_FOUND_CODE_ERROR. */
  public static final String FRUIT_NOT_FOUND_CODE_ERROR = "FRUIT_NOT_FOUND";

  /** The Constant FRUIT_NOT_FOUND_MESSAGE. */
  public static final String FRUIT_NOT_FOUND_MESSAGE = "Fruit not found";

  /** The code. */
  private final String code;

  /**
   * Instantiates a new fruit exception.
   *
   * @param code    the code
   * @param message the message
   */
  public FruitException(String code, String message) {
    super(message);
    this.code = code;
  }
}
