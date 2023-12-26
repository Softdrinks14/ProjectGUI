# RSA Calculator
Membantu pengguna untuk mengenkripsi sebuah pesan dan mendekripsikan sebuah pesan yang terenkripsi dengan RSA.

## Deskripsi Proyek
Pengguna dapat memasukkan bilangan prima p, q, m, e, dan n yang sudah dihasilkan oleh proses enkripsi dengan tipe data Big Integer ke dalam textfields. Calculator akan menghitung dekripsi dan output hasil ke layar.

## Fungsi Utama
1. **Enkripsi**
    - Pengguna dapat memasukkan sebuah pesan berupa teks.
    - Calculator akan menghasilkan nilai bilangan prima p dan q dengan tipe data Big Integer.
    - Calculator menghitung enkripsi dan output hasil enkripsi ke sebuah file inputRsa.txt.
2. **Dekripsi**
    - Pengguna dapat memasukkan bilangan prima p, q, m, e, dan n yang sudah dihasilkan oleh proses enkripsi dengan tipe data Big Integer ke dalam textfields.
    - Calculator akan menghitung dekripsi dan output hasil ke layar.

## Antar Muka Pengguna
1. **Halaman Utama**
    - Tampilan sederhana untuk pemilihan opsi enkripsi atau dekripsi.
    - Dan opsi close untuk mengakhiri calculator RSA

![WhatsApp Image 2023-12-25 at 15 41 26_c69bb49c](https://github.com/BimmBB/Demo3/assets/144079933/4dfedb2a-c3d5-49d4-a532-618a01859770)

2. **Enkripsi**
    - Masukkan Karakter yang ingin akan di enkripsi.
    - Form sederhana dengan input pesan berupa textfields maksimal 1020 character.
    - Tombol encrypt untuk proses menghitung enkripsi. 

![WhatsApp Image 2023-12-25 at 15 41 53_fe8c25c3](https://github.com/BimmBB/Demo3/assets/144079933/7070ae2c-d1f6-4195-904b-6670ad221ac1)

3. **Dekripsi**
    - Form sederhana dengan input bilangan m, p, q, e, dan n berupa textfields dengan tipe data 
    Big Integer.
    - Tombol decrypt untuk proses menghitung dekripsi.
    - Textbox untuk memunculkan hasil perhitungan dekripsi pesan.

![WhatsApp Image 2023-12-25 at 15 42 19_192456e6](https://github.com/BimmBB/Demo3/assets/144079933/b1c4c835-8508-44b1-ab88-0d2f69bd1df3)    

## Cara Menggunakan Proyek
1. **Halaman Utama**
    - Saat dijalankan, pengguna akan melihat tampilan utama yang sederhana dengan opsi untuk memilih antara enkripsi atau dekripsi.
    - Klik pada opsi yang diinginkan untuk memulai proses.
2. **Enkripsi**
    - Jika pengguna memilih opsi enkripsi, akan muncul form sederhana.
    - Isi pesan yang ingin dienkripsi pada textfield yang tersedia (maksimal 1020 karakter).
    - Setelah memasukkan pesan, klik tombol "Calculate" untuk memulai proses enkripsi.
    - Hasil enkripsi akan ditampilkan pada antarmuka pengguna dan juga disimpan dalam file inputRsa.txt di direktori yang sama dengan program untuk menjaga keamanan nilai private value.

Catatan : Pastikan untuk memeriksa file inputRsa.txt setelah proses enkripsi untuk melihat hasil enkripsi yang disimpan dalam file tersebut.

3. **Dekripsi**
    - Jika pengguna memilih opsi dekripsi, akan muncul form sederhana untuk memasukkan nilai-nilai yang diperlukan.
    - Isi nilai-nilai seperti bilangan prima p, q, m, e, dan n pada textfield yang tersedia dengan tipe data Big Integer.
    - Setelah memasukkan nilai-nilai, klik tombol "Calculate" untuk memulai proses dekripsi.
    - Hasil perhitungan dekripsi akan muncul pada textbox yang tersedia.

## Persyaratan Teknis
    - Bahasa Pemrograman: Program dikembangkan menggunakan Java 11+.
    - Antarmuka Pengguna: Antarmuka grafis dibangun dengan menggunakan JavaFX.
    - Keamanan: Hasil enkripsi akan ditampilkan pada antarmuka pengguna dan juga disimpan dalam file txt (output.txt) untuk menjaga keamanan nilai private value dari hasil enkripsi.

## Batasan Program
    - Varian Nilai RSA: Program hanya dirancang untuk enkripsi dan dekripsi dasar RSA dengan melibatkan public key p dan q.
    - Fitur Attack: Tidak ada fitur yang dirancang untuk melakukan serangan terhadap pesan RSA guna mencari nilai private value.

Pastikan untuk mengikuti langkah-langkah tersebut dengan cermat dan periksa file output.txt setelah proses enkripsi untuk melihat hasil enkripsi yang disimpan dalam file tersebut.

## Kontribusi

Setiap kontribusi dan bantuan dari anggota tim sangat dihargai. Berikut adalah peran masing-masing anggota:

- **Softdrinks14**: Bertanggung jawab untuk bagian frontend dan desain antarmuka pengguna.
- **radan775**: Mengelola backend dan struktur database.
- **Arabmeme**: Mengelola backend dan struktur database.
- **BimmBB**: Mengelola dokumentasi. 

## Lisensi



## Anggota Tim
Ini adalah repositori untuk proyek Calculator RSA yang dikembangkan oleh tim berikut:

- [Hisyam Bima Ekhsantama](https://github.com/Softdrinks14)
- [Taufiq Ramadhan](https://github.com/radan775)
- [Rahmatullah Akbar Prima](https://github.com/Arabmeme)
- [Bima Bhakti Brawijaya](https://github.com/BimmBB)
