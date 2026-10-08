# Minpro-3-PBO-ManajemenProyekStartUp

Program ini dibuat menggunakan Java untuk membantu sebuah startup mencatat dan mengelola proyek-proyeknya. Program ini bisa menyimpan, menampilkan, mengubah, dan menghapus data proyek atau biasa disebut operasi CRUD (Create, Read, Update, Delete).

Program ini mengelola dua jenis proyek yang berbeda, yaitu:
- Proyek Internal: proyek yang dikerjakan untuk kebutuhan perusahaan sendiri
- Proyek Klien: proyek yang dikerjakan untuk klien/perusahaan luar

Kedua jenis proyek ini memiliki data umum yang sama (ID, nama, deadline), tetapi juga memiliki data tambahan yang berbeda sesuai kebutuhannya masing-masing.

---

## 1. Struktur Package
Program ini menerapkan struktur **MVC (Model View Controller)**, yaitu struktur yang memisahkan program menjadi tiga peran utama yaitu Data (Model), Tampilan (View), dan Pengatur Alur (Controller), ditambah satu package `main` sebagai titik masuk program. Berikut struktur package pada program ini:
><img width="400" alt="image" src="https://github.com/user-attachments/assets/da63cba8-3171-42a4-938e-e2017f2d620f" />

Penjelasan penerapan MVC pada setiap package:

- **`model`**: Berisi kelas `Proyek` (abstract class), `ProyekInternal`, dan `ProyekKlien`. Package ini merepresentasikan bagian **Model** dalam MVC, yaitu bagian yang menyimpan struktur data proyek beserta aturan validasinya. Model tidak ada hubungannya dengan tampilan menu atau logika CRUD, tugasnya murni menjaga data tetap konsisten.

- **`view`**: Berisi kelas `ProyekView`, yang merepresentasikan bagian **View** dalam MVC. Tugasnya menampilkan menu ke layar dan menerima input dari pengguna. View tidak menyimpan data sendiri, ia hanya meneruskan input pengguna ke controller dan menampilkan hasil yang diberikan controller. Pengulangan validasi input dibungkus dalam method pembantu seperti `inputTeks()` dan `inputDeadline()` agar kode tidak berulang.

- **`controller`**: Berisi interface `ProyekCrud`, kelas `ProyekController`, dan kelas `Validasi`, yang merepresentasikan bagian **Controller** dalam MVC. `ProyekCrud` mendefinisikan daftar operasi CRUD, dan `ProyekController` mengimplementasikannya sebagai penghubung antara `view` dan `model`: ia menerima permintaan dari view, memproses logikanya seperti menyimpan, mencari, mengubah, atau menghapus data di `model`, lalu mengembalikan hasilnya (berupa `boolean` atau objek) tanpa mencetak apa pun ke layar. `Validasi` mendukung controller dengan memastikan setiap input pengguna sudah benar sebelum diproses lebih lanjut.

- **`main`**: Berisi kelas `MainApp` yang menjadi titik masuk program. Kelas ini hanya memanggil satu method, yaitu `ProyekView.mulai()`, untuk memulai siklus menu dari awal sampai program ditutup.

Dengan pembagian ini, setiap bagian program bisa dikembangkan atau diperbaiki secara terpisah. Misalnya, jika tampilan menu ingin diubah, cukup edit file di `view` tanpa perlu menyentuh logika penyimpanan data di `model` atau `controller`. Hal ini membuat program lebih rapi, mudah dibaca, dan mudah dikembangkan lebih lanjut di kemudian hari.

---

## 2. Alur Program

### Langkah 1: Program dimulai
> <img width="500" alt="image" src="https://github.com/user-attachments/assets/e1b7f560-e365-4c74-ab1b-7773e2674b2e" />
Tampilan awal program saat pertama kali dijalankan menampilkan banner SISTEM MANAJEMEN PROYEK STARTUP, kemudian muncul menu utama dengan 5 pilihan, yaitu Tambah Proyek, Tampilkan Semua Proyek, Update Proyek, Hapus Proyek, dan Keluar. Pengguna dapat memilih menu dengan memasukkan angka pada bagian "Pilih menu:".

