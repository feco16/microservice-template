INSERT INTO APPLICATION_USER VALUES
(5, 'F', 'P');

--INSERT INTO WORKOUT (WORKOUT_ID, UUID, DURATION, TIME_STAMP, CAL, APPLICATION_USER_APPLICATION_USER_ID) VALUES
--(1, 1, 1, 1.0, 1, 5);

INSERT INTO WORKOUT_TYPE (TYPE_ID, TYPE_CODE, TYPE_NAME) VALUES
(1, 0, 'Stairing'),
(2, 1, 'Biking'),
(3, 2, 'RollerSkating'),
(4, 3, 'Running');

INSERT INTO WORKOUT_DATA  (WORKOUT_DATA_ID, NAME, IS_DIRECT, WORKOUT_TYPE_TYPE_ID) VALUES

-- STAIRING
(1, 'count', 'false', 1),
(2, 'whenSec', 'false', 1),

-- BIKING
(3, 'distance', 'true', 2),
(4, 'altitude', 'false', 2),
(5, 'latitude', 'false', 2),
(6, 'longitude', 'false', 2),
(7, 'speed', 'false', 2),
(8, 'whenSec', 'false', 2),

-- RollerSkating
(9, 'latitude', 'false', 3),
(10, 'longitude', 'false', 3),
(11, 'speed', 'false', 3),
(12, 'whenSec', 'false', 3),

-- RUNNING
(13, 'distance', 'true', 4),
(14, 'altitude', 'false', 4),
(15, 'latitude', 'false', 4),
(16, 'longitude', 'false', 4),
(17, 'speed', 'false', 4),
(18, 'whenSec', 'false', 4);

