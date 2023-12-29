package org.example.rsagui;

import javafx.scene.control.Alert;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Encryption {
    public static void startEncryption() throws IOException {

        File inputText = new File("inputRsa.txt");
        BigInteger e = new BigInteger("65537"); // jangan diubah, ini bilangan prima euler default yang biasa dipakai di RSA

        // Konversi List<Byte> ke byte[]
        List<Byte> byteList = readFileByte(inputText);
        if (byteList.size() <= 0){
            showFileIsNull();
            return;
        }

        if (byteList.size() > 1020){
            showContentToBig();
            return;
        }

        byte[] byteArray = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            byteArray[i] = byteList.get(i);
        }

        try {
            encrypt(byteArray, e);
        } catch (Exception error) {
            showException(error.getMessage());
            return;
        }
    }

    // methode untuk enkripsi
    private static void encrypt(byte[] text, BigInteger e) throws IOException{
        BigInteger p, q, n, ciphertext, plaintext; // ciphertext adalah nilai yang dihasilkan dari proses enkripsi
        // plaintext adalah nilai pesan yang akan dilakukan enkripsi
        int bitLength;

        plaintext = new BigInteger(text); // ubah string menjadi bytes
        bitLength = plaintext.bitLength();

        // membangkitkan nilai prima p dan q dengan acuan bitLength text yang akan dienkripsi
        p = generateLargePrime((bitLength / 2) + 7);
        q = generateLargePrime((bitLength / 2) + 7);

        // sama dengan p * q
        n = p.multiply(q);

        // proses enkripsi RSA -> (pesan * e) mod n // dengan pesan yang sudah diubah menjadi BigInteger
        ciphertext = plaintext.modPow(e, n);

        // output file
        FileWriter file = new FileWriter("outputRsa.txt");
        file.write("\np value    : " + p);
        file.write("\nciphertext (m) : " + ciphertext);
        file.write("\ne value    : " + e);
        file.write("\nn value    : " + n);
        file.close();
        showSuccessEncryption();
    }

    // fungsi untuk generate bilangan Prima dengan random
    private static BigInteger generateLargePrime(int bitLength) {
        Random random = new Random();
        return BigInteger.probablePrime(bitLength, random);
    }
    private static void fileNotFound(){
        String contentAlert = "File \"inputRsa.txt\" Tidak ditemukan\nHarap ikuti instruksinya!";
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("No File Error");
        alert.setContentText(contentAlert);
        alert.showAndWait();
    }

    private static void showSuccessEncryption(){
        String contentInformation = "Enkripsi Berhasil\nSilahkan cek \"outputRsa.txt\"";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sukses");
        alert.setContentText(contentInformation);
        alert.showAndWait();
    }

    private static void showException(String error){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Stupid Error");
        alert.setContentText(error);
        alert.showAndWait();
    }

    private static void showFileIsNull(){
        String contentAlert = "Isi File kosong. Enkripsi tidak dapat diproses";
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("No File Content");
        alert.setContentText(contentAlert);
        alert.showAndWait();
    }

    private static void showContentToBig(){
        String contentAlert = "Isi File terlalu besar.\nMaksimal 1020 karakter";
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Content to big");
        alert.setContentText(contentAlert);
        alert.showAndWait();
    }

    private static List<Byte> readFileByte(File inputText){
        List<Byte> byteList = new ArrayList<>();
        if (inputText.isFile()){
            try (FileInputStream fis = new FileInputStream(inputText)) {

                int byteRead;
                while ((byteRead = fis.read()) != -1) {
                    byteList.add((byte) byteRead);
                }
                // Sekarang, byteArray berisi seluruh konten file dalam bentuk byte array
            } catch (IOException err) {
                showException(err.getMessage());
            }

        }else {
            fileNotFound();
        }
        return byteList;
    }
}
