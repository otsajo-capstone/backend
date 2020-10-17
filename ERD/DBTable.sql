

CREATE TABLE member
(
    `mb_uid`      INT             NOT NULL    AUTO_INCREMENT, 
    `mb_id`       VARCHAR(45)     NOT NULL, 
    `mb_pw`       TEXT            NOT NULL, 
    `mb_name`     VARCHAR(45)     NOT NULL, 
    `mb_email`    TEXT            NOT NULL, 
    `mb_regDate`  DATETIME        NOT NULL    DEFAULT now(), 
    `mb_type`     INT DEFAULT 0 COMMENT '1: ��, 2: ����, 3: ����, 4: �ܿ�', 
    PRIMARY KEY (mb_uid)
);

ALTER TABLE member
    ADD CONSTRAINT UC_mb_id UNIQUE (mb_id);

ALTER TABLE member
    ADD CONSTRAINT UC_mb_email UNIQUE (mb_email);
   
ALTER TABLE member convert to charset utf8;

    
DROP TABLE IF EXISTS member ;
select * from member;

CREATE TABLE dress
(
    `dress_uid`        	INT            NOT NULL    AUTO_INCREMENT,
    `mb_uid`            INT			   NOT NULL, 
    `spring`            INT			   NOT NULL, 
    `summer`            INT			   NOT NULL, 
    `autumn`            INT			   NOT NULL, 
    `winter`            INT			   NOT NULL,
    `color`            	VARCHAR(200)   NOT NULL,
    `dress_img_org`  	VARCHAR(200)   NULL        COMMENT '����������', 
    `dress_img_sav` 	VARCHAR(200)   NULL        COMMENT '���������', 
    `dress_name`    	VARCHAR(45)    NOT NULL, 
    `dress_memo`    	TEXT           NULL,
    `dress_regDate`    	DATETIME       NOT NULL    DEFAULT now(), 
    `share_type`       	INT            NOT NULL    DEFAULT 0 COMMENT '0: ���� 1: �����',
    `likes`       		INT            NULL    DEFAULT 0,
    PRIMARY KEY (dress_uid)
);

ALTER TABLE dress
    ADD CONSTRAINT FK_dress_mb_uid_member_mb_uid FOREIGN KEY (mb_uid)
        REFERENCES member (mb_uid) ON DELETE RESTRICT ON UPDATE RESTRICT;
       
ALTER TABLE dress convert to charset utf8;

DROP TABLE IF EXISTS dress ;
select * from dress;

