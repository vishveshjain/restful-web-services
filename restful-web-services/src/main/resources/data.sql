CREATE TABLE user (
  id char(36) NOT NULL,
   name VARCHAR(255) NULL,
   birth_date datetime NULL,
   CONSTRAINT pk_user PRIMARY KEY (id)
);

INSERT INTO user VALUES(1, 'Vishvesh', sysdate());
INSERT INTO user VALUES(2, 'Vishal', sysdate());
INSERT INTO user VALUES(3, 'Manish', sysdate());
