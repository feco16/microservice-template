-- Drop table

-- DROP TABLE public.application_user;

CREATE TABLE IF NOT EXISTS public.application_user (
	id int8 NOT NULL,
	"password" varchar(255) NULL,
	username varchar(255) NULL,
	CONSTRAINT application_user_pkey PRIMARY KEY (id)
);

-- Bcrypt-ed password for password1
INSERT INTO APPLICATION_USER VALUES (1, 'user1', '$2a$10$ZDSiYI3YKPsqXAsF3PA5zu.2hdr3e5umjBzK2JAkyb2XelKH4Hgpq');

