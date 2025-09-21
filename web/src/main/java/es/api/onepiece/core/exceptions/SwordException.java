package es.api.onepiece.core.exceptions;

import lombok.Getter;

import java.io.Serial;

/**
 * The Class SwordException.
 */
@Getter
public class SwordException extends RuntimeException {

  /** The Constant serialVersionUID. */
  @Serial
  private static final long serialVersionUID = 1L;

  /** The code. */
  private final String code;

  /**
   * Instantiates a new sword exception.
   *
   * @param code the code
   * @param message the message
   */
  public SwordException(String code, String message) {
    super(message);
    this.code = code;
  }
}
