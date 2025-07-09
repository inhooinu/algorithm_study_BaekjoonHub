-- 코드를 입력하세요
# 2022년 5월에 예약한 환자 수 조회
# GROUP BY 진료과코드
# 컬럼명: 진료과코드, 5월예약건수
# 환자 수 기준 오름차순 정렬, 진료과 코드 기준 오름차순 정렬

SELECT MCDP_CD AS 진료과코드, COUNT(*) AS 5월예약건수
FROM APPOINTMENT
WHERE YEAR(APNT_YMD) = 2022 AND MONTH(APNT_YMD) = 5
GROUP BY MCDP_CD
ORDER BY 5월예약건수 ASC, 진료과코드 ASC