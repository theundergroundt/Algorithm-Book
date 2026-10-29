-- 코드를 작성해주세요
Select sum(G.SCORE) as SCORE, E.EMP_NO, E.EMP_NAME, E.POSITION, E.EMAIL from HR_EMPLOYEES E  join HR_GRADE G on E.EMP_NO = G.EMP_NO 
where G.YEAR = 2022
group by G.EMP_NO
order by SCORE desc
Limit 1;