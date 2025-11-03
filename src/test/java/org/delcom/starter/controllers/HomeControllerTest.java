package org.delcom.starter.controllers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

// [PERBAIKAN] Ganti nama class agar cocok dengan nama file Anda (HomeControllerTest)
// [PERBAIKAN] Hapus @SpringBootTest agar tes berjalan cepat (unit test)
class HomeControllerTest {
    
    // Test untuk metode hello()
    @Test
    @DisplayName("Mengembalikan pesan selamat datang yang benar")
    void hello_ShouldReturnWelcomeMessage() throws Exception {
        HomeController controller = new HomeController();
        String result = controller.hello();
        assertEquals("Hay Abdullah, selamat datang di pengembangan aplikasi dengan Spring Boot!", result);
    }

    // Tambahan test untuk metode sayHello dengan parameter nama
    @Test
    @DisplayName("Mengembalikan pesan sapaan yang dipersonalisasi")
    void helloWithName_ShouldReturnPersonalizedGreeting() throws Exception {
        HomeController controller = new HomeController();
        String result = controller.sayHello("Abdullah");
        assertEquals("Hello, Abdullah!", result);
    }

    // -----------------------------------------------------------------
    // SEMUA TES DARI FILE DOSEN
    // -----------------------------------------------------------------

    // Test untuk metode informasiNim()
    @Test
    @DisplayName("Menguji semua kemungkinan NIM valid dan tidak valid")
    void informasiNIM_semua_kemungkinan_nim_valid_dan_tidak_valid() throws Exception {
        // Test NIM Tidak Valid (panjang salah)
        {
            String input = "11S180";
            String expected = "NIM harus 8 karakter";
            HomeController controller = new HomeController();
            String result = controller.informasiNim(input);
            assertEquals(expected, result);
        }

        // Test NIM Valid dengan Prodi Tidak Tersedia
        {
            String input = "ZZS18005";
            String expected = "Program Studi tidak Tersedia";
            HomeController controller = new HomeController();
            String result = controller.informasiNim(input);
            assertEquals(expected, result);
        }

        // Test Sarjan Informatika
        {
            String input = "11S18005";
            String expected = "Inforamsi NIM 11S18005: >> Program Studi: Sarjana Informatika>> Angkatan: 2018>> Urutan: 5";
            HomeController controller = new HomeController();
            String result = controller.informasiNim(input);
            assertEquals(expected, result);
        }

        // Test Sarjana Sistem Informasi
        {
            String input = "12S18005";
            String expected = "Inforamsi NIM 12S18005: >> Program Studi: Sarjana Sistem Informasi>> Angkatan: 2018>> Urutan: 5";
            HomeController controller = new HomeController();
            String result = controller.informasiNim(input);
            assertEquals(expected, result);
        }

        // Test Sarjana Teknik Elektro
        {
            String input = "14S18005";
            String expected = "Inforamsi NIM 14S18005: >> Program Studi: Sarjana Teknik Elektro>> Angkatan: 2018>> Urutan: 5";
            HomeController controller = new HomeController();
            String result = controller.informasiNim(input);
            assertEquals(expected, result);
        }

        // Test Sarjana Manajemen Rekayasa
        {
            String input = "21S18005";
            String expected = "Inforamsi NIM 21S18005: >> Program Studi: Sarjana Manajemen Rekayasa>> Angkatan: 2018>> Urutan: 5";
            HomeController controller = new HomeController();
            String result = controller.informasiNim(input);
            assertEquals(expected, result);
        }

        // Test Sarjana Teknik Metalurgi
        {
            String input = "22S18005";
            String expected = "Inforamsi NIM 22S18005: >> Program Studi: Sarjana Teknik Metalurgi>> Angkatan: 2018>> Urutan: 5";
            HomeController controller = new HomeController();
            String result = controller.informasiNim(input);
            assertEquals(expected, result);
        }

        // Test Sarjana Teknik Bioproses
        {
            String input = "31S18005";
            String expected = "Inforamsi NIM 31S18005: >> Program Studi: Sarjana Teknik Bioproses>> Angkatan: 2018>> Urutan: 5";
            HomeController controller = new HomeController();
            String result = controller.informasiNim(input);
            assertEquals(expected, result);
        }

        // Test Diploma 4 Teknologi Rekasaya Perangkat Lunak
        {
            String input = "11418005";
            String expected = "Inforamsi NIM 11418005: >> Program Studi: Diploma 4 Teknologi Rekasaya Perangkat Lunak>> Angkatan: 2018>> Urutan: 5";
            HomeController controller = new HomeController();
            String result = controller.informasiNim(input);
            assertEquals(expected, result);
        }

        // Test Diploma 3 Teknologi Informasi
        {
            String input = "11318005";
            String expected = "Inforamsi NIM 11318005: >> Program Studi: Diploma 3 Teknologi Informasi>> Angkatan: 2018>> Urutan: 5";
            HomeController controller = new HomeController();
            String result = controller.informasiNim(input);
            assertEquals(expected, result);
        }

        // Test Diploma 3 Teknologi Komputer
        {
            String input = "13318005";
            String expected = "Inforamsi NIM 13318005: >> Program Studi: Diploma 3 Teknologi Komputer>> Angkatan: 2018>> Urutan: 5";
            HomeController controller = new HomeController();
            String result = controller.informasiNim(input);
            assertEquals(expected, result);
        }
    }

