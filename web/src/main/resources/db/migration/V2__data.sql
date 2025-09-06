
INSERT INTO saga (title, number, description) VALUES ('East Blue Saga', 1, 'Luffy begins his journey and gathers the first members of his crew in the weakest sea.'), ('Arabasta Saga', 2, 'The Straw Hat Pirates enter the Grand Line and face the Baroque Works organization.');
INSERT INTO character_status (name) VALUES ('Alive'), ('Deceased'), ('Unknown');
INSERT INTO character_affiliation_status (name) VALUES ('Current'), ('Former'), ('Allied');
INSERT INTO fruit_type (name) VALUES ('Paramecia'), ('Logia'), ('Zoan'), ('Ancient Zoan'), ('Mythical Zoan');
INSERT INTO job (name, description) VALUES ('Swordsman', 'A combatant specializing in swords.'), ('Cook', 'The master of the culinary arts on a ship.'), ('Navigator', 'An expert in cartography, meteorology, and steering a ship.'), ('Doctor', 'A medical expert responsible for the crew''s health.'), ('Yonko', 'One of the Four Emperors who rule the New World.'), ('Shichibukai', 'One of the Seven Warlords of the Sea.');
INSERT INTO role (name) VALUES ('Captain'), ('First Mate'), ('Combatant'), ('Crewmate');
INSERT INTO haki (name) VALUES ('Conqueror''s Haki'), ('Armament Haki'), ('Observation Haki');
INSERT INTO sword_status (name) VALUES ('Existent'), ('Destroyed'), ('Lost');
INSERT INTO sword_category (name) VALUES ('Supreme Grade'), ('Great Grade'), ('Skillful Grade');
INSERT INTO boat_type (name) VALUES ('Caravel'), ('Sloop'), ('Battleship');
INSERT INTO title (name) VALUES ('Emperor of the Sea'), ('Warlord of the Sea'), ('Supernova');

INSERT INTO chapter (title, number, description) VALUES ('Romance Dawn', 1, 'The story of how Luffy began his journey.'), ('That Guy, "Straw Hat Luffy"', 2, 'Luffy arrives at Shells Town and meets Koby.'), ('Enter Zoro, The Pirate Hunter', 3, 'Luffy frees Zoro from Captain Morgan.'), ('Chapter 5', 5, 'Zoro joins Luffy.'), ('The Chef of the Sea and the Bratty Cabin Boy', 43, 'Sanji is introduced at the Baratie.'), ('Chapter 42', 42, 'The Going Merry is acquired.'), ('Chapter 50', 50, 'Mihawk makes his grand entrance.'), ('Chapter 97', 97, 'Zoro acquires the Sandai Kitetsu.'), ('Chapter 100', 100, 'The crew heads to the Grand Line.'), ('Chapter 154', 154, 'Ace is properly introduced in Arabasta.'), ('Chapter 375', 375, 'Luffy unleashes Gear Second for the first time.'), ('Chapter 498', 498, 'Trafalgar Law is introduced at Sabaody.');
INSERT INTO episode (title, number, description) VALUES ('I''m Luffy! The Man Who Will Become the Pirate King!', 1, 'Anime adaptation of Chapter 1.'), ('The Great Swordsman Appears!', 2, 'Anime adaptation of Chapter 2.'), ('Morgan vs. Luffy!', 3, 'Anime adaptation of Chapter 3.'), ('The Unwelcome Guest! Sanji''s Food and Ghin''s Debt!', 20, 'Sanji''s introduction.'), ('Episode 19', 19, 'Going Merry appearance.'), ('Episode 24', 24, 'Mihawk''s appearance.'), ('Episode 49', 49, 'Sandai Kitetsu.'), ('Episode 53', 53, 'To the Grand Line.'), ('Episode 94', 94, 'Ace''s appearance.'), ('Episode 272', 272, 'Gear Second debut.'), ('Episode 392', 392, 'Law''s appearance.');

INSERT INTO chapter_episode (chapter_id, episode_id, saga_id) VALUES (1, 1, 1), (2, 2, 1), (3, 3, 1), (4, 3, 1), (5, 4, 1), (6, 5, 1), (7, 6, 1), (8, 7, 1), (9, 8, 2), (10, 9, 2), (11, 10, 2), (12, 11, 1);