### Langkah 2: Program menjalankan pilihan menu
Disini pengguna diarahkan ke menu sesuai dengan angka yang dimasukkan. Setiap menu memiliki fungsi yang berbeda untuk mengelola data proyek. Berikut adalah penjelasan dari setiap menu yang tersedia pada program:

- **Menu 1: Tambah Proyek**
  > <img width="550" alt="image" src="https://github.com/user-attachments/assets/9744da08-0178-4e33-86de-82afee726ed2" />
  Pengguna pertama-tama memilih jenis proyek yaitu Internal atau Klien. Setelah itu, program meminta data satu per satu yang terdiri dari ID, nama, deadline, dan data khusus sesuai jenis proyeknya. Jika semua data valid, proyek baru dibuat dan disimpan.

  Salah satu contoh validasi data adalah jika ID yang dimasukkan sudah digunakan, program memberi tahu pengguna lalu menampilkan kembali bagian `INFORMASI PROYEK` dan meminta ID baru sampai ID yang dimasukkan belum pernah dipakai:
  ><img width="409" height="147" alt="image" src="https://github.com/user-attachments/assets/0d32d6cc-acd3-4109-9312-d8ae91966749" />

  Berikut tampilan semua proyek yang menunjukkan bahwa proyek berhasil ditambahkan.
  > <img width="400" alt="image" src="https://github.com/user-attachments/assets/da0f6ed9-4193-40f4-b96b-9364a6f5e073" />

- **Menu 2: Tampilkan Semua Proyek**
  > <img width="380" alt="image" src="https://github.com/user-attachments/assets/6ce7fc00-e7b3-4bf5-98b7-50c211e0fb46" />
  Program menampilkan seluruh data yang tersimpan, lengkap dengan nomor urut dan jenis proyeknya.

- **Menu 3: Update Proyek**
  > <img width="500" alt="image" src="https://github.com/user-attachments/assets/4aa03887-7781-46b4-8fa1-3646f2a3877a" />
  Pengguna memasukkan ID proyek yang ingin diubah lalu program akan mencari proyek tersebut. Setelah ditemukan, data lama ditampilkan terlebih dahulu sebagai pembanding, kemudian pengguna diminta memasukkan data baru. Program otomatis mendeteksi apakah proyek tersebut jenis Internal atau Klien, sehingga pertanyaan yang muncul menyesuaikan.

  Pada bagian bawah setelah data lama, pengguna cukup menekan Enter jika tidak ingin mengubah suatu data, sehingga data lama tetap dipertahankan. Khusus deadline, jika pengguna memasukkan nilai yang formatnya salah, program akan meminta input ulang sampai formatnya benar atau pengguna menekan Enter.

  > <img width="400" alt="image" src="https://github.com/user-attachments/assets/c41024a4-c91f-46c6-b263-6d303efeeced" />
  Gambar diatas merupakan tampilan semua proyek yang menunjukkan bahwa proyek berhasil diupdate.

- **Menu 4: Hapus Proyek**
  > <img width="400" alt="image" src="https://github.com/user-attachments/assets/b2f6d86a-237e-45f2-952c-29ebae89d447" />
  Pengguna diarahkan untuk memasukkan ID proyek yang ingin dihapus, lalu data langsung dihapus dari daftar dan program memberi konfirmasi.
  > <img width="400" alt="image" src="https://github.com/user-attachments/assets/743c96c3-cfbc-42de-ba21-f2d5ab84dab9" />
  Gambar diatas merupakan tampilan semua proyek yang menunjukkan bahwa proyek berhasil dihapus.

- **Menu 5 – Keluar**
  > <img width="550" alt="image" src="https://github.com/user-attachments/assets/e04a5ae1-9523-4c89-bca1-bdebb3fd85dc" />
  Program akan menghentikan perulangan dan menampilkan pesan penutup, kemudian `Scanner` ditutup agar program berakhir dengan baik.

