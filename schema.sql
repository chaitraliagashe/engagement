-- Table: user_engagement.engagement_parameters

-- DROP TABLE IF EXISTS user_engagement.engagement_parameters;

CREATE TABLE IF NOT EXISTS user_engagement.engagement_parameters
(
    post_id character varying COLLATE pg_catalog."default" NOT NULL,
    likes bigint,
    clicks bigint,
    dislikes bigint
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS user_engagement.engagement_parameters
    OWNER to postgres;