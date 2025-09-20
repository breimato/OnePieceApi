package es.api.onepiece.adapters.outbound.persistence.entities.character;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Class CharacterHakiEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterHakiEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

    /** The character. */
    @NotNull
    private CharacterEntity character;
    
    /** The haki. */
    @NotNull
    private HakiEntity haki;
}
