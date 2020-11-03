INSERT INTO APPLICATION_USER (APPLICATION_USER_ID, USER_ID, USERNAME, PASSWORD) VALUES
(10001, 100, 'F', 'P');

--INSERT INTO WORKOUT (WORKOUT_ID, UUID, DURATION, TIME_STAMP, CAL, APPLICATION_USER_APPLICATION_USER_ID) VALUES
--(1, 1, 1, 1.0, 1, 5);

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

