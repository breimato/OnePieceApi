package es.api.onepiece.core.internal.domain.character;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class CharacterHaki.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterHaki {

    /** The character. */
    @NotNull
    private Character character;

    /** The haki. */
    @NotNull
    private Haki haki;
}
