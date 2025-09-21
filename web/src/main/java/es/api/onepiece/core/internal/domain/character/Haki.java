package es.api.onepiece.core.internal.domain.character;

import es.api.onepiece.core.internal.domain.character.enums.HakiTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Haki.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Haki {

    /** The id. */
    @NotNull
    private Integer id;

    /** The type. */
    @NotNull
    private HakiTypeEnum type;

    /** The description. */
    @NotNull
    private String description;
}
