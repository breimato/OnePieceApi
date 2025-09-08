-- V3: Add race table and nullable race_id column on character

-- Create race table
CREATE TABLE IF NOT EXISTS race (
    race_id     SERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL UNIQUE,
    description TEXT
);

-- Add nullable race_id column to character (backfill in V4, then set NOT NULL)
ALTER TABLE character ADD COLUMN IF NOT EXISTS race_id INT;
