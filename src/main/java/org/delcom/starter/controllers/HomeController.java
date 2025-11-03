package org.delcom.starter.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

@RestController
public class HomeController {

    // --- Dari Latihan Praktikum (3.1) ---
    @GetMapping("/")
    public String hello() {
        return "Hay Abdullah, selamat datang di pengembangan aplikasi dengan Spring Boot!";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // ---
    // MIGRASI DARI PRAKTIKUM 1 (Aktivitas 4.1)
    // ---

    // 1. Migrasi dari StudiKasus1.java (Informasi NIM)
    @GetMapping("/nim/{nim}")
    public String informasiNim(@PathVariable String nim) {
        // [PERBAIKAN] Logika Error Handling dari file Tes baru
        if (nim.length() != 8) {
            return "NIM harus 8 karakter";
        }

        String prefix, angkatan, urut;

        if (nim.startsWith("114") || nim.startsWith("113") || nim.startsWith("133")) {
            prefix = nim.substring(0, 3);
            angkatan = nim.substring(3, 5);
            urut = nim.substring(5);
        } else {
            prefix = nim.substring(0, 3);
            angkatan = nim.substring(3, 5);
            urut = nim.substring(5);
        }

        String namaProdi;
        switch (prefix) {
            case "11S": namaProdi = "Sarjana Informatika"; break;
            case "12S": namaProdi = "Sarjana Sistem Informasi"; break;
            case "14S": namaProdi = "Sarjana Teknik Elektro"; break;
            case "21S": namaProdi = "Sarjana Manajemen Rekayasa"; break;
            case "22S": namaProdi = "Sarjana Teknik Metalurgi"; break;
            case "31S": namaProdi = "Sarjana Teknik Bioproses"; break;
            case "114": namaProdi = "Diploma 4 Teknologi Rekasaya Perangkat Lunak"; break;
            case "113": namaProdi = "Diploma 3 Teknologi Informasi"; break;
            case "133": namaProdi = "Diploma 3 Teknologi Komputer"; break;
            default:
                // [PERBAIKAN] Logika Error Handling dari file Tes baru
                return "Program Studi tidak Tersedia";
        }
        
        // [PERBAIKAN] Format output disesuaikan AGAR SAMA PERSIS dengan tes baru
        return String.format("Inforamsi NIM %s: >> Program Studi: %s>> Angkatan: 20%s>> Urutan: %d",
                nim, namaProdi, angkatan, Integer.parseInt(urut));
    }

    // Kelas helper dari StudiKasus2.java
    private static class Komponen {
        int skor = 0;
        int maksimum = 0;
        double bobot;
        Komponen(double bobot) { this.bobot = bobot; }
    }

    // 2. Migrasi dari StudiKasus2.java (Perolehan Nilai)
    @GetMapping("/nilai/{strBase64}")
    public String perolehanNilai(@PathVariable String strBase64) {
        byte[] decodedBytes = Base64.getDecoder().decode(strBase64);
        String plainTextInput = new String(decodedBytes);
        
        Scanner sc = new Scanner(plainTextInput);
        sc.useLocale(Locale.US);

        String[] namaKomponen = {"PA", "T", "K", "P", "UTS", "UAS"};
        Map<String, Komponen> komponenMap = new LinkedHashMap<>();

        // [PERBAIKAN] Menutupi cabang 'else' dari hasNextDouble
        if (sc.hasNextDouble()) {
            for (String nama : namaKomponen) {
                if (sc.hasNextDouble()) {
                    double bobot = sc.nextDouble();
                    komponenMap.put(nama, new Komponen(bobot));
                }
            }
        }

        // [PERBAIKAN] Hanya buang newline jika ada
        if (sc.hasNextLine()) {
            sc.nextLine(); 
        }

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.equals("---")) break;
            if (line.isEmpty()) continue; // Menghindari error

            String[] parts = line.split("\\|");
            
            // [PERBAIKAN] Menutupi cabang 'else' dari containsKey
            if (parts.length == 3 && komponenMap.containsKey(parts[0])) {
                String sim = parts[0];
                int max = Integer.parseInt(parts[1]);
                int score = Integer.parseInt(parts[2]);
                
                Komponen k = komponenMap.get(sim);
                k.skor += score;
                k.maksimum += max;
            }
            // Jika keys tidak ada atau format salah, baris diabaikan (mencapai 100% coverage)
        }
        sc.close();

        double nilaiAkhir = 0.0;
        Map<String, Integer> persentaseMap = new LinkedHashMap<>();
        Map<String, Double> kontribusiMap = new LinkedHashMap<>();

