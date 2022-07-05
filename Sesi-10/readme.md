# Java Spring Boot Sesi 10

Pada sesi ini dipelajari mengenai:
 
 1. Database\
    a. Relational Database\
    b. Non-Relational Database

## Spesifikasi Database
1. MySQL
2. Xampp 7.4.29
*catatan: untuk mengupdate schema database dapat dilakukan dengan cara run:
       
        /Applications/XAMPP/bin/mysql_upgrade

## Running
- Running dilakukan dengan menjalankan server pada Xampp\
- Buka pada browser:
---

        localhost/phpmyadmin
atau

        localhost:8080/phpmyadmin
atau

        127.0.0.1/phpmyadmin

### Query Umum
Buat Database:

        CREATE DATABASE db_name
Buat Table:

        CREATE TABLE tb_name(`col1_name` data_type, `col2_name` data_type)
Insert Data:

        INSERT INTO `tb_name`(`col1_name`, `col2_name`)
        VALUES (`col1_data`, `col2_data`)

Menampilkan Data:

        SELECT * from tb_name