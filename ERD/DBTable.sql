

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
    `color`            	TEXT   NOT NULL,
    `dress_img_org`  	TEXT   NULL        COMMENT '����������', 
    `dress_img_sav` 	TEXT   NULL        COMMENT '���������', 
    `dress_name`    	TEXT    NOT NULL, 
    `dress_memo`    	TEXT           NULL,
    `dress_regDate`    	DATETIME       NOT NULL    DEFAULT now(), 
    `share_type`       	INT            NOT NULL    DEFAULT 1 COMMENT '0: ���� 1: �����',
    `likes`       		INT            NULL    DEFAULT 0,
    PRIMARY KEY (dress_uid),
    FOREIGN KEY (mb_uid) REFERENCES member (mb_uid)
);
       
ALTER TABLE dress convert to charset utf8;

DROP TABLE IF EXISTS dress ;
select * from dress;

CREATE TABLE reply
(
    `reply_uid`         INT         NOT NULL 	AUTO_INCREMENT, 
    `dress_uid`       	INT         NOT NULL, 
    `reply_content`     TEXT        NOT NULL, 
    `mb_uid`            INT         NOT NULL, 
    `reply_date`        DATETIME    NOT NULL    DEFAULT now(), 
    PRIMARY KEY (reply_uid),
    FOREIGN KEY (dress_uid) REFERENCES dress (dress_uid),
    FOREIGN KEY (mb_uid) REFERENCES member (mb_uid)
);

ALTER TABLE reply convert to charset utf8;

DROP TABLE IF EXISTS reply ;
select * from reply;

CREATE TABLE rereply
(
    `rereply_uid`       INT         NOT NULL 	AUTO_INCREMENT, 
    `reply_uid`       	INT         NOT NULL, 
    `rereply_content`   TEXT        NOT NULL, 
    `mb_uid`            INT         NOT NULL, 
    `rereply_date`      DATETIME    NOT NULL    DEFAULT now(), 
    PRIMARY KEY (rereply_uid),
    FOREIGN KEY (reply_uid) REFERENCES reply (reply_uid),
    FOREIGN KEY (mb_uid) REFERENCES member (mb_uid)
);

ALTER TABLE rereply convert to charset utf8;

DROP TABLE IF EXISTS rereply ;
select * from rereply;

CREATE TABLE likes
(
    `dress_uid`       	INT         NOT NULL, 
    `mb_uid`            INT         NOT NULL, 
    `likes_type`       	INT         NOT NULL    DEFAULT 0 COMMENT '0: �� ���� 1: ����',
    PRIMARY KEY (dress_uid, mb_uid),
    FOREIGN KEY (dress_uid) REFERENCES dress (dress_uid),
    FOREIGN KEY (mb_uid) REFERENCES member (mb_uid)
);

ALTER TABLE likes convert to charset utf8;

DROP TABLE IF EXISTS likes ;
select * from likes;

