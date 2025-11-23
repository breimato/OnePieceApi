package es.api.onepiece.adapters.outbound.persistence.entities.character;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.util.List;

/**
 * The Class CharacterSummaryEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterSummaryEntity extends BaseCharacterEntity {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

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
