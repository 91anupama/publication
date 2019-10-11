create database authordata;

create table authordata.author (
   aid BIGINT NOT NULL AUTO_INCREMENT,
   author_name VARCHAR(30) NOT NULL,
   PRIMARY KEY (aid)
);
 
 
create table authordata.publication (
   pid BIGINT NOT NULL AUTO_INCREMENT,
   genre VARCHAR(30) NOT NULL,
   hero VARCHAR(30) NOT NULL,
   pyear VARCHAR(30) NOT NULL,
   title VARCHAR(30) NOT NULL,
   type_maz VARCHAR(30) NOT NULL,
   type_pub VARCHAR(30) NOT NULL,
   PRIMARY KEY (pid)
);
 
 
CREATE TABLE authordata.author_publication (
    aid BIGINT NOT NULL,
    pid BIGINT NOT NULL,
    PRIMARY KEY (aid, pid),
    CONSTRAINT FK_author FOREIGN KEY (aid) REFERENCES author (aid),
    CONSTRAINT FK_publication FOREIGN KEY (pid) REFERENCES publication (pid)
);


