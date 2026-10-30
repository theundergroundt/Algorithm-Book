-- 코드를 입력하세요
SELECT substr(PRODUCT_CODE, 1, 2) as CATEGORY, count(PRODUCT_ID) as PRODUCTS
from PRODUCT
group by substr(PRODUCT_CODE, 1, 2)
order by PRODUCT_CODE;