    // Test untuk metode perbedaanL()
    @Test
    @DisplayName("Menghitung perbedaan L pada matriks dengan berbagai ukuran")
    void perbedaanL_matriks_berbagai_ukuran() throws Exception {
        // Test matriks 1x1
        {
            String inputBase64 = "MQ0KMTkNCg==";
            String expected = "Nilai L: Tidak Ada<br/>Nilai Kebalikan L: Tidak Ada<br/>Nilai Tengah: 19<br/>Perbedaan: Tidak Ada<br/>Dominan: 19";
            HomeController controller = new HomeController();
            String result = controller.perbedaanL(inputBase64);
            assertEquals(expected, result);
        }

        // Test matriks 2x2
        {
            String inputBase64 = "Mg0KODMgNTUNCjY2IDc1DQo=";
            String expected = "Nilai L: Tidak Ada<br/>Nilai Kebalikan L: Tidak Ada<br/>Nilai Tengah: 279<br/>Perbedaan: Tidak Ada<br/>Dominan: 279";
            HomeController controller = new HomeController();
            String result = controller.perbedaanL(inputBase64);
            assertEquals(expected, result);
        }

        // Test matriks 3x3
        {
            String inputBase64 = "Mw0KMSAyIDMNCjQgNSA2DQo3IDggOQ0K";
            String expected = "Nilai L: 20<br/>Nilai Kebalikan L: 20<br/>Nilai Tengah: 5<br/>Perbedaan: 0<br/>Dominan: 5";
            HomeController controller = new HomeController();
            String result = controller.perbedaanL(inputBase64);
            assertEquals(expected, result);
        }

        // Test Matrik 16x16
        {
            String inputBase64 = "MTYNCjg2IDIgMTkgNjIgOTkgOTQgODggNzEgNjggMzQgMzQgNTEgNzQgNjkgNDkgMjYNCjg4IDg3IDc4IDk5IDQxIDYyIDI3IDI3IDM3IDQ3IDY2IDc3IDMgMTEgNDIgNTcNCjk0IDUxIDg3IDkgMjUgODAgNjMgNDMgMzkgNDUgNCA1IDg0IDUyIDMgODkNCjczIDI3IDM0IDcyIDkyIDk1IDQgNzggODEgNzkgODggNTAgNjQgOTUgMSAyOA0KOTkgNjIgNDYgMjggMTQgOTggMTIgNjcgMTAgNTEgMzMgMTYgNzYgMjMgMTQgMjENCjY5IDQzIDU4IDM1IDE4IDQzIDgyIDggNDUgOTcgMzAgNDAgMTkgOTkgODUgMzINCjYyIDExIDc1IDgzIDYxIDYyIDc3IDEwIDYwIDQ4IDINCA1IDg0IDUyIDMgODkNCjczIDI3IDM0IDcyIDkyIDk1IDQgNzggODEgNzkgODggNTAgNjQgOTUgMSAyOA0KOTkgNjIgNDYgMjggMTQgOTggMTIgNjcgMTAgNTEgMzMgMTYgNzYgMjMgMTQgMjENCjY5IDQzIDU4IDM1IDE4IDQzIDgyIDggNDUgOTcgMzAgNDAgMTkgOTkgODUgMzINCjYyIDExIDc1IDgzIDYxIDYyIDc3IDEwIDYwIDQ4IDI1IDY2IDM3IDY1IDQ2IDkyDQozNyAzMCAzMyAyNCA4MyA3NyA5MSA3NSAxMSA0NyAxIDkxIDEwMCA5OSA0NyA5OA0KNjQgNDQgOSAxMDAgOTkgODcgMzYgMSA3NyA1IDE5IDM3IDE2IDg2IDE0IDM3DQo0NSA2OSA2NiAzMyAzOCA3IDIgNTMgMzQgNjUgNDYgODcgNzIgMjQgMTEgNQ0KNDMgNzggMiA1NSA0NiAxMSAzOCA0NiA3OSA2NyAxMCA3OSAyIDI5IDcwIDkzDQo4MSA0NSA4NiA2MCA1MCA5NiAzMSAzNCA3MiA5MSA4MSAzNCA5MSA0MCA0MSA2OQ0KMzQgMTggOTMgOTQgOTYgMTEgOCA3NyAzMCA3MSA0IDQ1IDY4IDY3IDQ1IDg4DQo0MyA0OSA4OSA1NSA4OSA2OCAzNCA3NSA1NiA1IDI4IDI1IDExIDY4IDM0IDEyDQo1NCA0NiA4MCA1NiAzMiA2NiA3OCA2MSA3MCA1NCA2MyA0OCAyNCA3OCA5OCA3Mg0KNDAgMTcgNjUgODUgNjYgMjYgOSAzNCA4MiAxNSA3MyAyMiA3OCA3OCA1OSA0OA0K";
            String expected = "Nilai L: 1721<br/>Nilai Kebalikan L: 1681<br/>Nilai Tengah: 164<br/>Perbedaan: 40<br/>Dominan: 1721";
            HomeController controller = new HomeController();
            String result = controller.perbedaanL(inputBase64);
            assertEquals(expected, result);
        }

        // [TES 100% - 1] Tes untuk input 'perbedaanL' yang tidak valid
        {
            String inputBase64 = "SW5wdXQgdGlkYWsgdmFsaWQ="; // Base64 untuk "Input tidak valid"
            String expected = "Input tidak valid.";
            HomeController controller = new HomeController();
            String result = controller.perbedaanL(inputBase64);
            assertEquals(expected, result);
        }
    }

