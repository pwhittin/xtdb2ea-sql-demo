DROP TABLE IF EXISTS person;

CREATE TABLE person (
  name varchar(50),
  id integer
);

INSERT INTO person (name, id) VALUES
  ('James Cameron', -100),
  ('Arnold Schwarzenegger', -101),
  ('Linda Hamilton', -102),
  ('Michael Biehn', -103),
  ('Ted Kotcheff', -104),
  ('Sylvester Stallone', -105),
  ('Richard Crenna', -106),
  ('Brian Dennehy', -107),
  ('John McTiernan', -108),
  ('Elpidia Carrillo', -109),
  ('Carl Weathers', -110),
  ('Richard Donner', -111),
  ('Mel Gibson', -112),
  ('Danny Glover', -113),
  ('Gary Busey', -114),
  ('Paul Verhoeven', -115),
  ('Peter Weller', -116),
  ('Nancy Allen', -117),
  ('Ronny Cox', -118),
  ('Mark L. Lester', -119),
  ('Rae Dawn Chong', -120),
  ('Alyssa Milano', -121),
  ('Bruce Willis', -122),
  ('Alan Rickman', -123),
  ('Alexander Godunov', -124),
  ('Robert Patrick', -125),
  ('Edward Furlong', -126),
  ('Jonathan Mostow', -127),
  ('Nick Stahl', -128),
  ('Claire Danes', -129),
  ('George P. Cosmatos', -130),
  ('Charles Napier', -131),
  ('Peter MacDonald', -132),
  ('Marc de Jonge', -133),
  ('Stephen Hopkins', -134),
  ('Ruben Blades', -135),
  ('Joe Pesci', -136),
  ('Ridley Scott', -137),
  ('Tom Skerritt', -138),
  ('Sigourney Weaver', -139),
  ('Veronica Cartwright', -140),
  ('Carrie Henn', -141),
  ('George Miller', -142),
  ('Steve Bisley', -143),
  ('Joanne Samuel', -144),
  ('Michael Preston', -145),
  ('Bruce Spence', -146),
  ('George Ogilvie', -147),
  ('Tina Turner', -148),
  ('Sophie Marceau', -149);

DROP TABLE IF EXISTS movie;

CREATE TABLE movie (
  id integer,
  title varchar(100),
  directors integer[],
  cast_members integer[]
);

INSERT INTO movie (id, title, directors, cast_members) VALUES
  (-200, 'The Terminator', '{-100}', '{-101, -102, -103}'),
  (-201, 'First Blood', '{-104}', '{-105, -106, -107}'),
  (-202, 'Predator', '{-108}', '{-101, -109, -110}'),
  (-203, 'Lethal Weapon', '{-111}', '{-112, -113, -114}'),
  (-204, 'RoboCop', '{-115}', '{-116, -117, -118}'),
  (-205, 'Commando', '{-119}', '{-101, -120, -121}'),
  (-206, 'Die Hard', '{-108}', '{-122, -123, -124}'),
  (-207, 'Terminator 2: Judgment Day', '{-100}', '{-101, -102, -125, -126}'),
  (-208, 'Terminator 3: Rise of the Machines', '{-127}', '{-101, -128, -129}'),
  (-209, 'Rambo: First Blood Part II', '{-130}', '{-105, -106, -131}'),
  (-210, 'Rambo III', '{-132}', '{-105, -106, -133}'),
  (-211, 'Predator 2', '{-134}', '{-113, -114, -135}'),
  (-212, 'Lethal Weapon 2', '{-111}', '{-112, -113, -136}'),
  (-213, 'Lethal Weapon 3', '{-111}', '{-112, -113, -136}'),
  (-214, 'Alien', '{-137}', '{-138, -139, -140}'),
  (-215, 'Aliens', '{-100}', '{-139, -141, -103}'),
  (-216, 'Mad Max', '{-142}', '{-112, -143, -144}'),
  (-217, 'Mad Max 2', '{-142}', '{-112, -145, -146}'),
  (-218, 'Mad Max Beyond Thunderdome', '{-142, -147}', '{-112, -148}'),
  (-219, 'Braveheart', '{-112}', '{-112, -149}');

SELECT DISTINCT director.name AS director_name
FROM person, movie
JOIN unnest(movie.cast_members) AS cast_members(id) ON true
JOIN unnest(movie.directors) AS directors(id) ON true
JOIN person AS director ON director.id = directors.id
WHERE (person.id = cast_members.id) AND  (person.name = 'Arnold Schwarzenegger');

SELECT DISTINCT director.name AS director_name
FROM person
JOIN movie ON person.id = ANY (movie.cast_members)
JOIN person AS director ON director.id = ANY (movie.directors)
WHERE person.name = 'Arnold Schwarzenegger';
