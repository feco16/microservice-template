INSERT INTO APPLICATION_USER VALUES
(5, 'F', 'P');
--
--INSERT INTO WORKOUT (WORKOUT_ID, UUID, DURATION, TIME_STAMP, CAL, APPLICATION_USER_APPLICATION_USER_ID) VALUES
--(1, 1, 1, 1.0, 1, 5);

INSERT INTO WORKOUT_TYPE (TYPE_ID, UUID, TYPE_CODE) VALUES
(1, '1', 1);

INSERT INTO WORKOUT_DATA  (WORKOUT_DATA_ID, NAME, IS_DIRECT, WORKOUT_TYPE_TYPE_ID) VALUES

-- BIKING
(1, 'distance', 'true', 1),
(2, 'altitude', 'false', 1),
(3, 'latitude', 'false', 1),
(4, 'longitude', 'false', 1),
(5, 'speed', 'false', 1),
(6, 'whenSec', 'false', 1);


