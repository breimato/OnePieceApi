package es.api.onepiece.adapters.outbound.persistence.entities.character;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Class CharacterJobEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterJobEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

    /** The character. */
    @NotNull
    private CharacterEntity character;
    
    /** The job. */
    @NotNull
    private JobEntity job;
}
