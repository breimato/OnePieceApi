package es.api.onepiece.adapters.outbound.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Integer id;

    /** The chapter. */
    private ChapterEntity chapter;

    /** The episode. */
    private EpisodeEntity episode;

    /** The saga. */
    private SagaEntity saga;
}
