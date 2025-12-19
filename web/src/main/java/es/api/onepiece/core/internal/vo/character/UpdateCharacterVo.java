package es.api.onepiece.core.internal.vo.character;

import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * The Class UpdateCharacterVo.
 */
@Builder
@AllArgsConstructor
@Data
public class UpdateCharacterVo {

    /** The id. */
    @NotNull
    private Integer id;

    /** The name. */
    private String name;

    /** The description. */
    private String description;

    /** The height. */
    private Integer height;

    /** The age. */
    private Integer age;

    /** The bounty. */
    private Long bounty;

    /** The image. */
    private String image;

    /** The status. */
    private CharacterStatusTypeEnum status;

    /** The race id. */
    private Integer raceId;

    /** The debut id. */
    private Integer debutId;

    /** The fruit ids. */
    private List<Integer> fruitIds;

    /** The haki ids. */
    private List<Integer> hakiIds;

    /** The title ids. */
    private List<Integer> titleIds;

    /** The job ids. */
    private List<Integer> jobIds;

    /** The character affiliations. */
    private List<CharacterAffiliationVo> characterAffiliations;

    /** The sword ids. */
    private List<Integer> swordIds;

    /** The transformation ids. */
    private List<Integer> transformationIds;

    /** The attack ids. */
    private List<Integer> attackIds;
}
