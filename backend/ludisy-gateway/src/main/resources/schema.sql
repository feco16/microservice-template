-- Drop table

-- DROP TABLE public.application_user;

CREATE TABLE IF NOT EXISTS public.application_user (
    userId varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    pictureUrl varchar(255) NOT NULL,
    locale varchar(255) NOT NULL,
    familyName varchar(255) NOT NULL,
    givenName varchar(255) NOT NULL,
	CONSTRAINT application_user_pkey PRIMARY KEY (userId)
);

-- Bcrypt-ed password for password1
-- INSERT INTO APPLICATION_USER VALUES (1, 'user1', '$2a$10$ZDSiYI3YKPsqXAsF3PA5zu.2hdr3e5umjBzK2JAkyb2XelKH4Hgpq');

