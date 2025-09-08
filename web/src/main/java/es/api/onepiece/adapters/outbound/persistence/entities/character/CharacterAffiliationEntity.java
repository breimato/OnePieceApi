package es.api.onepiece.adapters.outbound.persistence.entities.character;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Class CharacterAffiliationEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterAffiliationEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

    /** The character. */
    private CharacterEntity character;
    
    /** The affiliation. */
    private AffiliationEntity affiliation;

    /** The status. */
    private String status;
    
    /** The role. */
    private String role;
}
