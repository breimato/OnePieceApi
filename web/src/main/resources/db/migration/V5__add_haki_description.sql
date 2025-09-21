-- V5: Add description column to haki and backfill

ALTER TABLE haki ADD COLUMN IF NOT EXISTS description TEXT;

-- Backfill basic descriptions
UPDATE haki SET description = 'A rare ability that exerts the user''s willpower to dominate the spirits of others.'
WHERE name = 'Conqueror''s Haki' AND (description IS NULL OR description = '');

UPDATE haki SET description = 'A hardening technique that reinforces offense and defense by coating with invisible armor.'
WHERE name = 'Armament Haki' AND (description IS NULL OR description = '');

UPDATE haki SET description = 'A sensing technique that sharpens perception of presence, intent, and movements.'
WHERE name = 'Observation Haki' AND (description IS NULL OR description = '');
