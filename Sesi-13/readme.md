# Java Spring Boot Sesi 13

Pada sesi ini dipelajari mengenai:
 #### Hibernate
 	1. Configuration object
		- db connection (hiberbate.cfg.xml)
		- class mapping setup
	
	2. SessionFactory object
		- created using supplied configuration
		- thread safe

	3. Session object
		- get physical connection with a database
		- hanya di inisialisasi ketika interaksi dengan database dibutuhkan
		- tidak thread safe
		  
		  transient 
		  	− A new instance of a persistent class
		  	- has no representation in the database and no identifier value 
		  	  is considered transient by Hibernate

		  persistent 
		    − A persistent instance has a representation in the database, 
		      an identifier value and is associated with a Session.
	
		  detached 
		    − Once we close the Hibernate Session, 
		      the persistent instance will become a detached instance.

	4. Transaction object
	5. Query object
		- use sql/hibernate query language(HQL) to retrieve data from database
	6. Criteria object
		- create and execute object oriented criteria queries to retrieve objects


Migrasi dari VSCode ke Eclipse dengan command:
        
         mvn eclipse:eclipse

Command untuk membuat folder unit testing: 

        mvn archetype:generate -DgroupId=com.learning.exampe -DartifactId=DemoExample -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

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