-- 코드를 작성해주세요
select I.ID, count(F.ID) as CHILD_COUNT from ECOLI_DATA I
left join ECOLI_DATA F on I.ID = F.PARENT_ID
group by I.ID
order by I.ID;
