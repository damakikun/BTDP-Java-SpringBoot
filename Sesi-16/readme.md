# Java Spring Boot Sesi 16

Pada sesi ini dipelajari mengenai:
#### Spring dan Bootstrap
#### Menampilkan data list mahasiswa dan menambahkan fitur CRUD didalamnya

Migrasi dari VSCode ke Eclipse dengan command:
        
         mvn eclipse:eclipse

Command untuk membuat folder unit testing: 

        mvn archetype:generate -DgroupId=com.learning.example -DartifactId=DemoExample -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

## Running
- Running dilakukan dengan membuka folder (BTDP-Java-SpringBoot/Sesi-16/BelajarSpringBootstrap)
- Jalankan server database dan buat database db_mahasiswa
- Lakukan konfigurasi pada (src/main/resources/application.properties)
Jika menggunakan Eclipse IDE, dapat run dengan mengaktifkan Boot Dashboard pada view:
        
       Buka Boot Dashboard > Klik kanan BelajarSpringBootstrap > klik (re)start

- Pada database, db_mahasiswa akan terisi sesuai dengan kodingan pada file .sql di src/main/resources/db
- Jalankan di browser, ketikkan localhost:8081/index maka akan tampil tabel dengan data mahasiswa

Jika menggunakan VSCode, dapat run menggunakan Terminal:

Update file pom.xml:

        mvn clean
Compile/install files:

        mvn install
Run with test:

        mvn test

*Catatan: lengkapi pom.xml dengan dependency yang diperlukan