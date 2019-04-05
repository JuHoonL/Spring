CREATE TABLE tbl_member (
    M_id       NUMBER           PRIMARY KEY,
    M_USERID   NVARCHAR2(30)    NOT NULL,
    M_PASSWORD NVARCHAR2(125)   NOT NULL,
    M_NAME     NVARCHAR2(125)   NOT NULL, 
    M_TEL      NVARCHAR2(20)      ,
    M_ADDR     NVARCHAR2(125)
);
DROP TABLE tbl_member;

SELECT * FROM tbl_member;

UPDATE tbl_member SET m_userid = 'gildong@naver.com' WHERE m_id = 2;

CREATE SEQUENCE SEQ_IO_MEMBER START WITH 1 INCREMENT BY 1;

CREATE TABLE tbl_product (
    p_code      VARCHAR(13)        PRIMARY KEY,
    p_name      nVARCHAR2(125)   NOT NULL,
    p_tax       CHAR(1)         DEFAULT '1',
    p_iprice    NUMBER,
    p_oprice    NUMBER
);

SELECT * FROM tbl_product WHERE p_name like '%파인%';
DROP TABLE tbl_product;
DELETE FROM tbl_product;
DESC tbl_product;
ALTER TABLE tbl_product MODIFY p_code VARCHAR2(13) ;
Select * FROM tbl_product;

CREATE TABLE tbl_iolist (
    io_id	        NUMBER		PRIMARY KEY,
    io_date	        CHAR(10)	NOT NULL,	
    io_time	        CHAR(10)	NOT NULL,
    io_pcode	    VARCHAR(13)	NOT NULL,	
    io_dcode	    CHAR(5)	    NOT NULL,
    io_inout	    CHAR(1)	    NOT NULL,
    io_tax	        CHAR(1)	    DEFAULT '1',
    io_quan	        NUMBER,
    io_price	    NUMBER,	
    io_total	    NUMBER,		
    io_tax_total	NUMBER		
);

DROP TABLE tbl_iolist;
Select * FROM tbl_iolist;
delete FRom tbl_iolist;
ALTER TABLE tbl_iolist MODIFY io_inout CHAR(1) ;
CREATE SEQUENCE SEQ_IOLIST START WITH 1 INCREMENT BY 1;

--iolist 새창
SELECT M.D_CODE FROM 
(SELECT ROW_NUMBER() OVER (ORDER BY D_CODE DESC) R, d_code FROM tbl_dept) M 
WHERE M.R=1;

SELECT * FROM tbl_iolist I LEFT JOIN tbl_product P ON I.io_pcode = P.p_code LEFT JOIN tbl_dept D ON I.io_dcode = D.d_code; 


CREATE TABLE tbl_dept (
    d_code	        CHAR(5)		        PRIMARY KEY,
    d_name	        nVARCHAR2(50)	    NOT NULL,	
    d_ceo	        nVARCHAR2(50),		
    d_tel	        nVARCHAR2(20),		
    d_addr	        nVARCHAR2(125)		
);

DESC tbl_dept;
Select * FROM tbl_dept;
DROP TABLE tbl_dept;
DELETE FROM tbl_dept ;

UPDATE tbl_dept SET 
ALTER TABLE tbl_dept MODIFY d_code VARCHAR2(5) ;

commit;