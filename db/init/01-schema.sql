CREATE TABLE saga ( saga_id SERIAL PRIMARY KEY, title VARCHAR(150) NOT NULL, number SMALLINT NOT NULL, description TEXT );
CREATE TABLE character_affiliation_status ( id SERIAL PRIMARY KEY, name VARCHAR(50) NOT NULL UNIQUE );
CREATE TABLE character_status ( id SERIAL PRIMARY KEY, name VARCHAR(50) NOT NULL UNIQUE );
CREATE TABLE fruit_type ( id SERIAL PRIMARY KEY, name VARCHAR(50) NOT NULL UNIQUE );
CREATE TABLE job ( job_id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL UNIQUE, description TEXT );
CREATE TABLE sword_status ( id SERIAL PRIMARY KEY, name VARCHAR(50) NOT NULL UNIQUE );
CREATE TABLE sword_category ( id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL UNIQUE );
CREATE TABLE boat_type ( id SERIAL PRIMARY KEY, name VARCHAR(50) NOT NULL UNIQUE );
CREATE TABLE title ( title_id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL UNIQUE );
CREATE TABLE haki ( id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL UNIQUE );
CREATE TABLE chapter ( chapter_id SERIAL PRIMARY KEY, title VARCHAR(150) NOT NULL, number SMALLINT NOT NULL UNIQUE, description TEXT );
CREATE TABLE episode ( episode_id SERIAL PRIMARY KEY, title VARCHAR(150) NOT NULL, number SMALLINT NOT NULL UNIQUE, description TEXT );
CREATE TABLE role ( id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL UNIQUE ); -- NUEVA TABLA

CREATE TABLE chapter_episode (
    chapter_episode_id SERIAL PRIMARY KEY, chapter_id INT NOT NULL, episode_id INT NOT NULL, saga_id INT NOT NULL,
    UNIQUE (chapter_id, episode_id, saga_id)
);

CREATE TABLE fruit (
    fruit_id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL UNIQUE, description TEXT, image_url VARCHAR(255), type_id INT NOT NULL
);

CREATE TABLE character (
    character_id SERIAL PRIMARY KEY, name VARCHAR(150) NOT NULL, description TEXT, height_cm INT, age INT, bounty BIGINT,
    image_url VARCHAR(255), status_id INT NOT NULL, fruit_id INT, first_appearance_id INT NOT NULL
);

