-- V7: Support multiple fruits per character

-- Create the join table
CREATE TABLE character_fruit (
    character_id INT NOT NULL,
    fruit_id INT NOT NULL,
    PRIMARY KEY (character_id, fruit_id),
    CONSTRAINT fk_cf_character FOREIGN KEY (character_id) REFERENCES character(character_id),
    CONSTRAINT fk_cf_fruit FOREIGN KEY (fruit_id) REFERENCES fruit(fruit_id)
);

-- Migrate existing data
INSERT INTO character_fruit (character_id, fruit_id)
SELECT character_id, fruit_id
FROM character
WHERE fruit_id IS NOT NULL;

-- Drop the old column
ALTER TABLE character DROP CONSTRAINT fk_character_fruit;
ALTER TABLE character DROP COLUMN fruit_id;
