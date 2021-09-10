create table memberTBL(
 mno number(8) constraint mno_pk primary key,
 mid varchar2(20) constraint mid_uk unique not null,
 mpw varchar2(20) not null,
 mname varchar2(20) not null,
 nickname varchar2(30) constraint nickname_uk unique not null,
 mstate number(1)
);

CREATE SEQUENCE mno_seq;

create table boardTBL(
 bno number constraint bno_pk primary key,
 subject varchar2(100) not null,
 content varchar2(3000) not null,
 regdate date default sysdate,
 readnum number default 0, 
 recommend number default 0,
 mno number(8) constraint mno_fk references MEMBER(mno)
);

CREATE SEQUENCE bno_seq;

create table replyTBL(
 rno number constraint rno_pk primary key,
 bno number constraint bno_fk references board(bno),
 mno number(8) constraint reply_mno_fk references member(mno),
 reply_content varchar2(1000) not null,
 reply_regdate date default sysdate
);

CREATE SEQUENCE rno_seq;

create table recommendTBL(
 recommend_no number constraint recommend_no_pk primary key,
 mno number(8) constraint recommend_mno_fk references member(mno),
 bno number constraint recommend_bno_fk REFERENCES board(bno)
);

CREATE SEQUENCE recommend_seq;


--샘플데이터
insert into memberTBL(mno, mid, mpw, mname, nickname) values(mno_seq.nextval, 'aaa', '111', 'asdf', '핳');

insert into boardTBL(bno, subject, content, mno) values(bno_seq.nextval, '제목', '내용', 2)