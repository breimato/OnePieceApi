package es.api.onepiece.core.internal.domain.debut;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The Class Chapter.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {

    /** The id. */
    @NotNull
    private Integer id;

    /** The title. */
    @NotNull
    private String title;

    /** The number. */
    @NotNull
    private Integer number;

    /** The description. */
    @NotNull
    private String description;
}
