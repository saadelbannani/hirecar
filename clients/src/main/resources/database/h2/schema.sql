-- SEQUENCES
CREATE SEQUENCE PHONE_SEQ INCREMENT BY 1;
CREATE SEQUENCE ADDRESS_SEQ INCREMENT BY 1;
CREATE SEQUENCE CLIENT_SEQ INCREMENT BY 1;

-- TABLES
CREATE TABLE PHONE (
    PHONE_ID             INTEGER     NOT NULL,
    PHONE_UUID           VARCHAR(36)  NOT NULL,
    PHONE_PREFIX         VARCHAR(4),
    PHONE_NUMBER         VARCHAR(20),
    CONSTRAINT PHONE_ID_PK PRIMARY KEY (PHONE_ID)
);


CREATE TABLE ADDRESS (
    ADDRESS_ID          INTEGER      NOT NULL,
    ADDRESS_UUID        VARCHAR(36)  NOT NULL,
    ADDRESS_NUMBER      VARCHAR(5),
    ADDRESS_LINE        VARCHAR(40),
    ADDRESS_ZIP_CODE    VARCHAR(5),
    ADDRESS_CITY        VARCHAR(40),
    ADDRESS_COUNTRY     VARCHAR(40),
    CONSTRAINT ADDRESS_ID_PK PRIMARY KEY (ADDRESS_ID),
);


CREATE TABLE CLIENT (
    CLIENT_ID               INTEGER      NOT NULL AUTO_INCREMENT,
    CLIENT_UUID             VARCHAR(36)  NOT NULL,
    CLIENT_FNAME            VARCHAR(40),
    CLIENT_LNAME            VARCHAR(40),
    CLIENT_DATE_BIRTH       TIMESTAMP,
    CLIENT_ADDRESS_ID       INTEGER,
    CLIENT_PHONE_ID         INTEGER,
    CONSTRAINT CLIENT_ID_PK PRIMARY KEY (CLIENT_ID),
    CONSTRAINT CLIENT_ADDRESS_ID_FK FOREIGN KEY (CLIENT_ADDRESS_ID) REFERENCES ADDRESS(ADDRESS_ID),
    CONSTRAINT CLIENT_PHONE_ID_FK FOREIGN KEY (CLIENT_PHONE_ID) REFERENCES PHONE(PHONE_ID)
);