    // Test untuk metode palingTer()
    @Test
    @DisplayName("Memperolah informasi paling ter dari suatu nilai")
    void palingTer_memperoleh_informasi_paling_ter_dari_suatu_nilai() throws Exception {
        // Pengujian Counter = 0
        {
            String inputBase64 = "LS0tDQo=";
            String expected = "Informasi tidak tersedia";
            HomeController controller = new HomeController();
            String result = controller.palingTer(inputBase64);
            assertEquals(expected, result);
        }

        // Pengujian 1
        {
            String inputBase64 = "MQ0KMQ0KMw0KMw0KMg0KMg0KMg0KNA0KNQ0KMQ0KLS0tDQo=";
            // [PERBAIKAN TYPO] "3 * 2" dan "1 * 3"
            String expected = "Tertinggi: 5<br/>Terendah: 1<br/>Terbanyak: 2 (3x)<br/>Tersedikit: 4 (1x)<br/>Jumlah Tertinggi: 3 * 2 = 6<br/>Jumlah Terendah: 1 * 3 = 3";
            HomeController controller = new HomeController();
            String result = controller.palingTer(inputBase64);
            assertEquals(expected, result);
        }

        // Pengujian 2
        {
            String inputBase64 = "NTgNCjMxDQo4NA0KMTINCjg2DQo2MA0KODINCjQ5DQo4Mw0KNjQNCjc3DQo3DQo2OA0KOTENCjMNCjQxDQo1MQ0KNTMNCjUyDQo3NA0KNzINCjc0DQoxMA0KMzgNCjUwDQo1MQ0KOQ0KNTYNCjU2DQoyNQ0KODQNCjYzDQo5OA0KODQNCjQ4DQo5NQ0KNDYNCjMzDQo3OA0KNDUNCjU1DQoxMA0KNjANCjg4DQoxMA0KNzYNCjgxDQo1NQ0KNDYNCjU4DQozOA0KNTcNCjkyDQo2Nw0KNDENCjQ3DQozMA0KMg0KNjANCjQwDQozNg0KNTMNCjcwDQozMw0KNjYNCjYyDQo1OA0KMTUNCjkyDQo3Mw0KMTcNCjM3DQo2Ng0KMTINCjI5DQoxMDANCjUzDQo2Ng0KMzANCjEyDQozNA0KNg0KMjQNCjg5DQo2NA0KMTENCjgwDQozDQo5MA0KOA0KNjcNCjY1DQoyMg0KNTINCjI2DQozMg0KNjINCjU4DQo0NA0KOTQNCjE4DQo1OA0KMTANCjUNCjE3DQozNg0KMTcNCjYzDQo2OQ0KNzYNCjUyDQo1DQo5NA0KODINCjgNCjg1DQo4NQ0KNDcNCjQzDQozOA0KNzcNCjQzDQo0MQ0KNzMNCjgxDQozNg0KMjYNCjE3DQo0NQ0KOQ0KNDANCjczDQo1OQ0KMw0KNTgNCjYzDQoyNg0KMjkNCjE3DQo2OA0KOTQNCjM5DQo1DQo1MA0KMjQNCjQ0DQozNg0KMjQNCjUNCjkyDQo4NQ0KNTQNCjI2DQo5Mg0KNTINCjI1DQoyMw0KNDkNCjQ5DQo0Nw0KMjYNCjQ1DQo2DQo0OA0KNTkNCjk5DQozMA0KMjENCjEyDQoyMA0KNjENCjU2DQo4OA0KNDENCjQ4DQo1Nw0KNzQNCjY0DQozNA0KNjENCjEwDQo2DQo0OQ0KNjYNCjM1DQo1DQoyNg0KODUNCjc1DQo0OQ0KODkNCjY4DQoxMQ0KMTcNCjUNCjg0DQoxMQ0KNjINCjkzDQoyNw0KODkNCjg2DQo0NA0KNA0KOTMNCjI4DQo2Nw0KNDINCjY2DQoyDQo3Mg0KMTENCjEwDQo0NQ0KNTANCjMyDQoxOA0KMzANCjk1DQoyNQ0KMjINCjI2DQoxMDANCjI3DQo3Mw0KNDcNCjUNCjIwDQo4OA0KODkNCjcNCjk3DQoyOA0KMjUNCjQ0DQo3Nw0KMTENCjQ2DQo5Ng0KOTMNCjY3DQo1MQ0KNDkNCjY1DQo3OQ0KODkNCjg5DQotLS0NCg==";
            // [PERBAIKAN TYPO] "Tersedikit: 35 (1x)"
            String expected = "Tertinggi: 100<br/>Terendah: 2<br/>Terbanyak: 26 (7x)<br/>Tersedikit: 35 (1x)<br/>Jumlah Tertinggi: 89 * 6 = 534<br/>Jumlah Terendah: 2 * 2 = 4";
            HomeController controller = new HomeController();
            String result = controller.palingTer(inputBase64);
            assertEquals(expected, result);
        }

        // [TES 100% - 2] Tes 'palingTer' (semua frekuensi sama)
        @Test
        @DisplayName("Menguji 'palingTer' (semua frekuensi sama)")
        void palingTer_ShouldHandleEqualFrequencies() {
            HomeController controller = new HomeController();
            // Input: 1 2 3 --- (Semua frekuensi 1)
            String strBase64 = "MQ0KMg0KMyANCi0tLQ0K";
            String expected = "Tertinggi: 3<br/>Terendah: 1<br/>Terbanyak: 1 (1x)<br/>Tersedikit: 1 (1x)<br/>Jumlah Tertinggi: 3 * 1 = 3<br/>Jumlah Terendah: 1 * 1 = 1";
            
            String result = controller.palingTer(strBase64);
            assertEquals(expected, result);
        }
    }