        for (String nama : namaKomponen) {
            Komponen k = komponenMap.get(nama);

            // [PERBAIKAN] Menutupi cabang 'else' dari (k.maksimum > 0)
            int persentase = 0;
            if (k != null && k.maksimum > 0) {
                persentase = (int)Math.floor(k.skor * 100.0 / k.maksimum);
            }
            persentaseMap.put(nama, persentase);

            double kontribusi = 0.0;
            if (k != null) {
                kontribusi = (persentase / 100.0) * k.bobot;
            }
            kontribusiMap.put(nama, kontribusi);
            nilaiAkhir += kontribusi;
        }

        String grade;
        if (nilaiAkhir >= 79.5) grade = "A";
        else if (nilaiAkhir >= 72) grade = "AB";
        else if (nilaiAkhir >= 64.5) grade = "B";
        else if (nilaiAkhir >= 57) grade = "BC";
        else if (nilaiAkhir >= 49.5) grade = "C";
        else if (nilaiAkhir >= 34) grade = "D";
        else grade = "E";

        // [PERBAIKAN] Menggunakan format <br/> agar LULUS tes baru
        StringBuilder output = new StringBuilder();
        output.append(String.format(Locale.US, ">> Partisipatif: %d/100 (%.2f/%.0f)<br/>",
                persentaseMap.get("PA"), kontribusiMap.get("PA"), komponenMap.get("PA").bobot));
        output.append(String.format(Locale.US, ">> Tugas: %d/100 (%.2f/%.0f)<br/>",
                persentaseMap.get("T"), kontribusiMap.get("T"), komponenMap.get("T").bobot));
        output.append(String.format(Locale.US, ">> Kuis: %d/100 (%.2f/%.0f)<br/>",
                persentaseMap.get("K"), kontribusiMap.get("K"), komponenMap.get("K").bobot));
        output.append(String.format(Locale.US, ">> Proyek: %d/100 (%.2f/%.0f)<br/>",
                persentaseMap.get("P"), kontribusiMap.get("P"), komponenMap.get("P").bobot));
        output.append(String.format(Locale.US, ">> UTS: %d/100 (%.2f/%.0f)<br/>",
                persentaseMap.get("UTS"), kontribusiMap.get("UTS"), komponenMap.get("UTS").bobot));
        output.append(String.format(Locale.US, ">> UAS: %d/100 (%.2f/%.0f)<br/>",
                persentaseMap.get("UAS"), kontribusiMap.get("UAS"), komponenMap.get("UAS").bobot));
        output.append("<br/>");
        output.append(String.format(Locale.US, ">> Nilai Akhir: %.2f<br/>", nilaiAkhir));
        output.append(String.format(Locale.US, ">> Grade: %s", grade));

