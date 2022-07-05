# Java Spring Boot Sesi 15

Pada sesi ini dipelajari mengenai:
 #### JPA
 Melakukan query SQL dengan java

Migrasi dari VSCode ke Eclipse dengan command:
        
         mvn eclipse:eclipse

Command untuk membuat folder unit testing: 

        mvn archetype:generate -DgroupId=com.learning.example -DartifactId=DemoExample -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

## Running
Running dilakukan dengan membuka folder (BTDP Java SpringBoot/Sesi-8/DemoThread)\
Jika menggunakan Eclipse IDE, dapat run dengan:
        
        Klik kanan pom.xml > run as > maven clean > maven install > maven test

Jika menggunakan VSCode, dapat merunning menggunakan Terminal:\

Update file pom.xml:

        mvn clean
Compile/install files:

        mvn install
Run with test:

        mvn test

*Catatan: lengkapi pom.xml dengan dependency yang diperlukan