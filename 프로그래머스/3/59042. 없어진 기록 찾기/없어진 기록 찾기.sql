-- 코드를 입력하세요
SELECT o.animal_id, o.name from animal_outs as o where o.animal_id not in (select animal_id from animal_ins) order by o.animal_id;