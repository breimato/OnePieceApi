package es.api.onepiece.adapters.outbound.persistence.entities.debut;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Class EpisodeEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

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
