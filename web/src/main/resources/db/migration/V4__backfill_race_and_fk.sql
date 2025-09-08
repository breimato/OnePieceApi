
INSERT INTO race (name, description)
VALUES ('Human', 'Standard human race in the One Piece world')
ON CONFLICT (name) DO NOTHING;

UPDATE character
SET race_id = (SELECT race_id FROM race WHERE name = 'Human')
WHERE race_id IS NULL;

ALTER TABLE character ALTER COLUMN race_id SET NOT NULL;

ALTER TABLE character
    ADD CONSTRAINT fk_character_race
        FOREIGN KEY (race_id) REFERENCES race(race_id);
