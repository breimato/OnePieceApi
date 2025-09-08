CREATE TABLE IF NOT EXISTS race (
    race_id     SERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL UNIQUE,
    description TEXT
);

ALTER TABLE character ADD COLUMN IF NOT EXISTS race_id INT;
