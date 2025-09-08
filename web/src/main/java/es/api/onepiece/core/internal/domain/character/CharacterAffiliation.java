package es.api.onepiece.core.internal.domain.character;

import es.api.onepiece.core.internal.domain.character.enums.CharacterAffiliationRoleEnum;
import es.api.onepiece.core.internal.domain.character.enums.CharacterAffiliationStatusEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class CharacterAffiliation.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterAffiliation {

    /** The character. */
    @NotNull
    private Character character;

    /** The affiliation. */
    @NotNull
    private Affiliation affiliation;

    /** The status. */
    @NotNull
    private CharacterAffiliationStatusEnum status;

    /** The role. */
    @NotNull
    private CharacterAffiliationRoleEnum role;
}
