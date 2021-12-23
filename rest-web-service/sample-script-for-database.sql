-- SAMPLE SCRIPT FOR AUTONOMOUS DATABASE OR ORACLE DATABASE XE
DROP TABLE ORDERR_DETAIL;
DROP TABLE ORDERR;
DROP TABLE CUSTOMER;
DROP TABLE PRODUCT;
DROP SEQUENCE CUSTOMER_ID_SEQ_GEN;
DROP SEQUENCE PRODUCT_ID_SEQ_GEN;
DROP SEQUENCE ORDERR_ID_SEQ_GEN;
DROP SEQUENCE ORDERR_DETAIL_ID_SEQ_GEN;

CREATE TABLE CUSTOMER(
  ID NUMBER NOT NULL,
  FIRST_NAME VARCHAR2(50) NOT NULL,
  LAST_NAME VARCHAR2(50) NOT NULL,
  TAX_IDENTIFICATION_NUMBER VARCHAR2(50),
  CUSTOMER_CODE VARCHAR2(50),
  BIRTH_DATE DATE,
  PRIMARY KEY(ID),
  CONSTRAINT UQ_CUSTOMER_TAX_IDENTIFICATION_NUMBER UNIQUE(TAX_IDENTIFICATION_NUMBER),
  CONSTRAINT UQ_CUSTOMER_CUSTOMER_CODE UNIQUE(CUSTOMER_CODE)
);

CREATE SEQUENCE CUSTOMER_ID_SEQ_GEN
  MINVALUE 1 MAXVALUE 9999
  START WITH 1 INCREMENT BY 1;

-----------------------------------------------
CREATE TABLE PRODUCT(
  ID NUMBER NOT NULL,
  DESCRIPTION VARCHAR2(100) NOT NULL,
  PRODUCT_CODE VARCHAR2(50) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE SEQUENCE PRODUCT_ID_SEQ_GEN
  MINVALUE 1 MAXVALUE 9999
  START WITH 1 INCREMENT BY 1;

------------------------------------------------
CREATE TABLE ORDERR(
  ID NUMBER NOT NULL,
  DOCUMENT_NUMBER NUMBER,
  ORDERR_DATE DATE NOT NULL,
  CUSTOMER_ID NUMBER NOT NULL,
  PRIMARY KEY(ID),
  CONSTRAINT UQ_ORDERR_DOCUMENT_NUMBER UNIQUE(DOCUMENT_NUMBER),
  CONSTRAINT FK_ORDERR_CUSTOMER_ID FOREIGN KEY(CUSTOMER_ID) REFERENCES CUSTOMER(ID)
);

CREATE SEQUENCE ORDERR_ID_SEQ_GEN
  MINVALUE 1 MAXVALUE 9999
  START WITH 1 INCREMENT BY 1;

-------------------------------------------------
CREATE TABLE ORDERR_DETAIL(
  ID NUMBER NOT NULL,
  ORDERR_ID NUMBER NOT NULL,
  PRODUCT_ID NUMBER NOT NULL,
  QUANTITY NUMBER(18,6) NOT NULL,
  PRIMARY KEY(ID),
  CONSTRAINT FK_ORDERR_DETAIL_ORDERR_ID FOREIGN KEY(ORDERR_ID) REFERENCES ORDERR(ID),
  CONSTRAINT FK_ORDERR_DETAIL_PRODUCT_ID FOREIGN KEY(PRODUCT_ID) REFERENCES PRODUCT(ID)  
);

CREATE SEQUENCE ORDERR_DETAIL_ID_SEQ_GEN
  MINVALUE 1 MAXVALUE 9999
  START WITH 1 INCREMENT BY 1;
  
--ALTER SESSION SET NLS_DATE_FORMAT='YYYY-MM-DD';


-------------------------------------------------
------------ DATA SAMPLE ------------------------
INSERT INTO CUSTOMER (ID, FIRST_NAME, LAST_NAME, TAX_IDENTIFICATION_NUMBER, CUSTOMER_CODE, BIRTH_DATE) 
    VALUES(1, 'Walter', 'Bates', '1234', 'C567', TO_DATE('1999-10-18','YYYY-MM-DD'));	
INSERT INTO CUSTOMER (ID, FIRST_NAME, LAST_NAME, TAX_IDENTIFICATION_NUMBER, CUSTOMER_CODE, BIRTH_DATE) 
    VALUES(2, 'April', 'Sanchez', '5678', 'C344', TO_DATE('1995-10-10','YYYY-MM-DD'));
INSERT INTO CUSTOMER (ID, FIRST_NAME, LAST_NAME, TAX_IDENTIFICATION_NUMBER, CUSTOMER_CODE) 
    VALUES(3, 'Tomas', 'Harrison', '1909', 'C128');
INSERT INTO PRODUCT (ID, DESCRIPTION, PRODUCT_CODE) VALUES(1, 'Description Product A', 'P123');
INSERT INTO PRODUCT (ID, DESCRIPTION, PRODUCT_CODE) VALUES(2, 'Description Product B', 'P456');
INSERT INTO PRODUCT (ID, DESCRIPTION, PRODUCT_CODE) VALUES(3, 'Description Product C', 'P798');
INSERT INTO PRODUCT (ID, DESCRIPTION, PRODUCT_CODE) VALUES(4, 'Description Product D', 'P223');

-----------------------------------------------
--INSERT INTO ORDERR (ID, DOCUMENT_NUMBER, ORDERR_DATE, CUSTOMER_ID) VALUES (1, 100, TO_DATE('2021-11-18','YYYY-MM-DD'), 2);
-----------------------------------------------
--INSERT INTO ORDERR_DETAIL (ID, ORDERR_ID, PRODUCT_ID, QUANTITY) VALUES(1, 1, 1, 10);
--INSERT INTO ORDERR_DETAIL (ID, ORDERR_ID, PRODUCT_ID, QUANTITY) VALUES(2, 1, 2, 5);
