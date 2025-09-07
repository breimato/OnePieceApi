package es.api.onepiece.adapters.outbound.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Integer id;
    
    /** The title. */
    private String title;
    
    /** The number. */
    private Integer number;
    
    /** The description. */
    private String description;
}