    // -----------------------------------------------------------------
    // [TAMBAHAN] TES UNTUK 'perolehanNilai' (AGAR JaCoCo 100%)
    // -----------------------------------------------------------------

    @Test
    @DisplayName("Menguji Perolehan Nilai (Grade A)")
    void nilai_ShouldReturnGradeA() {
        HomeController controller = new HomeController();
        // Nilai Akhir: 83.00 (>= 79.5)
        String strBase64 = "MA0KMzUNCjENCjE2DQoyMg0KMjYNCFR8MTAwfDEwMA0KVUFTfDEwMHwxMDANClVUU3wxMDB8MTAwDQotLS0NCg==";
        String result = controller.perolehanNilai(strBase64);
        assertTrue(result.contains(">> Nilai Akhir: 83.00<br/>") && result.contains(">> Grade: A"));
    }

    @Test
    @DisplayName("Menguji Perolehan Nilai (Grade AB)")
    void nilai_ShouldReturnGradeAB() {
        HomeController controller = new HomeController();
        // Nilai Akhir: 75.30 (>= 72)
        String strBase64 = "MA0KMzUNCjENCjE2DQoyMg0KMjYNCFR8MTAwfDEwMA0KVUFTfDEwMHwxMDANClVUU3wxMDB8NjUNCi0tLQ0K";
        String result = controller.perolehanNilai(strBase64);
        assertTrue(result.contains(">> Nilai Akhir: 75.30<br/>") && result.contains(">> Grade: AB"));
    }

