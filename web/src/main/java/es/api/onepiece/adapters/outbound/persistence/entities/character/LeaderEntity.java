package es.api.onepiece.adapters.outbound.persistence.entities.character;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Class LeaderEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaderEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

    /** The id. */
    @NotNull
    private Integer id;

    /** The name. */
    @NotNull
    private String name;

    /** The description. */
    private String description;

    /** The image. */
    private String image;
}
