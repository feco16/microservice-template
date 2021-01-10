CREATE TABLE IF NOT EXISTS public.application_user (
	application_user_id int8 NOT NULL,
	birth_date varchar(255) NULL,
	cound_down_sec int4 NULL,
	display_name varchar(255) NULL,
	gender varchar(255) NULL,
	height int4 NULL,
	"password" varchar(255) NULL,
	photo_url varchar(255) NULL,
	user_id varchar(255) NULL,
	username varchar(255) NULL,
	weight int4 NULL,
	CONSTRAINT application_user_pkey PRIMARY KEY (application_user_id)
);

CREATE TABLE IF NOT EXISTS public.workout_type (
	type_id int8 NOT NULL,
	type_code int4 NULL,
	type_name varchar(255) NULL,
	CONSTRAINT workout_type_pkey PRIMARY KEY (type_id)
);

CREATE TABLE IF NOT EXISTS public.workout (
	workout_id int8 NOT NULL,
	cal float8 NULL,
	duration int4 NULL,
	time_stamp int8 NULL,
	uuid varchar(255) NULL,
	application_user_application_user_id int8 NULL,
	workout_type_type_id int8 NULL,
	CONSTRAINT workout_pkey PRIMARY KEY (workout_id),
	CONSTRAINT fkl8o8dfoqeaem4q8biukppjy23 FOREIGN KEY (workout_type_type_id) REFERENCES workout_type(type_id),
	CONSTRAINT fko5k2s1k37ouuaig84chymrkq6 FOREIGN KEY (application_user_application_user_id) REFERENCES application_user(application_user_id)
);

CREATE TABLE IF NOT EXISTS public.workout_data (
	workout_data_id int8 NOT NULL,
	is_direct bool NULL,
	"name" varchar(255) NULL,
	workout_type_type_id int8 NULL,
	CONSTRAINT workout_data_pkey PRIMARY KEY (workout_data_id),
	CONSTRAINT fke35myixowdsw3y2w70h8eh80n FOREIGN KEY (workout_type_type_id) REFERENCES workout_type(type_id)
);

CREATE TABLE IF NOT EXISTS public.data_instance (
	data_instance_id int8 NOT NULL,
	list_index int4 NULL,
	value varchar(255) NULL,
	workout_workout_id int8 NULL,
	workout_data_workout_data_id int8 NULL,
	CONSTRAINT data_instance_pkey PRIMARY KEY (data_instance_id),
	CONSTRAINT fk878gk3jd3osy74l1dd3k0e6rp FOREIGN KEY (workout_workout_id) REFERENCES workout(workout_id),
	CONSTRAINT fkabg2kpqhp2me2b71wrgyyt3dv FOREIGN KEY (workout_data_workout_data_id) REFERENCES workout_data(workout_data_id)
);


CREATE SEQUENCE seq_application_user
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    START WITH 1
    OWNED BY application_user.application_user_id;

CREATE SEQUENCE seq_workout_type
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    START WITH 1
    OWNED BY workout_type.type_id;

CREATE SEQUENCE seq_workout
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    START WITH 1
    OWNED BY workout.workout_id;

CREATE SEQUENCE seq_workout_data
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    START WITH 1
    OWNED BY workout_data.workout_data_id;

CREATE SEQUENCE seq_data_instance
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    START WITH 1
    OWNED BY data_instance.data_instance_id;


CREATE INDEX index_application_user_user_id ON public.application_user (user_id);
CREATE INDEX index_workout_type_type_code ON public.workout_type (type_code);
CREATE INDEX index_workout_workout_type_type_id ON public.workout (workout_type_type_id);
CREATE INDEX index_workout_application_user_application_user_id ON public.workout (application_user_application_user_id);
CREATE INDEX index_workout_uuid ON public.workout (uuid);
CREATE INDEX index_workout_data_workout_type_type_id ON public.workout_data (workout_type_type_id);
CREATE INDEX index_data_instance_list_index ON public.data_instance (list_index);
CREATE INDEX index_data_instance_workout_workout_id ON public.data_instance (workout_workout_id);
CREATE INDEX index_data_instance_workout_data_workout_data_id ON public.data_instance (workout_data_workout_data_id);


INSERT INTO WORKOUT_TYPE (TYPE_ID, TYPE_CODE, TYPE_NAME) VALUES
(1, 0, 'Stairing'),
(2, 1, 'Biking'),
(3, 2, 'RollerSkating'),
(4, 3, 'Running');

INSERT INTO WORKOUT_DATA  (WORKOUT_DATA_ID, NAME, IS_DIRECT, WORKOUT_TYPE_TYPE_ID) VALUES

-- STAIRING
(100, 'stairsCount', 'true', 1),
(101, 'count', 'false', 1),
(102, 'whenSec', 'false', 1),

-- BIKING
(200, 'distance', 'true', 2),
(201, 'altitude', 'false', 2),
(202, 'latitude', 'false', 2),
(203, 'longitude', 'false', 2),
(204, 'speed', 'false', 2),
(205, 'whenSec', 'false', 2),

-- RollerSkating
(300, 'latitude', 'false', 3),
(301, 'longitude', 'false', 3),
(302, 'speed', 'false', 3),
(303, 'whenSec', 'false', 3),

-- RUNNING
(400, 'distance', 'true', 4),
(401, 'altitude', 'false', 4),
(402, 'latitude', 'false', 4),
(403, 'longitude', 'false', 4),
(404, 'speed', 'false', 4),
(405, 'whenSec', 'false', 4);
