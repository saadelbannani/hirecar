-- PHONE
INSERT INTO PHONE (PHONE_ID, PHONE_PREFIX, PHONE_NUMBER) VALUES (1, '+33', '623987384');
INSERT INTO PHONE (PHONE_ID, PHONE_PREFIX, PHONE_NUMBER) VALUES (2, '+33', '623456789');
INSERT INTO PHONE (PHONE_ID, PHONE_PREFIX, PHONE_NUMBER) VALUES (3, '+33', '643989878');


-- ADDRESS
INSERT INTO ADDRESS (ADDRESS_ID, ADDRESS_NUMBER, ADDRESS_LINE, ADDRESS_ZIP_CODE, ADDRESS_CITY, ADDRESS_COUNTRY) VALUES (1, '12A', 'Rue des mauriciens', '45000', 'Troyes', 'France');
INSERT INTO ADDRESS (ADDRESS_ID, ADDRESS_NUMBER, ADDRESS_LINE, ADDRESS_ZIP_CODE, ADDRESS_CITY, ADDRESS_COUNTRY) VALUES (2, '3', 'Rue de venise', '69000', 'Paris', 'France');
INSERT INTO ADDRESS (ADDRESS_ID, ADDRESS_NUMBER, ADDRESS_LINE, ADDRESS_ZIP_CODE, ADDRESS_CITY, ADDRESS_COUNTRY) VALUES (3, '321', 'Rue du grand', '15000', 'Reims', 'France');


-- CLIENTS
INSERT INTO CLIENT (CLIENT_ID, CLIENT_FNAME, CLIENT_LNAME, CLIENT_DATE_BIRTH, CLIENT_ADDRESS_ID, CLIENT_PHONE_ID) VALUES (1, 'JACQUES', 'DURANT', '1990-10-11', 1, 1);
INSERT INTO CLIENT (CLIENT_ID, CLIENT_FNAME, CLIENT_LNAME, CLIENT_DATE_BIRTH, CLIENT_ADDRESS_ID, CLIENT_PHONE_ID) VALUES (2, 'MARK', 'DESCHAMPS', '1983-03-02', 2, 2);
INSERT INTO CLIENT (CLIENT_ID, CLIENT_FNAME, CLIENT_LNAME, CLIENT_DATE_BIRTH, CLIENT_ADDRESS_ID, CLIENT_PHONE_ID) VALUES (3, 'JULIE', 'NADINE', '1980-12-23', 3, 3);
