Naufal Ichsan - 2206082013

High Level Networking: REST API
Saya menggunakan REST API pada fitur saya karena beberapa alasan, diantaranya
1. Kesederhanaan dan Keterbacaan: RESTful API dirancang untuk menjadi sederhana dan mudah dibaca. Dengan menggunakan HTTP protokol yang sudah umum digunakan, pemahaman dan penggunaannya menjadi lebih mudah bagi pengembang dan klien.
2. Skalabilitas: RESTful API memungkinkan skalabilitas yang baik karena tidak ada keadaan (state) yang disimpan di server. Setiap permintaan dari klien berdiri sendiri dan mandiri, sehingga memudahkan dalam menambah atau mengurangi jumlah server saat diperlukan.
3. Pemisahan Antar Server dan Klien: RESTful API memisahkan antara server dan klien, yang berarti perubahan pada sisi server tidak akan mempengaruhi klien (asalkan tidak mengubah struktur endpoint yang ada).
4. Mendukung Berbagai Format Data: RESTful API mendukung berbagai format data seperti JSON, XML, dan lainnya, sehingga memungkinkan integrasi dengan berbagai jenis aplikasi dan platform.
5. Kinerja: RESTful API biasanya memiliki kinerja yang baik karena penggunaan HTTP yang ringan dan tidak memerlukan banyak sumber daya.
6. Cacheability: RESTful API memanfaatkan fitur caching pada HTTP, yang memungkinkan respon yang sama dikirimkan kembali tanpa perlu diproses ulang jika permintaan serupa datang lagi. Ini dapat meningkatkan kinerja dan mengurangi beban server.7
7. Skema Terbuka (Open Schema): RESTful API biasanya menggunakan format data terbuka seperti JSON, yang memudahkan dalam berbagi dan berkolaborasi dengan pengembang lain.
8. Mendukung Metode HTTP: RESTful API menggunakan metode HTTP standar seperti GET, POST, PUT, DELETE, dll., yang membuatnya kompatibel dengan berbagai aplikasi dan infrastruktur yang sudah ada.


## deployment debug
debug deployment1: changing docker password
debug deployment2: changing jdbc url
debug deployment3: changing jdbc url 2
debug deployment4: changing cd.yml for database configuration using secrets
debug deployment5: changing jdbc url 3