### Langkah 3: Kembali ke menu
> <img width="350" alt="image" src="https://github.com/user-attachments/assets/c229be53-2fe9-4750-8ac2-07dbee9ac59d" />
  Setelah satu aksi selesai, program otomatis kembali menampilkan menu utama. Siklus ini terus berulang sampai pengguna memilih menu "Keluar".

---

## 3. Penerapan Encapsulation dan Inheritance

### Encapsulation 
Encapsulation diterapkan dengan menyembunyikan data di dalam kelas dan hanya mengizinkan akses melalui method tertentu, bukan langsung dari luar.

Semua atribut pada kelas `Proyek` dideklarasikan sebagai `private`, sehingga tidak bisa diakses atau diubah langsung dari kelas lain:
><img width="500" alt="Screenshot 2026-09-24 221304" src="https://github.com/user-attachments/assets/986143df-72d7-4dce-8196-0ec1917bedef" />
Untuk membaca atau mengubah data tersebut, harus melalui method getter dan setter yang bersifat `public`. Setiap setter juga tidak langsung menyimpan data yang diberikan, melainkan memanggil kelas `Validasi` terlebih dahulu untuk memeriksa kevalidannya. Contohnya pada `setNamaProjek()`:
><img width="700" alt="Screenshot 2026-09-24 221612" src="https://github.com/user-attachments/assets/d3e3443f-ccc0-4ffa-b30c-3326f23dd7af" />

### Inheritance
Inheritance diterapkan pada relasi antar kelas model, di mana satu kelas menurunkan atribut dan method-nya ke kelas lain.

`Proyek` berperan sebagai **superclass** yang menyimpan hal-hal yang dimiliki semua jenis proyek: ID, nama, deadline, serta method umum `getJenisProjek()` dan `cetakData()`:
><img width="1000" alt="image" src="https://github.com/user-attachments/assets/a47720ae-d512-4949-917b-0b9aca6497f9" />
`ProyekInternal` dan `ProyekKlien` adalah **subclass** yang meng-*extend* `Proyek`. Keduanya otomatis mendapatkan seluruh atribut dan method milik `Proyek`, lalu menambahkan atribut khas miliknya sendiri. Saat atribut subclass dibuat, konstruktornya memanggil `super(idProjek, namaProjek, deadline)` untuk mengisi data umum lewat kelas induk, sehingga kode tidak perlu ditulis dua kali:
><img width="800" alt="Screenshot 2026-09-24 221916" src="https://github.com/user-attachments/assets/a6d32303-6bdb-4e2d-b2a4-181377402518" />

><img width="800" alt="Screenshot 2026-09-24 222106" src="https://github.com/user-attachments/assets/b75654dd-6741-472e-b917-6135a340b29b" />
Dengan inheritance, penambahan jenis proyek baru menjadi lebih mudah, cukup dengan membuat subclass baru yang meng-*extend* `Proyek`.

## 4. Penerapan Polymorphism dan Abstraction

### a. Abstraction (Abstract Class dan Abstract Method)
Abstraction diterapkan dengan menyembunyikan detail yang berbeda-beda di tiap jenis proyek dan hanya menyisakan "kerangka" yang wajib dipenuhi. Pada program ini, `Proyek` dibuat sebagai **abstract class**, sehingga tidak bisa dibuat objeknya secara langsung (hanya `ProyekInternal` dan `ProyekKlien` yang bisa dibuat). Di dalamnya terdapat dua **abstract method**, yaitu method yang hanya punya deklarasi tanpa isi:
><img width="1000" alt="image" src="https://github.com/user-attachments/assets/eb047322-fd92-4464-8179-743bc0bb136b" />
- `getJenisProjek()` wajib diisi oleh subclass untuk menyebutkan jenis proyeknya ("Internal" atau "Klien").
- `update(nama, deadline, data1, data2)` wajib diisi oleh subclass karena data khusus yang diubah berbeda: `ProyekInternal` mengubah divisi dan tujuan, sedangkan `ProyekKlien` mengubah nama klien dan jenis kebutuhan. `Proyek` sendiri tidak mengenal atribut-atribut tersebut.

