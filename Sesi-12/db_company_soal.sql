-- Soal Requirement 2

-- 1.  Tampilkan dependent name dan relationship dengan employee yang namanya diawali dengan huruf R 

select td.dependent_name, td.relationship, te.first_name
from tb_dependent td
join tb_employee te on td.ssn = te.ssn

where te.first_name like 'r%'

-- 2. Banyaknya employee yang mengerjakan suatu project

SELECT COUNT(te.ssn) as pekerja_project_1 FROM tb_employee te JOIN
tb_works_on tw ON te.ssn = tw.ssn WHERE
tw.proj_number = '001';

-- 3. Banyaknya employee yang memiliki gaji/salary lebih dari 5.000.000 

SELECT COUNT(ssn) FROM tb_employee WHERE
salary > 5000000;

-- 4. Banyaknya project yang dikerjakan oleh 1 (satu) department

SELECT COUNT(proj_number) as jumlah_project_dept1 FROM tb_project tp JOIN
tb_department td ON td.dep_number = tp.dep_number WHERE
tp.dep_number = 00001;

SELECT td.dep_name as nama_department, AVG(te.salary) as rata_rata_gaji FROM tb_employee te JOIN
tb_department td ON te.dep_number = td.dep_number
GROUP BY td.dep_number;

-- 5. Hitung total dan rata-rata (average) gaji/salary dari masing-masing departement 

SELECT td.dep_name as nama_department, AVG(te.salary) as rata_rata_gaji,  SUM(te.salary) as total_gaji
FROM tb_employee te JOIN
tb_department td ON te.dep_number = td.dep_number
GROUP BY td.dep_number;