    @Test
    @DisplayName("Menguji Perolehan Nilai (Grade B)")
    void nilai_ShouldReturnGradeB() {
        HomeController controller = new HomeController();
        // Nilai Akhir: 70.90 (>= 64.5)
        String strBase64 = "MA0KMzUNCjENCjE2DQoyMg0KMjYNCFR8MTAwfDEwMA0KVUFTfDEwMHwxMDANClVUU3wxMDB8NDUNCi0tLQ0K";
        String result = controller.perolehanNilai(strBase64);
        assertTrue(result.contains(">> Nilai Akhir: 70.90<br/>") && result.contains(">> Grade: B"));
    }

    @Test
    @DisplayName("Menguji Perolehan Nilai (Grade BC)")
    void nilai_ShouldReturnGradeBC() {
        HomeController controller = new HomeController();
        // Nilai Akhir: 61.00 (>= 57)
        String strBase64 = "MA0KMzUNCjENCjE2DQoyMg0KMjYNCFR8MTAwfDEwMA0KVUFTfDEwMHwxMDANClVUU3wxMDB8MA0KLS0tDQo=";
        String result = controller.perolehanNilai(strBase64);
        assertTrue(result.contains(">> Nilai Akhir: 61.00<br/>") && result.contains(">> Grade: BC"));
    }

    @Test
    @DisplayName("Menguji Perolehan Nilai (Grade C)")
    void nilai_ShouldReturnGradeC() {
        HomeController controller = new HomeController();
        // Nilai Akhir: 50.30 (>= 49.5)
        String strBase64 = "MA0KMzUNCjENCjE2DQoyMg0KMjYNCFR8MTAwfDEwMA0KVUFTfDEwMHwyNQ0KVVRTfDEwMHw0MA0KLS0tDQo=";
        String result = controller.perolehanNilai(strBase64);
        assertTrue(result.contains(">> Nilai Akhir: 50.30<br/>") && result.contains(">> Grade: C"));
    }

