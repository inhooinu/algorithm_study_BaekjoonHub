-- 코드를 입력하세요
# 고양이와 개가 각각 몇 마리인지 조회
# 고양이 먼저 조회

SELECT ANIMAL_TYPE, COUNT(*) AS count
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY FIELD(ANIMAL_TYPE, 'Cat', 'Dog')