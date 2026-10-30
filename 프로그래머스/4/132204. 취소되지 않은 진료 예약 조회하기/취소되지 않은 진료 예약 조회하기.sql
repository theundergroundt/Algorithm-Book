-- 코드를 입력하세요
SELECT T.APNT_NO, T.PT_NAME, T.PT_NO, T.MCDP_CD, D.DR_NAME, T.APNT_YMD
from (
select A.APNT_NO, P.PT_NAME, P.PT_NO, A.MCDP_CD, A.MDDR_ID, A.APNT_YMD 
    from PATIENT P join APPOINTMENT A on P.PT_NO = A.PT_NO
    where A.APNT_CNCL_YMD is null and A.APNT_YMD like '2022-04-13%'
) T join DOCTOR D on T.MDDR_ID = D.DR_ID 
where T.MCDP_CD = 'CS'
order by T.APNT_YMD;