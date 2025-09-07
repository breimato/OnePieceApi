package es.api.onepiece.core.internal.domain.debut;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The Class Debut.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Debut {

    /** The id. */
    @NotNull
    private Integer id;

    /** The chapter. */
    @NotNull
    private Chapter chapter;

    /** The episode. */
    @NotNull
    private Episode episode;

    /** The saga. */
    @NotNull
    private Saga saga;

}
