/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas;

/**
 *
 * @author WhiteHat
 */
public class cerita extends Thread {

    static int dokter, suster, pasien;

    public void run() {

    }

    public static void main(String[] args) {
        for (pasien = 0; pasien < 10; pasien++) {
            System.out.println("Pasien ke " + (pasien + 1) + " datang dan di periksa oleh Dokter");
        }

        for (pasien = 0; pasien < 10; pasien++) {
            if ((pasien +1) % 5 == 0) {
                System.out.println("");
                System.out.println("Suster merawat 5 pasien");
                for (int j = (pasien + 1); j > pasien - 4; j--) {
                    System.out.println("Pasien " + j + " membayar ke kasir");
                }
                System.out.println("");
            }

        }
    }
}
