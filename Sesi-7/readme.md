# Java Spring Boot Sesi 7

Pada sesi ini dipelajari mengenai:
 
 1. Algoritma Selection Sort\
    Sorting dimanfaatkan untuk mempermudah mendapatkan informasi tertentu secara cepat, dengan melakukan pengecekan dari setiap number
    cara Algoritma Selection Sort:\
         - Jumlah Iterasi untuk Selection Sort ialah berjumlah sebesar Jumlah Data – Untuk kasus pada sesi 6 ini, Jumlah Datanya ialah 6. Maka, jumlah Iterasinya ialah sebesar 6 – 1 = 5.\
         - Proses pertukaran Data dimulai dari Data Pertama sampai Data Terakhir dengan cara membandingkanData ke-n dan cari   nilai yang paling kecil di sisi kanan nilai n.\
         - Keterangan bahwa nilai Data yang sudah di tukar(nilai yang paling kecil) tidak akan dibandingkan lagiuntuk proses iterasi berikutnya. Berikut ilustrasi lengkapnya untuk kasus diatas.
    
 2. Binary Search\
    Saat binary search digunakan untuk melakukan operasi pada kumpulan yang telah diurutkan, jumlah iterasi selalu dapat dikurangi tergantung dengan nilai yang dicari


## Running
Compiling: 

    javac NamaFile.java
Dari sini akan di generate file .class

*Catatan: untuk run file tersebut ada 2 perbedaan command untuk run\
    1. Jika dari folder parent harus diopen dari main branch (BTDP Java SpringBoot) dengan command:

    java BTDP Java SpringBoot/Sesi-1/NamaFile
\
2. Jika di run dari folder file tersebut(BTDP Java SpringBoot/Sesi-1)

    java NamaFile.java