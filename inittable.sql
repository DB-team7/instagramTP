create database dmaster;
use dmaster;

/*유저follow 테이블*/
CREATE TABLE users (
    ID VARCHAR(20),
    name VARCHAR(20),
    phone_num VARCHAR(13),
    email VARCHAR(30),
    password VARCHAR(20),
    FILENAME VARCHAR(50),
    FILE MEDIUMBLOB,
    PRIMARY KEY (ID)
);

/*게시글 테이블*/    
CREATE TABLE posts (
    ID INT AUTO_INCREMENT,
    user_id VARCHAR(20),
    content VARCHAR(500),
    created_at DATETIME,
    cnt_like INT,
    FILENAME VARCHAR(50),
    FILE MEDIUMBLOB,
    PRIMARY KEY (ID),
    FOREIGN KEY (user_id)
        REFERENCES users (ID)
);

/*팔로우 테이블*/
CREATE TABLE follow (
    follower VARCHAR(20),
    followee VARCHAR(20),
    FOREIGN KEY (follower)
        REFERENCES users (ID),
    FOREIGN KEY (followee)
        REFERENCES users (ID)
);

/*차단 테이블*/
CREATE TABLE block (
    user_id VARCHAR(20),
    block_id VARCHAR(20),
    FOREIGN KEY (user_id)
        REFERENCES users (ID),
    FOREIGN KEY (block_id)
        REFERENCES users (ID)
)
;
/*댓글 테이블*/
CREATE TABLE comment (
    ID INT AUTO_INCREMENT,
    user_id VARCHAR(20),
    post_id INT,
    content VARCHAR(100),
    created_at DATE,
    like_cnt INT,
    PRIMARY KEY (ID),
    FOREIGN KEY (user_id)
        REFERENCES users (ID),
    FOREIGN KEY (post_id)
        REFERENCES posts (ID)
);

/*좋아요 테이블*/
CREATE TABLE likes (
    target_id INT,
    user_id VARCHAR(20),
    FOREIGN KEY (user_id)
        REFERENCES users (ID),
    FOREIGN KEY (target_id)
        REFERENCES posts (ID)
);



-- /*회원가입시--  아이디가 겹치는지 확인하는 쿼리문*/
-- select ID, count(ID) as cnt_id from users group by ID having cnt_ID > 1; 

-- /*회원가입 버튼을 누르면 회원 정보가 회원 데이터베이스로 들어가는 쿼리문*/
-- insert into users values (id, name, phone_num, email, pw);
-- /*id, name, phone_num, email, pw는 사용자가 직접 입력한 데이터*/

-- /*로그인할 때 비밀번호가 맞는지 확인하는 쿼리*/
-- select password from users where ID = '입력한 아이디';
-- /*입력한 아이디의 비밀번호를 불러온다.*/

-- /*마이페이지 본인의 팔로워 수 팔로잉 수 게시글 댓글 띄우는 쿼리.*/
-- /* select count(followee) from follow natural join users where followee = users.ID = 'aa';
-- select count(follower) from follow natural join users where follower = users.ID = 'aa'; */

-- /* 게시글 하트의 수 */
-- select count(target_id) as cnt_likes from likes where target_id = 'aa';

-- /*하트를 누르면 해당 게시글의 하트가 높아져야 한다.*/
-- insert into likes values (ID, target_id, user_id);
-- select count(target_id) as cnt_likes from likes where target_id = 'aa';

-- /*댓글 누르면 해당 포스트의 댓글이 다 나와야 한다.*/
-- select * from comment natural join posts where posts.ID = '해당 포스트 ID';

-- /*업로드 포스트를 누르면 로그인한 아이디의 포스트 목록으로*/
-- insert into posts values (id, user_id, created_at, content, cnt_like = 0); 
-- /*업로드를 할 때는 좋아요가 0으로 초기화*/

-- /*modify를 하면 해당 로그인된 아이디의 포스트가 수정*/
-- update posts set content = "수정할 내용" where ID = "해당 글의 아이디" ;

-- /*drop하면 포스트 삭제*/
-- delete from posts where ID = '게시글의 ID';

-- /*베스트피드 --> 좋아요 상위(내림차순), 날짜는 일주일 이내.*/
-- select * from posts where created_at between date_add(now(), interval -1 week) and now() order by cnt_like desc; 