package es.api.onepiece.core.internal.domain.character;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class CharacterJob.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterJob {

    /** The character. */
    @NotNull
    private Character character;

    /** The job. */
    @NotNull
    private Job job;
}