    @Test
    @DisplayName("Menguji Perolehan Nilai (Grade D)")
    void nilai_ShouldReturnGradeD() {
        HomeController controller = new HomeController();
        // Nilai Akhir: 35.00 (>= 34)
        String strBase64 = "MA0KMzUNCjENCjE2DQoyMg0KMjYNCFR8MTAwfDEwMA0KLS0tDQo=";
        String result = controller.perolehanNilai(strBase64);
        assertTrue(result.contains(">> Nilai Akhir: 35.00<br/>") && result.contains(">> Grade: D"));
    }
    
    @Test
    @DisplayName("Menguji Perolehan Nilai (Grade E)")
    void nilai_ShouldReturnGradeE() {
        HomeController controller = new HomeController();
        // Nilai Akhir: 29.93 (< 34)
        String strBase64 = "MA0KMzUNCjENCjE2DQoyMg0KMjYNCFR8OTB8MjENClVBU3w5Mnw4Mg0KVUFTfDYzfDE1DQpUfDEwfDUNClVBU3w4OXw3NA0KVHw5NXwzNQ0KUEF8NzV8NDUNClBBfDkwfDc3DQpQQXw4NnwxNA0KVVRTfDIxfDANCkt8NTB8NDQNCi0tLQ0K";
        String result = controller.perolehanNilai(strBase64);
        assertTrue(result.contains(">> Nilai Akhir: 29.93<br/>") && result.contains(">> Grade: E"));
    }

    // [TES 100% - 1] Tes 'perolehanNilai' (input bobot tidak lengkap)
    @Test
    @DisplayName("Menguji 'perolehanNilai' (Bobot tidak lengkap)")
    void nilai_ShouldHandleIncompleteWeights() {
        HomeController controller = new HomeController();
        // Hanya 3 bobot, lalu "---"
        String strBase64 = "MA0KMzUNCjENCi0tLQ0K";
        String result = controller.perolehanNilai(strBase64);
        // Tes harus lulus tanpa error
        assertNotNull(result);
        assertTrue(result.contains(">> Nilai Akhir: 0.00<br/>"));
    }

    // [TES 100% - 2] Tes 'perolehanNilai' (input bobot tapi tidak ada nilai)
    @Test
    @DisplayName("Menguji 'perolehanNilai' (Bobot ada, nilai kosong)")
    void nilai_ShouldHandleEmptyScores() {
        HomeController controller = new HomeController();
        // Bobot lengkap, lalu "---"
        String strBase64 = "MA0KMzUNCjENCjE2DQoyMg0KMjYNCi0tLQ0K";
        String result = controller.perolehanNilai(strBase64);
        assertTrue(result.contains(">> Nilai Akhir: 0.00<br/>") && result.contains(">> Grade: E"));
    }
    
    // [TES 100% - 3] Tes 'perolehanNilai' (Kunci Komponen Salah)
    @Test
    @DisplayName("Menguji 'perolehanNilai' (Kunci Komponen Salah)")
    void nilai_ShouldHandleInvalidComponentKey() {
        HomeController controller = new HomeController();
        // Data Grade E LENGKAP + "INVALID|100|100"
        String strBase64 = "MA0KMzUNCjENCjE2DQoyMg0KMjYNCFR8OTB8MjENClVBU3w5Mnw4Mg0KVUFTfDYzfDE1DQpUfDEwfDUNClVBU3w4OXw3NA0KVHw5NXwzNQ0KUEF8NzV8NDUNClBBfDkwfDc3DQpQQXw4NnwxNA0KVVRTfDIxfDANCkt8NTB8NDQNCklOVkFMSUR8MTAwfDEwMA0KLS0tDQo=";
        String result = controller.perolehanNilai(strBase64);
        // Hasil harus sama seolah-olah baris "INVALID" tidak ada (tetap 29.93)
        assertTrue(result.contains(">> Nilai Akhir: 29.93<br/>"));
    }
}
