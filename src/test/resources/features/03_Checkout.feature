@Checkout
Feature: Proses Checkout dan Validasi Informasi Pengguna di Portal SauceDemo
Sebagai pengguna yang telah menambahkan produk ke keranjang belanja
Saya ingin melengkapi informasi pengiriman saya
Agar saya dapat melanjutkan ke alur konfirmasi pembayaran dan menyelesaikan pesanan

Background:
    Given Pengguna membuka portal login "https://www.saucedemo.com/"
    When Pengguna mengisi username "standard_user"
    And Pengguna mengisi password "secret_sauce"
    And Pengguna mengklik tombol Login
    Then Pengguna berhasil diarahkan ke halaman katalog dengan judul "Products"
    When Pengguna memilih produk "Sauce Labs Backpack" untuk ditambahkan ke keranjang
    And Pengguna membuka halaman keranjang belanja
    And Pengguna mengklik tombol Checkout

    @Smoke @Positive
    Scenario: Checkout Berhasil dengan Mengisi Seluruh Informasi Pengiriman Secara Valid
    When Pengguna mengisi First Name "Cherish"
    And Pengguna mengisi Last Name "Mimir"
    And Pengguna mengisi Postal Code "12345"
    And Pengguna mengklik tombol Continue
    Then Pengguna berhasil diarahkan ke halaman checkout 

    @Regression @Negative
    Scenario: Checkout Gagal saat Postal Code Dikosongkan
    When Pengguna mengisi First Name "Cherish"
    And Pengguna mengisi Last Name "Mimir"
    And Pengguna mengosongkan Postal Code
    And Pengguna mengklik tombol Continue
    Then Sistem menampilkan pesan kesalahan checkout "Error: Postal Code is required"