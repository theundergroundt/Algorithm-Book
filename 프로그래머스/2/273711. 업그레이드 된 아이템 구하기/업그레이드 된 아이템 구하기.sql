-- 코드를 작성해주세요
select F.ITEM_ID, F.ITEM_NAME, F.RARITY from ITEM_TREE I
join ITEM_INFO F on F.ITEM_ID = I.ITEM_ID
join ITEM_INFO P on P.ITEM_ID = I.PARENT_ITEM_ID
where P.RARITY ='RARE'
order by ITEM_ID desc;