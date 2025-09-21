package es.api.onepiece.core.exceptions;

import lombok.Getter;

import java.io.Serial;

/**
 * The Class BoatException.
 */
@Getter
public class BoatException extends RuntimeException {

  /** The Constant serialVersionUID. */
  @Serial
  private static final long serialVersionUID = 1L;

  /** The code. */
  private final String code;

  /**
   * Instantiates a new boat exception.
   *
   * @param code the code
   * @param message the message
   */
  public BoatException(String code, String message) {
    super(message);
    this.code = code;
  }
}
