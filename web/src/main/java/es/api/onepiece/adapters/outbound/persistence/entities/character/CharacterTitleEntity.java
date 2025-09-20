package es.api.onepiece.adapters.outbound.persistence.entities.character;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * The Class CharacterTitleEntity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterTitleEntity implements Serializable {

    /** The Constant serialVersionUID. */
    @Serial
    private static final long serialVersionUID = 1L;

    /** The id. */
    @NotNull
    private Integer id;
    
    /** The character. */
    @NotNull
    private CharacterEntity character;
    
    /** The title. */
    @NotNull
    private String title;
    
    /** The is active. */
    @NotNull
    private Boolean isActive;
}
