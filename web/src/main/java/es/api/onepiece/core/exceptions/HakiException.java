package es.api.onepiece.core.exceptions;

import lombok.Getter;

import java.io.Serial;

/**
 * The Class HakiException.
 */
@Getter
public class HakiException extends RuntimeException {

  /** The Constant serialVersionUID. */
  @Serial
  private static final long serialVersionUID = 1L;

  /** The code. */
  private final String code;

  /**
   * Instantiates a new haki exception.
   *
   * @param code the code
   * @param message the message
   */
  public HakiException(String code, String message) {
    super(message);
    this.code = code;
  }
}
