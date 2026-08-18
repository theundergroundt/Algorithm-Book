-- 코드를 작성해주세요
select count(*) as COUNT from ECOLI_DATA 
where (GENOTYPE & 1 or GENOTYPE & 4) and GENOTYPE & 2 = 0;