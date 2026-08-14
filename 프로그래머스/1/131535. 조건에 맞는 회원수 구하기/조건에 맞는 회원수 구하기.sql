-- 코드를 입력하세요
SELECT count(USER_ID) from USER_INFO
    where YEAR(JOINED) = 2021 AND AGE between 20 and 29