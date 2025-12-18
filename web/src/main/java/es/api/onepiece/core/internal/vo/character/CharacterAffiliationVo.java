package es.api.onepiece.core.internal.vo.character;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * The Class CreateCharacterAffiliationVo.
 */
@Builder
@AllArgsConstructor
@Data
public class CharacterAffiliationVo {

    /** The affiliation id. */
    @NotNull
    private Integer affiliationId;

    /** The status id. */
    @NotNull
    private Integer statusId;

    /** The role id. */
    private Integer roleId;
}
