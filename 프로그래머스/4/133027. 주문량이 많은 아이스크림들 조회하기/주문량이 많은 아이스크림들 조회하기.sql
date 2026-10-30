-- 코드를 입력하세요
SELECT F.FLAVOR
from FIRST_HALF F join JULY J on F.FLAVOR = J.FLAVOR
group by F.FLAVOR
order by F.TOTAL_ORDER + sum(J.TOTAL_ORDER) desc
limit 3;