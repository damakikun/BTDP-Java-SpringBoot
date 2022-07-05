# Java Spring Boot Sesi 21

## Push notification with Firebase

Project yang digunakan terdapat pada folder `HelloJavaSpring`. Sebelumnya dilakukan setup terlebih dahulu dengan konfigurasi firebase yang terdapat di `resources/firebase-service-account.json`. Firebase disini digunakan untuk mengirimkan notifikasi melalui layanan Firebase Cloud Messaging (FCM) yang disediakan oleh Firebase.

Untuk mengakses FCM:

1. Jalankan project: `mvn spring-boot:run`
2. Hit endpoint berikut: `http://localhost:8080/send-notification?topic=gold` dengan request body json:

```
{
    "subject": "some subject",
    "content": "Some long content",
    "image": "https://upload.wikimedia.org/wikipedia/en/9/95/Test_image.jpg",
    "data": {
      "key1": "Value 1",
      "key2": "Value 2",
      "key3": "Value 3",
      "key4": "Value 4"
    }
}
```