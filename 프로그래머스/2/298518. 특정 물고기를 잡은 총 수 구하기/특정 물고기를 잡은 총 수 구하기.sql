-- 코드를 작성해주세요
select count(I.ID) as FISH_COUNT from FISH_INFO I
where I.FISH_TYPE IN (select FISH_TYPE from FISH_NAME_INFO where FISH_NAME = 'BASS' or FISH_NAME = 'SNAPPER' )