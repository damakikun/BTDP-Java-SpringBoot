# Java Spring Boot Sesi 18

Pada sesi ini dipelajari mengenai:

- Spring Boot Auth (with JWT)

Migrasi dari VSCode ke Eclipse dengan command:
        
         mvn eclipse:eclipse

Command untuk membuat folder unit testing: 

        mvn archetype:generate -DgroupId=com.learning.example -DartifactId=DemoExample -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

## Running
- Running dilakukan dengan membuka folder (BTDP-Java-SpringBoot/Sesi-18/SpringBelajarJwt)
- Jalankan server database dan buat database db_belajarjwt
- Lakukan konfigurasi pada (src/main/resources/application.properties)
Jika menggunakan Eclipse IDE, dapat run dengan mengaktifkan Boot Dashboard pada view:
        
       Buka Boot Dashboard > Klik kanan SpringBelajarJwt > klik (re)start

- Pada database, db_book akan terisi sesuai dengan kodingan pada main file.
Jika menggunakan VSCode, dapat run menggunakan Terminal:

Update file pom.xml:

        mvn clean
Compile/install files:

        mvn install
Run with test:

        mvn test

*Catatan: lengkapi pom.xml dengan dependency yang diperlukan