### b. Polymorphism (Method Overriding)
Polymorphism artinya method dengan nama yang sama bisa memberikan hasil berbeda tergantung objek yang memanggilnya. Dalam program ini, polymorphism diterapkan lewat **method overriding** pada method `getJenisProjek()`, `cetakData()`, dan `update()` 4 parameter.

Method `cetakData()` didefinisikan secara umum di kelas induk `Proyek`, sedangkan `getJenisProjek()` dan `update()` 4 parameter masih berupa abstract (lihat bagian Abstraction). Ketiganya kemudian ditulis ulang atau di-*override* oleh `ProyekInternal`:
><img width="1000" alt="image" src="https://github.com/user-attachments/assets/54a183ae-16d9-43bd-bd23-0f363d4c4374" />
dan juga oleh `ProyekKlien`, dengan isi yang berbeda sesuai kebutuhannya:
><img width="1000" alt="image" src="https://github.com/user-attachments/assets/6286ccaa-3001-4e6b-8312-65b9b30ff6f1" />

Pada `cetakData()` di kedua subclass, program tetap memanggil `super.cetakData()` terlebih dahulu agar data umum tetap tercetak, lalu menambahkan baris cetak untuk atribut khususnya sendiri, sehingga kode tidak diulang percuma.

### c. Polymorphism (Method Overloading)
Selain overriding, polymorphism juga diterapkan lewat **method overloading**, yaitu beberapa method dengan nama yang sama tetapi jumlah parameter berbeda. Pada kelas `Proyek`, method `update()` memiliki dua versi:
><img width="1000" alt="image" src="https://github.com/user-attachments/assets/14a8335c-665e-4dae-b092-cce888e65187" />
Kedua versi ini punya tujuan berbeda dan saling melengkapi. Versi 2 parameter berisi logika yang sama untuk semua jenis proyek (mengubah nama dan deadline), sehingga ditulis sekali di `Proyek`. Versi 4 parameter menangani data khusus tiap jenis proyek dan wajib diisi oleh subclass, yang di dalamnya memanggil versi 2 parameter (`update(namaBaru, deadlineBaru)`) agar kode pengubah nama dan deadline tidak ditulis ulang.

---

## 5. Penerapan Nilai Tambah

### Interface
Nilai tambah pada program ini adalah penerapan **interface**. Interface `ProyekCrud` berada di package `controller` dan berisi daftar operasi CRUD yang harus tersedia, tanpa menjelaskan cara kerjanya:
><img width="1000" alt="image" src="https://github.com/user-attachments/assets/99c65e5d-cac7-4f3d-9123-637b52b42f73" />
Kelas `ProyekController` kemudian mengimplementasikan interface tersebut dan mengisi cara kerja setiap method-nya (menyimpan, mencari, mengubah, dan menghapus data di dalam `ArrayList`):
><img width="700" alt="image" src="https://github.com/user-attachments/assets/a9eca182-c902-49dc-9587-9c3c24904ac9" />
`ProyekView` memakai interface ini sebagai tipe variabelnya, bukan kelas `ProyekController` secara langsung:
><img width="700" alt="image" src="https://github.com/user-attachments/assets/b3b3962c-7cc8-4abc-a907-8fe8a479e54d" />
Dengan cara ini, View hanya bergantung pada daftar operasi di `ProyekCrud` dan tidak perlu tahu bagaimana data disimpan. Jika suatu saat penyimpanan diganti, misalnya dari `ArrayList` ke file atau database, cukup membuat kelas baru yang mengimplementasikan `ProyekCrud` tanpa mengubah kode di `ProyekView`.
