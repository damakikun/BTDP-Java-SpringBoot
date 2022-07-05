# Java Spring Boot Sesi 20

Pada sesi ini dipelajari mengenai:
## Unit Testing
Unit testing adalah metode yang menggunakan mock data (data palsu) untuk melakukan pengecekan pada suatu block kode untuk mengantisipasi berbagai jenis data.
#### Contoh Penggunaan
- Mendeklarasi variable yang akan dilakukan unit testing 

        final Long id = new Random().nextLong();
		final Product product = TestObjectFactory.createProduct();
		Mockito.when(productRepository.findById(id)).thenReturn(Optional.of(product));
-  Mendeklarasi variable "actual" yang akan dijadikan patokan unit testing

		final Product actual = productService.findProductById(id);
- Melakukan pengecekan apakah nilai pada variable product(mock) sudah sesuai dengan yang ada pada variable "actual"

		MatcherAssert.assertThat(actual.getId(), Matchers.equalTo(product.getId()));
		MatcherAssert.assertThat(actual.getName(), Matchers.equalTo(product.getName()));
		MatcherAssert.assertThat(actual.getHargaBeli(), Matchers.equalTo(product.getHargaBeli()));
		MatcherAssert.assertThat(actual.getHargaJual(), Matchers.equalTo(product.getHargaJual()));



## Spring Security
Pada Spring Security, dipelajari bagaimana dilakukan authentikasi dan authorization pada role user yang telah ditentukan.

#### Contoh Penggunaan
        http.httpBasic()
                        .and()
                                .authorizeRequests()
                                .antMatchers("/api/index").permitAll()
                                .antMatchers("/api/profile/**").authenticated()
                                .antMatchers("/api/products/**").hasRole("ADMIN")
                                .antMatchers("/api/management/**").hasAnyRole("ADMIN", "MANAGER")
                                .antMatchers("/api/user/test1").hasAuthority("ACCESS_TEST1")
                                .antMatchers("/api/user/test2").hasAuthority("ACCESS_TEST2")
Pada block kode diatas, terdapat beberapa jenis authorization:
- permitAll digunakan untuk memberikan izin kepada semua user
- authenticated memberikan izin kepada setiap user yang sudah melakukan authentikasi
- hasRole dan hasAnyRole memberikan izin kepada user dengan role yang ditentukan
- hasAuthority memberikan izin spesifik terhadap authority yang dimiliki user 

Pengetestan authority dapat dilakukan dengan Postman

## Running
- Running dilakukan dengan membuka folder (BTDP-Java-SpringBoot/Sesi-20/SpringProductBasicAuth)
- Jalankan server database dan buat database h8_produk
- Lakukan konfigurasi pada (src/main/resources/application.properties)
Jika menggunakan Eclipse IDE, dapat run dengan mengaktifkan Boot Dashboard pada view:
        
       Buka Boot Dashboard > Klik kanan SpringProductBasicAuth > klik (re)start

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