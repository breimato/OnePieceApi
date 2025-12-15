package es.api.onepiece.core.internal.vo.character;

import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

/**
 * The Class CreateCharacterVo.
 */
@Builder
@AllArgsConstructor
@Data
public class CreateCharacterVo {

    /** The name. */
    @NotNull private String name;

    /** The description. */
    @NotNull private String description;

    /** The height. */
    @NotNull private Integer height;

    /** The age. */
    @NotNull private Integer age;

    /** The bounty. */
    @NotNull private Long bounty;

    /** The image. */
    @NotNull private String image;

    /** The status. */
    @NotNull private CharacterStatusTypeEnum status;

    /** The race id. */
    @NotNull private Integer raceId;

    /** The debut id. */
    @NotNull private Integer debutId;

    /** The fruit ids. */
    @NotNull private List<Integer> fruitIds;

    /** The haki ids. */
    @NotNull private List<Integer> hakiIds;
}
