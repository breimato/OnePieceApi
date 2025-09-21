package es.api.onepiece.core.internal.domain.character;

import es.api.onepiece.core.internal.domain.character.enums.CharacterTitleTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class CharacterTitle.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterTitle {

    /** The id. */
    @NotNull
    private Integer id;

    /** The title. */
    @NotNull
    private CharacterTitleTypeEnum title;

    /** The is active. */
    @NotNull
    private Boolean isActive;
}