        return output.toString();
    }

    // 3. Migrasi dari StudiKasus3.java (Perbedaan L)
    @GetMapping("/l-shape/{strBase64}")
    public String perbedaanL(@PathVariable String strBase64) {
        byte[] decodedBytes = Base64.getDecoder().decode(strBase64);
        String plainTextInput = new String(decodedBytes);
        
        Scanner inputHandler = new Scanner(plainTextInput);
        StringBuilder output = new StringBuilder();

        // [PERBAIKAN] Menutupi cabang 'else' dari hasNextInt
        if (inputHandler.hasNextInt()) {
            int matrixDim = inputHandler.nextInt();
            long[][] matrixData = new long[matrixDim][matrixDim];
            
            for (int row = 0; row < matrixDim; row++) {
                for (int col = 0; col < matrixDim; col++) {
                    matrixData[row][col] = inputHandler.nextLong();
                }
            }
            
            long centerValue;
            if (matrixDim % 2 == 1) {
                int middleIndex = matrixDim / 2;
                centerValue = matrixData[middleIndex][middleIndex];
            } else {
                int middle1 = matrixDim / 2 - 1;
                int middle2 = matrixDim / 2;
                centerValue = matrixData[middle1][middle1] + matrixData[middle1][middle2] + matrixData[middle2][middle1] + matrixData[middle2][middle2];
            }
            
            // [PERBAIKAN] Menggunakan format <br/> agar LULUS tes baru
            if (matrixDim <= 2) {
                output.append("Nilai L: Tidak Ada<br/>");
                output.append("Nilai Kebalikan L: Tidak Ada<br/>");
                output.append("Nilai Tengah: ").append(centerValue).append("<br/>");
                output.append("Perbedaan: Tidak Ada<br/>");
                output.append("Dominan: ").append(centerValue);
            } else {
                long lValue = 0L;
                for (int i = 0; i < matrixDim; i++) lValue += matrixData[i][0];
                for (int j = 1; j <= matrixDim - 2; j++) lValue += matrixData[matrixDim - 1][j];

                long reverseLValue = 0L;
                for (int j = 1; j <= matrixDim - 1; j++) reverseLValue += matrixData[0][j];
                for (int i = 1; i <= matrixDim - 1; i++) reverseLValue += matrixData[i][matrixDim - 1];

                long difference = Math.abs(lValue - reverseLValue);
                long dominantValue = (difference == 0L) ? centerValue : Math.max(lValue, reverseLValue);

                output.append("Nilai L: ").append(lValue).append("<br/>");
                output.append("Nilai Kebalikan L: ").append(reverseLValue).append("<br/>");
                output.append("Nilai Tengah: ").append(centerValue).append("<br/>");
                output.append("Perbedaan: ").append(difference).append("<br/>");
                output.append("Dominan: ").append(dominantValue);
            }
        } else {
            output.append("Input tidak valid.");
        }
        
        inputHandler.close();
        return output.toString().trim(); // [PERBAIKAN] trim()
    }

    // 4. Migrasi dari StudiKasus4.java (Paling Ter)
    @GetMapping("/paling-ter/{strBase64}")
    public String palingTer(@PathVariable String strBase64) {
        byte[] decodedBytes = Base64.getDecoder().decode(strBase64);
        String plainTextInput = new String(decodedBytes);

        Scanner sc = new Scanner(plainTextInput);
        LinkedHashMap<Integer, Integer> freqMap = new LinkedHashMap<>();

        int tertinggi = Integer.MIN_VALUE;
        int terendah = Integer.MAX_VALUE;
        int terbanyak = 0, freqTerbanyak = 0;
        int tersedikit = 0, freqTersedikit = Integer.MAX_VALUE;
        int angkaJumlahTertinggi = 0, freqJumlahTertinggi = 0;
        int nilaiJumlahTertinggi = Integer.MIN_VALUE;
        int counter = 0;

        while (sc.hasNextInt()) {
            counter++;
            int num = sc.nextInt();
            if (num > tertinggi) tertinggi = num;
            if (num < terendah) terendah = num;

            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            int freq = freqMap.get(num);

            if (freq > freqTerbanyak) {
                terbanyak = num;
                freqTerbanyak = freq;
            }

            int total = num * freq;
            if (total > nilaiJumlahTertinggi) {
                nilaiJumlahTertinggi = total;
                angkaJumlahTertinggi = num;
                freqJumlahTertinggi = freq;
            }
        }
        sc.close();

        // [PERBAIKAN] Cek input kosong
        if (counter == 0) {
            return "Informasi tidak tersedia";
        }
        
        // [PERBAIKAN] Logika 'tersedikit' yang benar (2-pass)
        // Pass 1: Cari frekuensi minimum
        for (Integer freq : freqMap.values()) {
            if (freq < freqTersedikit) {
                freqTersedikit = freq;
            }
        }
        
        // Pass 2: Cari angka PERTAMA yang frekuensinya = minimum
        // (Ini akan menutupi cabang 'else' dari 'if (entry.getValue() == ...)')
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == freqTersedikit) {
                tersedikit = entry.getKey(); // Ambil yang pertama
                break; // dan berhenti
            }
        }

        int jumlahTerendah = terendah * freqMap.get(terendah);
        
        // [PERBAIKAN] Menggunakan format <br/> agar LULUS tes baru
        StringBuilder output = new StringBuilder();
        output.append("Tertinggi: ").append(tertinggi).append("<br/>");
        output.append("Terendah: ").append(terendah).append("<br/>");
        output.append("Terbanyak: ").append(terbanyak).append(" (").append(freqTerbanyak).append("x)<br/>");
        output.append("Tersedikit: ").append(tersedikit).append(" (").append(freqMap.get(tersedikit)).append("x)<br/>");
        output.append("Jumlah Tertinggi: ").append(angkaJumlahTertinggi).append(" * ").append(freqJumlahTertinggi).append(" = ").append(nilaiJumlahTertinggi).append("<br/>");
        output.append("Jumlah Terendah: ").append(terendah).append(" * ").append(freqMap.get(terendah)).append(" = ").append(jumlahTerendah);

        return output.toString().trim(); // [PERBAIKAN] trim()
    }
}
