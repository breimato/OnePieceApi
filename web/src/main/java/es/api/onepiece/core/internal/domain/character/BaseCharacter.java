package es.api.onepiece.core.internal.domain.character;

import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;
import java.util.List;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The Class BaseCharacter.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseCharacter {

    /** The id. */
    @NotNull
    private Integer id;

    /** The name. */
    @NotNull
    private String name;

    /** The description. */
    @NotNull
    private String description;

    /** The height. */
    @NotNull
    private Integer height;

    /** The age. */
    @NotNull
    private Integer age;

    /** The bounty. */
    @NotNull
    private Long bounty;

    /** The image. */
    @NotNull
    private String image;

    /** The status. */
    private CharacterStatusTypeEnum status;

    /** The fruit list. */
    private List<String> fruitList;

    /** The haki list. */
    private List<String> hakiList;

    /** The transformation list. */
    private List<String> transformationList;

    /** The affiliation. */
    private String affiliation;
}