CREATE TABLE affiliation (
    affiliation_id SERIAL PRIMARY KEY, leader_id INT, name VARCHAR(150) NOT NULL, description TEXT, total_bounty BIGINT, is_active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE boat (
    boat_id SERIAL PRIMARY KEY, name VARCHAR(150) NOT NULL, is_alive BOOLEAN NOT NULL DEFAULT TRUE, type_id INT,
    first_appearance_id INT NOT NULL, affiliation_id INT NOT NULL
);

CREATE TABLE sword (
    sword_id SERIAL PRIMARY KEY, name VARCHAR(150) NOT NULL, description TEXT, is_black_sword BOOLEAN NOT NULL DEFAULT FALSE,
    status_id INT NOT NULL, category_id INT, first_appearance_id INT NOT NULL
);

CREATE TABLE transformation (
    transformation_id SERIAL PRIMARY KEY, name VARCHAR(150) NOT NULL, description TEXT, character_id INT NOT NULL, first_appearance_id INT NOT NULL
);

CREATE TABLE attack (
    attack_id SERIAL PRIMARY KEY, name VARCHAR(150) NOT NULL, description TEXT, first_appearance_id INT NOT NULL,
    character_id INT NOT NULL, transformation_id INT
);

CREATE TABLE character_affiliation (
    character_id INT NOT NULL, affiliation_id INT NOT NULL, status_id INT NOT NULL,
    role_id INT,
    PRIMARY KEY (character_id, affiliation_id, status_id)
);
CREATE TABLE character_job ( character_id INT NOT NULL, job_id INT NOT NULL, PRIMARY KEY (character_id, job_id) );
CREATE TABLE character_haki ( character_id INT NOT NULL, haki_id INT NOT NULL, PRIMARY KEY (character_id, haki_id) );
CREATE TABLE character_sword ( character_id INT NOT NULL, sword_id INT NOT NULL, PRIMARY KEY (character_id, sword_id) );
CREATE TABLE character_title ( character_id INT NOT NULL, title_id INT NOT NULL, is_active BOOLEAN NOT NULL DEFAULT TRUE, PRIMARY KEY (character_id, title_id) );


ALTER TABLE chapter_episode ADD CONSTRAINT fk_ce_chapter FOREIGN KEY (chapter_id) REFERENCES chapter(chapter_id);
ALTER TABLE chapter_episode ADD CONSTRAINT fk_ce_episode FOREIGN KEY (episode_id) REFERENCES episode(episode_id);
ALTER TABLE chapter_episode ADD CONSTRAINT fk_ce_saga FOREIGN KEY (saga_id) REFERENCES saga(saga_id);
ALTER TABLE fruit ADD CONSTRAINT fk_fruit_fruit_type FOREIGN KEY (type_id) REFERENCES fruit_type(id);
ALTER TABLE character ADD CONSTRAINT fk_character_status FOREIGN KEY (status_id) REFERENCES character_status(id);
ALTER TABLE character ADD CONSTRAINT fk_character_fruit FOREIGN KEY (fruit_id) REFERENCES fruit(fruit_id);
ALTER TABLE character ADD CONSTRAINT fk_character_first_appearance FOREIGN KEY (first_appearance_id) REFERENCES chapter_episode(chapter_episode_id);
ALTER TABLE affiliation ADD CONSTRAINT fk_affiliation_leader FOREIGN KEY (leader_id) REFERENCES character(character_id);
ALTER TABLE boat ADD CONSTRAINT fk_boat_boat_type FOREIGN KEY (type_id) REFERENCES boat_type(id);
ALTER TABLE boat ADD CONSTRAINT fk_boat_first_appearance FOREIGN KEY (first_appearance_id) REFERENCES chapter_episode(chapter_episode_id);
ALTER TABLE boat ADD CONSTRAINT fk_boat_affiliation FOREIGN KEY (affiliation_id) REFERENCES affiliation(affiliation_id);
ALTER TABLE sword ADD CONSTRAINT fk_sword_status FOREIGN KEY (status_id) REFERENCES sword_status(id);
ALTER TABLE sword ADD CONSTRAINT fk_sword_category FOREIGN KEY (category_id) REFERENCES sword_category(id);
ALTER TABLE sword ADD CONSTRAINT fk_sword_first_appearance FOREIGN KEY (first_appearance_id) REFERENCES chapter_episode(chapter_episode_id);
ALTER TABLE transformation ADD CONSTRAINT fk_transformation_character FOREIGN KEY (character_id) REFERENCES character(character_id);
ALTER TABLE transformation ADD CONSTRAINT fk_transformation_first_appearance FOREIGN KEY (first_appearance_id) REFERENCES chapter_episode(chapter_episode_id);
ALTER TABLE attack ADD CONSTRAINT fk_attack_first_appearance FOREIGN KEY (first_appearance_id) REFERENCES chapter_episode(chapter_episode_id);
ALTER TABLE attack ADD CONSTRAINT fk_attack_character FOREIGN KEY (character_id) REFERENCES character(character_id);
ALTER TABLE attack ADD CONSTRAINT fk_attack_transformation FOREIGN KEY (transformation_id) REFERENCES transformation(transformation_id);
ALTER TABLE character_affiliation ADD CONSTRAINT fk_ca_character FOREIGN KEY (character_id) REFERENCES character(character_id);
ALTER TABLE character_affiliation ADD CONSTRAINT fk_ca_affiliation FOREIGN KEY (affiliation_id) REFERENCES affiliation(affiliation_id);
ALTER TABLE character_affiliation ADD CONSTRAINT fk_ca_status FOREIGN KEY (status_id) REFERENCES character_affiliation_status(id);
ALTER TABLE character_affiliation ADD CONSTRAINT fk_ca_role FOREIGN KEY (role_id) REFERENCES role(id); -- NUEVA FK
ALTER TABLE character_job ADD CONSTRAINT fk_cj_character FOREIGN KEY (character_id) REFERENCES character(character_id);
ALTER TABLE character_job ADD CONSTRAINT fk_cj_job FOREIGN KEY (job_id) REFERENCES job(job_id);
ALTER TABLE character_haki ADD CONSTRAINT fk_ch_character FOREIGN KEY (character_id) REFERENCES character(character_id);
ALTER TABLE character_haki ADD CONSTRAINT fk_ch_haki FOREIGN KEY (haki_id) REFERENCES haki(id);
ALTER TABLE character_sword ADD CONSTRAINT fk_cs_character FOREIGN KEY (character_id) REFERENCES character(character_id);
ALTER TABLE character_sword ADD CONSTRAINT fk_cs_sword FOREIGN KEY (sword_id) REFERENCES sword(sword_id);
ALTER TABLE character_title ADD CONSTRAINT fk_ct_character FOREIGN KEY (character_id) REFERENCES character(character_id);
ALTER TABLE character_title ADD CONSTRAINT fk_ct_title FOREIGN KEY (title_id) REFERENCES title(title_id);