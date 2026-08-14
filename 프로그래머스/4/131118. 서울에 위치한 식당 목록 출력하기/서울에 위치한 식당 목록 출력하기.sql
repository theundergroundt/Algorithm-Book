-- 코드를 입력하세요
SELECT F.REST_ID, F.REST_NAME, F.FOOD_TYPE, F.FAVORITES, F.ADDRESS, round(avg(I.REVIEW_SCORE), 2) as SCORE
from REST_INFO F 
join REST_REVIEW I on I.REST_ID = F.REST_ID
where F.ADDRESS like '서울%'
group by F.REST_ID
order by score desc, F.FAVORITES desc;