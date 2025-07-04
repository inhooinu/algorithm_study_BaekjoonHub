-- 코드를 작성해주세요
# 가장 큰 물고기의 길이 조회
# 길이에 cm 붙여서 출력
# 컬럼명 MAX_LENGTH

SELECT CONCAT(MAX(LENGTH), "cm") AS MAX_LENGTH
FROM FISH_INFO
