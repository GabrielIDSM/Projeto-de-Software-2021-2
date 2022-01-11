BEGIN;

DROP SEQUENCE IF EXISTS "user_conf_id_seq" CASCADE;

CREATE SEQUENCE "user_conf_id_seq";

DROP TABLE IF EXISTS "user_conf" CASCADE;

CREATE TABLE "user_conf" (
    "id" INTEGER NOT NULL DEFAULT nextval('"user_conf_id_seq"'),
	"name" VARCHAR(255) NOT NULL,
	"last_name" VARCHAR(255) NOT NULL DEFAULT '',
    "email" VARCHAR(255) DEFAULT NULL,
    "password" VARCHAR(255) DEFAULT NULL,
    "is_adm" SMALLINT NOT NULL DEFAULT 0,
    PRIMARY KEY ("id")
);

INSERT INTO user_conf (name, email, password, is_adm)
VALUES ('isdown_adm', 'isdown@mail.com', 'sysoper', 1);

DROP SEQUENCE IF EXISTS "service_conf_id_seq" CASCADE;

CREATE SEQUENCE "service_conf_id_seq";

DROP TABLE IF EXISTS "service_conf" CASCADE;

CREATE TABLE "service_conf" (
    "id" INTEGER NOT NULL DEFAULT nextval('"service_conf_id_seq"'),
    "id_image" INTEGER NOT NULL,
	"name" VARCHAR(255) NOT NULL,
	"query" VARCHAR(255) NOT NULL,
    "is_active" SMALLINT NOT NULL DEFAULT 1,
    PRIMARY KEY ("id"),
	UNIQUE("id_image")
);

COMMIT;