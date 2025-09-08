-- V4: Backfill race data, set NOT NULL, and add FK for character.race_id

-- Seed a default race to satisfy NOT NULL for existing characters
INSERT INTO race (name, description)
VALUES ('Human', 'Standard human race in the One Piece world')
ON CONFLICT (name) DO NOTHING;

-- Backfill characters without race
UPDATE character
SET race_id = (SELECT race_id FROM race WHERE name = 'Human')
WHERE race_id IS NULL;

-- Enforce NOT NULL on character.race_id
ALTER TABLE character ALTER COLUMN race_id SET NOT NULL;

-- Add FK constraint from character.race_id to race(race_id)
ALTER TABLE character
    ADD CONSTRAINT fk_character_race
        FOREIGN KEY (race_id) REFERENCES race(race_id);
