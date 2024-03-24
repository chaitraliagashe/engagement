-- Database: user_engagement

-- DROP DATABASE IF EXISTS user_engagement;

CREATE DATABASE user_engagement
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'German_Germany.1252'
    LC_CTYPE = 'German_Germany.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
    
-- SCHEMA: user_engagement

-- DROP SCHEMA IF EXISTS user_engagement ;

CREATE SCHEMA IF NOT EXISTS user_engagement
    AUTHORIZATION postgres;

-- Table: user_engagement.engagement_parameters

-- DROP TABLE IF EXISTS user_engagement.engagement_parameters;

CREATE TABLE IF NOT EXISTS user_engagement.engagement_parameters
(
    post_id character varying COLLATE pg_catalog."default" NOT NULL,
    likes bigint,
    clicks bigint,
    dislikes bigint,
    CONSTRAINT engagement_parameters_pkey PRIMARY KEY (post_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS user_engagement.engagement_parameters
    OWNER to postgres;
-- Index: post_id

-- DROP INDEX IF EXISTS user_engagement.post_id;

CREATE INDEX IF NOT EXISTS post_id
    ON user_engagement.engagement_parameters USING btree
    (post_id COLLATE pg_catalog."default" ASC NULLS LAST)
    WITH (deduplicate_items=True)
    TABLESPACE pg_default;
    
-- Index: post_id

-- DROP INDEX IF EXISTS user_engagement.post_id;

CREATE INDEX IF NOT EXISTS post_id
    ON user_engagement.engagement_parameters USING btree
    (post_id COLLATE pg_catalog."default" ASC NULLS LAST)
    WITH (deduplicate_items=True)
    TABLESPACE pg_default;
    