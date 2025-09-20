package es.api.onepiece.adapters.outbound.persistence.entities.debut;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Class DebutEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DebutEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

    /** The id. */
    @NotNull
    private Integer id;

    /** The chapter. */
    @NotNull
    private ChapterEntity chapter;

    /** The episode. */
    @NotNull
    private EpisodeEntity episode;

    /** The saga. */
    @NotNull
    private SagaEntity saga;
}
