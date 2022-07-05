# Java Spring Boot Sesi 17

Pada sesi ini dipelajari mengenai:
#### Implementasi API pada Spring

## Requirement
- Postman
- Spring related dependencies

Migrasi dari VSCode ke Eclipse dengan command:
        
         mvn eclipse:eclipse

Command untuk membuat folder unit testing: 

        mvn archetype:generate -DgroupId=com.learning.example -DartifactId=DemoExample -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

## Running
- Running dilakukan dengan membuka folder (BTDP-Java-SpringBoot/Sesi-17/BelajarAPI)
- Jalankan server database dan buat database db_users
- Lakukan konfigurasi pada (src/main/resources/application.properties)
Jika menggunakan Eclipse IDE, dapat run dengan mengaktifkan Boot Dashboard pada view:
        
       Buka Boot Dashboard > Klik kanan BelajarAPI > klik (re)start

- Pada database, db_users akan terisi sesuai dengan kodingan pada entity.
- Untuk melakukan CRUD dapat membuka Postman dengan metode Get, Post, Put dan Delete.
Jika menggunakan VSCode, dapat run menggunakan Terminal:

Update file pom.xml:

        mvn clean
Compile/install files:

        mvn install
Run with test:

        mvn test

*Catatan: lengkapi pom.xml dengan dependency yang diperlukan