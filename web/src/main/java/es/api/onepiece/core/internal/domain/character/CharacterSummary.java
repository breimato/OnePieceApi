package es.api.onepiece.core.internal.domain.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * The Class CharacterSummary.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CharacterSummary extends BaseCharacter {

    /** The status. */
    private String status;

    /** The fruit list. */
    private List<String> fruitList;

    /** The haki list. */
    private List<String> hakiList;

    /** The transformation list. */
    private List<String> transformationList;

    /** The affiliation. */
    private String affiliation;
}
