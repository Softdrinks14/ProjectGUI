package org.example.rsagui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.FileWriter;
import java.math.BigInteger;

public class Decryption {
    public static void startDecryption(String pValue, String mValue, String eValue, String nValue){
        if(pValue.isEmpty() || mValue.isEmpty() || eValue.isEmpty() || nValue.isEmpty()){
            showEmptyField();
            return;
        }

        BigInteger e;
        BigInteger ciphertext;
        BigInteger n;
        BigInteger p;
        try {
            e = new BigInteger(eValue);
            ciphertext = new BigInteger(mValue);
            n = new BigInteger(nValue);
            p = new BigInteger(pValue);

            decrypt(e, ciphertext, n, p);
        }catch (Exception error){
            showWrongDataType();
        }
    }

    private static void decrypt(BigInteger e, BigInteger ciphertext, BigInteger n, BigInteger p){
        BigInteger plaintext, phi, d, q; // inisialisasi variabel untuk phi, d, dan q
        String result;
        final BigInteger ONE = BigInteger.ONE;

        try {
            q = n.divide(p); // mencari kunci private q dengan n / p
            phi = p.subtract(ONE).multiply(q.subtract(ONE)); // menghitung kunci private phi dengan rumus phi = (p - 1) * (q - 1)
            d = e.modInverse(phi); // menghitung kunci private d dengan rumus d = e ^ -1 mod phi
            plaintext = ciphertext.modPow(d, n); // menghitung plaintext dengan plaintext = c ^ d mod n
            result = new String(plaintext.toByteArray()); // mengubah BigInteger menjadi byte, lalu menjadi string text kembali
            showResult(result);

            FileWriter file = new FileWriter("dekripsiRsa.txt");
            file.write("Hasil enkripsi : \n" + result);
            file.close();
        } catch (Exception err) {
            showUnknownException(err.getMessage());
        }
    }

    private static void showEmptyField(){
        String contentAlert = "Tidak boleh ada yang kosong!";
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Null data");
        alert.setContentText(contentAlert);
        alert.showAndWait();
    }
    private static void showWrongDataType(){
        String contentAlert = "Input hanya bisa berisi bilangan!!";
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Data Error");
        alert.setContentText(contentAlert);
        alert.showAndWait();
    }

    private static void showUnknownException(String result){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Unknown Error");
        alert.setContentText(result);
        alert.showAndWait();
    }
    private static void showResult(String result){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType buttonTypeOk = new ButtonType("OK");
        alert.setTitle("Hasil Enkripsi");
        alert.setHeaderText("cek juga di \"dekripsiRsa.txt\"");
        alert.setContentText(result);
        alert.getButtonTypes().setAll(buttonTypeOk);
        alert.showAndWait();
    }
}
