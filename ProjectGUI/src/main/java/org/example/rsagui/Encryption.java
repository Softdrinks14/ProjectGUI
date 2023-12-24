package org.example.rsagui;

import java.math.BigInteger;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Encryption {
    public static void startEncryption(){
        BigInteger e = new BigInteger("65537"); // jangan diubah, ini bilangan prima euler default yang biasa dipakai di RSA
        String text = "Lanjutkanbosku.."; // -> text yang akan dienkripsi maksimal 1024 character

        if (text.length() > 1024) {
            System.err.println("Ukuran text yang bisa dienkripsi adalah 1024 kata");
            return;
        }
        if (text.length() <= 0) {
            System.err.println("Text is null!!!, input dulu...");
            return;
        }

        try {
            encrypt(text, e);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return;
        }
    }

    // methode untuk enkripsi
    private static void encrypt(String text, BigInteger e) throws IOException{
        BigInteger p, q, n, ciphertext, plaintext; // ciphertext adalah nilai yang dihasilkan dari proses enkripsi
        // plaintext adalah nilai pesan yang akan dilakukan enkripsi
        int bitLength;

        plaintext = new BigInteger(text.getBytes()); // ubah string menjadi bytes
        bitLength = plaintext.bitLength();
        System.out.println("bitlength : " + bitLength);

        // membangkitkan nilai prima p dan q dengan acuan bitLength text yang akan dienkripsi
        p = generateLargePrime((bitLength / 2) + 7);
        q = generateLargePrime((bitLength / 2) + 7);

        // sama dengan p * q
        n = p.multiply(q);

        // proses enkripsi RSA -> (pesan * e) mod n // dengan pesan yang sudah diubah menjadi BigInteger
        ciphertext = plaintext.modPow(e, n);

        // output file
        FileWriter file = new FileWriter("output.txt");
        file.write("ciphertext : " + ciphertext);
        file.write("\ne value    : " + e);
        file.write("\nn value    : " + n);
        file.write("\np value    : " + p);
        file.close();
        System.out.println("Text anda berhasil dienkripsi");
    }

    // fungsi untuk generate bilangan Prima dengan random
    private static BigInteger generateLargePrime(int bitLength) {
        Random random = new Random();
        return BigInteger.probablePrime(bitLength, random);
    }
}