INSERT INTO fruit (name, description, image_url, type_id) VALUES ('Gomu Gomu no Mi', 'Grants the consumer''s body the properties of rubber.', 'http://example.com/gomu.png', 1), ('Mera Mera no Mi', 'Allows the user to transform into, create, and control fire.', 'http://example.com/mera.png', 2), ('Ope Ope no Mi', 'Allows the user to create a "room" where they can control everything.', 'http://example.com/ope.png', 1), ('Hito Hito no Mi, Model: Nika', 'Awakened Mythical Zoan fruit that grants the user the powers of the Sun God Nika.', 'http://example.com/nika.png', 5);

INSERT INTO character (name, description, height_cm, age, bounty, image_url, status_id, fruit_id, first_appearance_id) VALUES
('Monkey D. Luffy', 'A spirited, adventure-loving pirate with the dream of finding the One Piece.', 174, 19, 3000000000, 'http://example.com/luffy.png', 1, 4, 1),
('Roronoa Zoro', 'A master of the Three-Sword Style and the crew''s first mate.', 181, 21, 1111000000, 'http://example.com/zoro.png', 1, NULL, 2),
('Vinsmoke Sanji', 'The Straw Hat''s chef, a master of the Black Leg Style martial arts.', 180, 21, 1032000000, 'http://example.com/sanji.png', 1, NULL, 5),
('Portgas D. Ace', 'The 2nd division commander of the Whitebeard Pirates and Luffy''s sworn brother.', 185, 20, 550000000, 'http://example.com/ace.png', 2, 2, 9),
('Shanks', 'Captain of the Red Hair Pirates and the man who inspired Luffy to become a pirate.', 199, 39, 4048900000, 'http://example.com/shanks.png', 1, NULL, 1),
('Dracule Mihawk', 'A world-famous pirate renowned as the "World''s Greatest Swordsman".', 198, 43, 3590000000, 'http://example.com/mihawk.png', 1, NULL, 7),
('Trafalgar D. Water Law', 'Captain of the Heart Pirates, also known as the "Surgeon of Death".', 191, 26, 3000000000, 'http://example.com/law.png', 1, 3, 12);

INSERT INTO sword (name, description, is_black_sword, status_id, category_id, first_appearance_id) VALUES
('Yoru', 'A massive, ornate black blade wielded by Mihawk. One of the 12 Supreme Grade Swords.', TRUE, 1, 1, 7),
('Wado Ichimonji', 'A sword of great personal importance to Roronoa Zoro. One of the 21 Great Grade Swords.', FALSE, 1, 2, 4),
('Sandai Kitetsu', 'A cursed but powerful blade that Zoro chose in Loguetown. A Skillful Grade Sword.', FALSE, 1, 3, 8);

INSERT INTO affiliation (name, description, leader_id, total_bounty, is_active) VALUES
('Straw Hat Pirates', 'A powerful and infamous pirate crew originating from the East Blue.', 1, 8816001000, TRUE),
('Red Hair Pirates', 'One of the most powerful pirate crews in the New World, led by Shanks.', 5, 5000000000, TRUE),
('Seven Warlords of the Sea', 'A group of seven powerful pirates allied with the World Government. Now disbanded.', NULL, 0, FALSE);

INSERT INTO boat (name, is_alive, type_id, first_appearance_id, affiliation_id) VALUES
('Going Merry', FALSE, 1, 6, 1);

INSERT INTO transformation (name, description, character_id, first_appearance_id) VALUES
('Gear Second', 'Luffy pumps blood at a high speed to increase his power and agility.', 1, 11);

INSERT INTO attack (name, description, first_appearance_id, character_id, transformation_id) VALUES
('Gomu Gomu no Jet Pistol', 'A high-speed, powerful punch launched while in Gear Second.', 11, 1, 1);

INSERT INTO character_job (character_id, job_id) VALUES (2, 1), (3, 2), (5, 4), (6, 1), (7, 4);
INSERT INTO character_haki (character_id, haki_id) VALUES (1, 1), (1, 2), (1, 3), (2, 2), (2, 3), (3, 2), (3, 3), (5, 1), (5, 2), (5, 3);
INSERT INTO character_sword (character_id, sword_id) VALUES (2, 2), (2, 3), (6, 1);

INSERT INTO character_affiliation (character_id, affiliation_id, status_id, role_id) VALUES
(1, 1, 1, 1),
(2, 1, 1, 2),
(3, 1, 1, 4),
(6, 3, 2, NULL),
(7, 2, 3, 1);

INSERT INTO character_title (character_id, title_id, is_active) VALUES (1, 1, TRUE), (1, 3, TRUE), (2, 3, TRUE), (3, 3, TRUE), (5, 1, TRUE), (6, 2, FALSE), (7, 3, TRUE);
