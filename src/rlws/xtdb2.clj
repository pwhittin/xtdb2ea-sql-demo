(ns rlws.xtdb2
  (:require [xtdb.client :as xt.client]
            [xtdb.api :as xt]))

(comment

  ;; start an HTTP client talking to the Docker XTDB server
  (def xtdb-node (xt.client/start-client "http://localhost:3000"))

  ;; check to see if the server is running
  (xt/status xtdb-node)

  ;; define some person data
  (def persons
    [{:name "James Cameron",
      :born #inst "1954-08-16T00:00:00.000-00:00",
      :id -100}
     {:name "Arnold Schwarzenegger",
      :born #inst "1947-07-30T00:00:00.000-00:00",
      :id -101}
     {:name "Linda Hamilton",
      :born #inst "1956-09-26T00:00:00.000-00:00",
      :id -102}
     {:name "Michael Biehn",
      :born #inst "1956-07-31T00:00:00.000-00:00",
      :id -103}
     {:name "Ted Kotcheff",
      :born #inst "1931-04-07T00:00:00.000-00:00",
      :id -104}
     {:name "Sylvester Stallone",
      :born #inst "1946-07-06T00:00:00.000-00:00",
      :id -105}
     {:name "Richard Crenna",
      :born #inst "1926-11-30T00:00:00.000-00:00",
      :death #inst "2003-01-17T00:00:00.000-00:00",
      :id -106}
     {:name "Brian Dennehy",
      :born #inst "1938-07-09T00:00:00.000-00:00",
      :id -107}
     {:name "John McTiernan",
      :born #inst "1951-01-08T00:00:00.000-00:00",
      :id -108}
     {:name "Elpidia Carrillo",
      :born #inst "1961-08-16T00:00:00.000-00:00",
      :id -109}
     {:name "Carl Weathers",
      :born #inst "1948-01-14T00:00:00.000-00:00",
      :id -110}
     {:name "Richard Donner",
      :born #inst "1930-04-24T00:00:00.000-00:00",
      :id -111}
     {:name "Mel Gibson",
      :born #inst "1956-01-03T00:00:00.000-00:00",
      :id -112}
     {:name "Danny Glover",
      :born #inst "1946-07-22T00:00:00.000-00:00",
      :id -113}
     {:name "Gary Busey",
      :born #inst "1944-07-29T00:00:00.000-00:00",
      :id -114}
     {:name "Paul Verhoeven",
      :born #inst "1938-07-18T00:00:00.000-00:00",
      :id -115}
     {:name "Peter Weller",
      :born #inst "1947-06-24T00:00:00.000-00:00",
      :id -116}
     {:name "Nancy Allen",
      :born #inst "1950-06-24T00:00:00.000-00:00",
      :id -117}
     {:name "Ronny Cox",
      :born #inst "1938-07-23T00:00:00.000-00:00",
      :id -118}
     {:name "Mark L. Lester",
      :born #inst "1946-11-26T00:00:00.000-00:00",
      :id -119}
     {:name "Rae Dawn Chong",
      :born #inst "1961-02-28T00:00:00.000-00:00",
      :id -120}
     {:name "Alyssa Milano",
      :born #inst "1972-12-19T00:00:00.000-00:00",
      :id -121}
     {:name "Bruce Willis",
      :born #inst "1955-03-19T00:00:00.000-00:00",
      :id -122}
     {:name "Alan Rickman",
      :born #inst "1946-02-21T00:00:00.000-00:00",
      :id -123}
     {:name "Alexander Godunov",
      :born #inst "1949-11-28T00:00:00.000-00:00",
      :death #inst "1995-05-18T00:00:00.000-00:00",
      :id -124}
     {:name "Robert Patrick",
      :born #inst "1958-11-05T00:00:00.000-00:00",
      :id -125}
     {:name "Edward Furlong",
      :born #inst "1977-08-02T00:00:00.000-00:00",
      :id -126}
     {:name "Jonathan Mostow",
      :born #inst "1961-11-28T00:00:00.000-00:00",
      :id -127}
     {:name "Nick Stahl",
      :born #inst "1979-12-05T00:00:00.000-00:00",
      :id -128}
     {:name "Claire Danes",
      :born #inst "1979-04-12T00:00:00.000-00:00",
      :id -129}
     {:name "George P. Cosmatos",
      :born #inst "1941-01-04T00:00:00.000-00:00",
      :death #inst "2005-04-19T00:00:00.000-00:00",
      :id -130}
     {:name "Charles Napier",
      :born #inst "1936-04-12T00:00:00.000-00:00",
      :death #inst "2011-10-05T00:00:00.000-00:00",
      :id -131}
     {:name "Peter MacDonald", :id -132}
     {:name "Marc de Jonge",
      :born #inst "1949-02-16T00:00:00.000-00:00",
      :death #inst "1996-06-06T00:00:00.000-00:00",
      :id -133}
     {:name "Stephen Hopkins", :id -134}
     {:name "Ruben Blades",
      :born #inst "1948-07-16T00:00:00.000-00:00",
      :id -135}
     {:name "Joe Pesci",
      :born #inst "1943-02-09T00:00:00.000-00:00",
      :id -136}
     {:name "Ridley Scott",
      :born #inst "1937-11-30T00:00:00.000-00:00",
      :id -137}
     {:name "Tom Skerritt",
      :born #inst "1933-08-25T00:00:00.000-00:00",
      :id -138}
     {:name "Sigourney Weaver",
      :born #inst "1949-10-08T00:00:00.000-00:00",
      :id -139}
     {:name "Veronica Cartwright",
      :born #inst "1949-04-20T00:00:00.000-00:00",
      :id -140}
     {:name "Carrie Henn", :id -141}
     {:name "George Miller",
      :born #inst "1945-03-03T00:00:00.000-00:00",
      :id -142}
     {:name "Steve Bisley",
      :born #inst "1951-12-26T00:00:00.000-00:00",
      :id -143}
     {:name "Joanne Samuel", :id -144}
     {:name "Michael Preston",
      :born #inst "1938-05-14T00:00:00.000-00:00",
      :id -145}
     {:name "Bruce Spence",
      :born #inst "1945-09-17T00:00:00.000-00:00",
      :id -146}
     {:name "George Ogilvie",
      :born #inst "1931-03-05T00:00:00.000-00:00",
      :id -147}
     {:name "Tina Turner",
      :born #inst "1939-11-26T00:00:00.000-00:00",
      :id -148}
     {:name "Sophie Marceau",
      :born #inst "1966-11-17T00:00:00.000-00:00",
      :id -149}])

  ;; insert each person into the database using a SQL prepared statement
  ;;
  ;; (xt/submit-tx xtdb-node (for [person persons]
  ;;                           [:xtdb.api/put person])) 
  ;;
  (xt/submit-tx xtdb-node (apply vector (for [{:keys [id name born death]} persons]
                                          [:sql ["INSERT INTO person (xt$id, name, born, death) 
                                                  VALUES (?, ?, ?, ?)"
                                                 id name born death]])))

  ;; query all of the person names
  ;;
  ;; (q '{:find [person-name]
  ;;      :where [[_ :person/name person-name]]})
  ;;
  (xt/q xtdb-node ["SELECT person.name 
                    FROM person"])

  ;; define some movie data
  (def movies
    [{:title "The Terminator",
      :year 1984,
      :directors [-100],
      :cast-members [-101 -102 -103],
      :sequel -207,
      :id -200}
     {:title "First Blood",
      :year 1982,
      :directors [-104],
      :cast-members [-105 -106 -107],
      :sequel -209,
      :id -201}
     {:title "Predator",
      :year 1987,
      :directors [-108],
      :cast-members [-101 -109 -110],
      :sequel -211,
      :id -202}
     {:title "Lethal Weapon",
      :year 1987,
      :directors [-111],
      :cast-members [-112 -113 -114],
      :sequel -212,
      :id -203}
     {:title "RoboCop",
      :year 1987,
      :directors [-115],
      :cast-members [-116 -117 -118],
      :id -204}
     {:title "Commando",
      :year 1985,
      :directors [-119],
      :cast-members [-101 -120 -121],
      :trivia "In 1986, a sequel was written with an eye to having\n  John McTiernan direct. Schwarzenegger wasn't interested in reprising\n  the role. The script was then reworked with a new central character,\n  eventually played by Bruce Willis, and became Die Hard",
      :id -205}
     {:title "Die Hard",
      :year 1988,
      :directors [-108],
      :cast-members [-122 -123 -124],
      :id -206}
     {:title "Terminator 2: Judgment Day",
      :year 1991,
      :directors [-100],
      :cast-members [-101 -102 -125 -126],
      :sequel -208,
      :id -207}
     {:title "Terminator 3: Rise of the Machines",
      :year 2003,
      :directors [-127],
      :cast-members [-101 -128 -129],
      :id -208}
     {:title "Rambo: First Blood Part II",
      :year 1985,
      :directors [-130],
      :cast-members [-105 -106 -131],
      :sequel -210,
      :id -209}
     {:title "Rambo III",
      :year 1988,
      :directors [-132],
      :cast-members [-105 -106 -133],
      :id -210}
     {:title "Predator 2",
      :year 1990,
      :directors [-134],
      :cast-members [-113 -114 -135],
      :id -211}
     {:title "Lethal Weapon 2",
      :year 1989,
      :directors [-111],
      :cast-members [-112 -113 -136],
      :sequel -213,
      :id -212}
     {:title "Lethal Weapon 3",
      :year 1992,
      :directors [-111],
      :cast-members [-112 -113 -136],
      :id -213}
     {:title "Alien",
      :year 1979,
      :directors [-137],
      :cast-members [-138 -139 -140],
      :sequel -215,
      :id -214}
     {:title "Aliens",
      :year 1986,
      :directors [-100],
      :cast-members [-139 -141 -103],
      :id -215}
     {:title "Mad Max",
      :year 1979,
      :directors [-142],
      :cast-members [-112 -143 -144],
      :sequel -217,
      :id -216}
     {:title "Mad Max 2",
      :year 1981,
      :directors [-142],
      :cast-members [-112 -145 -146],
      :sequel -218,
      :id -217}
     {:title "Mad Max Beyond Thunderdome",
      :year 1985,
      :directors [-142 -147],
      :cast-members [-112 -148],
      :id -218}
     {:title "Braveheart",
      :year 1995,
      :directors [-112],
      :cast-members [-112 -149],
      :id -219}])

  ;; insert each movie into the database using a SQL prepared statement
  ;;
  ;; (xt/submit-tx xtdb-node (for [movie movies]
  ;;                           [:xtdb.api/put movie])) 
  ;;
  (xt/submit-tx
   xtdb-node
   (apply vector (for [{:keys [id title year directors cast-members sequel trivia]} movies]
                   [:sql ["INSERT INTO movie (xt$id, title, year, directors, cast_members, sequel, trivia) 
                           VALUES (?, ?, ?, ?, ?, ?, ?)"
                          id title year directors cast-members sequel trivia]])))

  ;; query all of the movie titles
  ;;
  ;; (q '{:find [movie-title]
  ;;      :where [[_ :movie/title movie-title]]})
  ;;
  (xt/q xtdb-node ["SELECT movie.title
                    FROM movie"])

  ;; query all movie entity ids
  ;;
  ;; (q '{:find [movie-eid]
  ;;      :where [[movie-eid :movie/title _]]})
  ;;
  (xt/q xtdb-node ["SELECT movie.xt$id 
                    FROM movie"])

  ;; query all distinct movie years 
  ;;
  ;; (q '{:find [movie-year]
  ;;      :where [[_ :movie/year movie-year]]})
  ;;
  (xt/q xtdb-node ["SELECT DISTINCT movie.year 
                    FROM movie"])

  ;; query the entity ids of movies made in 1987
  ;;
  ;; (q '{:find [movie-eid]
  ;;      :where [[movie-eid :movie/year 1987]]})
  ;;
  (xt/q xtdb-node ["SELECT movie.xt$id 
                    FROM movie 
                    WHERE movie.year = 1987"])

  ;; query the entity-id and title of all movies in the database
  ;;
  ;; (q '{:find [movie-eid movie-title]
  ;;      :where [[movie-eid :movie/title movie-title]]})
  ;;
  (xt/q xtdb-node ["SELECT movie.xt$id, movie.title 
                    FROM movie"])

  ;; query the name of all people in the database
  ;;
  ;; (q '{:find [person-name]
  ;;      :where [[_ :person/name person-name]]})
  ;;
  (xt/q xtdb-node ["SELECT person.name 
                    FROM person"])

  ;; query movie titles made in 1985
  ;; (q '{:find [movie-title-made-in-1985]
  ;;      :where [[movie-eid :movie/title movie-title-made-in-1985]
  ;;              [movie-eid :movie/year 1985]]})
  ;;
  (xt/q xtdb-node ["SELECT movie.title 
                    FROM movie 
                    WHERE movie.year = 1985"])

  ;; what year was "Alien" released?
  ;;
  ;; (q '{:find [alien-release-year]
  ;;      :where [[movie-eid :movie/year alien-release-year]
  ;;              [movie-eid :movie/title "Alien"]]})
  ;;
  (xt/q xtdb-node ["SELECT movie.year 
                    FROM movie 
                    WHERE movie.title = 'Alien'"])

  ;; who directed RoboCop?
  ;;
  ;; (q '{:find [robocop-director-name]
  ;;      :where [[movie-eid :movie/title "RoboCop"]
  ;;              [movie-eid :movie/director robocop-director-eid]
  ;;              [robocop-director-eid :person/name robocop-director-name]]})
  ;;
  (xt/q xtdb-node ["SELECT person.name AS director_name
                    FROM movie
                    JOIN UNNEST (movie.directors) AS directors(id) ON true
                    JOIN person ON person.id = directors.id
                    WHERE movie.title = 'RoboCop'"])

  ;; query directors who have directed Arnold Schwarzenegger in a movie
  ;;
  ;; (q '{:find [director-name]
  ;;      :where [[cast-member-eid :person/name "Arnold Schwarzenegger"]
  ;;              [movie-eid :movie/cast-members cast-member-eid]
  ;;              [movie-eid :movie/director director-eid]
  ;;              [director-eid :person/name director-name]]})
  ;;
  ;; The following query works with PostgreSQL, but fails with XTDB 2.x (pre-alpha) @ dev-SNAPSHOT @ 4c72485
  ;;
  (xt/q xtdb-node ["SELECT DISTINCT director.name AS director_name
                    FROM person, movie
                    JOIN UNNEST (movie.cast_members) AS cast_members(id) ON TRUE
                    JOIN UNNEST (movie.directors) AS directors(id) ON TRUE
                    JOIN person AS director ON director.id = directors.id
                    WHERE (person.id = cast_members.id) AND (person.name = 'Arnold Schwarzenegger')"])

  ;; query all movies released before 1984
  ;;
  ;; (q '{:find [title]
  ;;      :where [[m :movie/title title]
  ;;              [m :movie/year year]
  ;;              [(< year 1984)]]})
  ;;
  (xt/q xtdb-node ["SELECT movie.title 
                    FROM movie 
                    WHERE movie.year < 1984"])

  ;; find all people whose names start with "M"
  ;;
  ;; (q '{:find [name]
  ;;      :where [[p :person/name name]
  ;;              [(clojure.string/starts-with? name "M")]]})
  ;;
  (xt/q xtdb-node ["SELECT person.name 
                    FROM person 
                    WHERE person.name LIKE 'M%'"])

  ;; count the number of movies in the database
  ;;
  ;; (q '{:find [(count m)]
  ;;      :where [[m :movie/title _]]})
  ;;
  (xt/q xtdb-node ["SELECT COUNT(movie.title) AS movie_count 
                    FROM movie"])

  ;; query the birth date of the oldest person in the database
  ;;
  ;; (q '{:find [(min birth-date)]
  ;;      :where [[_ :person/born birth-date]]})
  ;;
  (xt/q xtdb-node ["SELECT MIN(person.born) AS oldest_birth_date 
                    FROM person"])

  ;
  )
