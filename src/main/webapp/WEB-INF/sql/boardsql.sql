CREATE DATABASE englishWeb;
USE englishWeb;

DROP TABLE noticeboard;
CREATE TABLE noticeboard(
	boardNo INT AUTO_INCREMENT,
	userId VARCHAR(30),
	writer VARCHAR(30) NOT NULL,
	title VARCHAR(100) NOT NULL,
	content VARCHAR(1000) NOT NULL,
	regDate DATE DEFAULT NOW(),
	viewCnt INT DEFAULT 0,
	CONSTRAINT nb_pk PRIMARY KEY(boardNo)
);
DROP TABLE freeboard;
CREATE TABLE freeboard(
	boardNo INT AUTO_INCREMENT,
	userId VARCHAR(30),
	writer VARCHAR(30) NOT NULL,
	title VARCHAR(100) NOT NULL,
	content VARCHAR(1000) NOT NULL,
	regDate DATE DEFAULT NOW(),
	viewCnt INT DEFAULT 0,
	CONSTRAINT fb_pk PRIMARY KEY(boardNo)
);
DROP TABLE wordboard;
CREATE TABLE wordboard(
	boardNo INT AUTO_INCREMENT,
	userId VARCHAR(30),
	writer VARCHAR(30) NOT NULL,
	word VARCHAR(100) NOT NULL,
	content VARCHAR(1000) NOT NULL,
	regDate DATE DEFAULT NOW(),
	viewCnt INT DEFAULT 0,
	CONSTRAINT wordboard_pk PRIMARY KEY(boardNo)
);

DROP TABLE expressionboard;
CREATE TABLE expressionboard(
	boardNo INT AUTO_INCREMENT,
	userId VARCHAR(30),
	writer VARCHAR(30) NOT NULL,
	expression VARCHAR(150) NOT NULL,
	content VARCHAR(1000) NOT NULL,
	regDate DATE DEFAULT NOW(),
	viewCnt INT DEFAULT 0,
	CONSTRAINT expressionboard_pk PRIMARY KEY(boardNo)
);

DROP TABLE idiomboard;
CREATE TABLE idiomboard(
	boardNo INT AUTO_INCREMENT,
	userId VARCHAR(30),
	writer VARCHAR(30) NOT NULL,
	idiom VARCHAR(150) NOT NULL,
	content VARCHAR(1000) NOT NULL,
	regDate DATE DEFAULT NOW(),
	viewCnt INT DEFAULT 0,
	CONSTRAINT idiomboard_pk PRIMARY KEY(boardNo)
);

DROP TABLE recordboard;
CREATE TABLE recordboard(
	boardNo INT AUTO_INCREMENT,
	userId VARCHAR(30),
	writer VARCHAR(30) NOT NULL,
	title VARCHAR(100) NOT NULL,
	content VARCHAR(1000) NOT NULL,
	regDate DATE DEFAULT NOW(),
	viewCnt INT DEFAULT 0,
	recordFileName VARCHAR(50),
	CONSTRAINT wordboard_pk PRIMARY KEY(boardNo)
);

DROP TABLE meetingboard;
CREATE TABLE meetingboard(
	boardNo int AUTO_INCREMENT,
	userId varchar(30),
	writer VARCHAR(30) NOT NULL,
	title VARCHAR(100) NOT NULL,
	content VARCHAR(1000) NOT NULL,
	regDate DATE DEFAULT NOW(),
	viewCnt INT DEFAULT 0,
	CONSTRAINT meetingboard_pk PRIMARY KEY(boardNo)
);

DROP TABLE USER;
CREATE TABLE USER(
	userId VARCHAR(30) NOT NULL PRIMARY KEY,
	userPw VARCHAR(130) NOT NULL,
	userName VARCHAR(30) NOT NULL,
	nickName VARCHAR(40) NOT NULL,
	birth VARCHAR(30) NOT NULL,
	email VARCHAR(60) NOT NULL,
	gender VARCHAR(5) NOT NULL,
	phone VARCHAR(30) NOT NULL,
	regDate DATE DEFAULT NOW()
);

DROP TABLE filetable;
CREATE TABLE filetable(
	NO INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	boardNo INT NOT NULL,
	orgFileName VARCHAR(260) NOT NULL,
	saveFileName VARCHAR(36) NOT NULL,
	fileSize INT DEFAULT NULL,
	updateDate DATE NOT NULL DEFAULT NOW(),
	creaID VARCHAR(30) NOT NULL,
	delChk VARCHAR(1) NOT NULL DEFAULT 'N',
	creaDate DATE NOT NULL DEFAULT NOW()
);