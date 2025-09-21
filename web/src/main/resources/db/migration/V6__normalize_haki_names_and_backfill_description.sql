-- V6: Normalize Haki names to HAOSHOKU / BUSOSHOKU / KENBUNSHOKU and backfill descriptions

-- If names were inserted in English in earlier data, migrate them to canonical names
UPDATE haki SET name = 'HAOSHOKU'
WHERE name IN ('Conqueror''s Haki', 'Haoshoku', 'HAOSHOKU');

UPDATE haki SET name = 'BUSOSHOKU'
WHERE name IN ('Armament Haki', 'Busoshoku', 'BUSOSHOKU');

UPDATE haki SET name = 'KENBUNSHOKU'
WHERE name IN ('Observation Haki', 'Kenbunshoku', 'KENBUNSHOKU');

-- Ensure description column exists (in case V5 was not applied on some envs)
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_name = 'haki' AND column_name = 'description'
    ) THEN
        EXECUTE 'ALTER TABLE haki ADD COLUMN description TEXT';
    END IF;
END $$;

-- Backfill descriptions for each canonical name when missing or empty
UPDATE haki SET description = 'A rare ability that exerts the user''s willpower to dominate the spirits of others.'
WHERE name = 'HAOSHOKU' AND (description IS NULL OR description = '');

UPDATE haki SET description = 'A hardening technique that reinforces offense and defense by coating with invisible armor.'
WHERE name = 'BUSOSHOKU' AND (description IS NULL OR description = '');

UPDATE haki SET description = 'A sensing technique that sharpens perception of presence, intent, and movements.'
WHERE name = 'KENBUNSHOKU' AND (description IS NULL OR description = '');
