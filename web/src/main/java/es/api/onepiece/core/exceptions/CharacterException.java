package es.api.onepiece.core.exceptions;

import lombok.Getter;

/** Domain-level exception for campaign errors. */
@Getter
public class CharacterException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private final String code;

  public CharacterException(String code, String message) {
    super(message);
    this.code = code;
  }
}
