-- 코드를 입력하세요
SELECT CAR_ID
from CAR_RENTAL_COMPANY_CAR
where CAR_ID in (select CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                where MONTH(START_DATE) = 10
                ) and CAR_TYPE = '세단'
order by CAR_ID desc;