/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asistensi;

import java.io.Serializable;

/**
 *
 * @author cynux
 */
public class olah_app_crud_CS implements Serializable{
    int nim;
    String nama, jurusan, alamat;

    public olah_app_crud_CS(int nim, String nama, String jurusan, String alamat) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.alamat = alamat;
    }
    
    @Override
    public String toString() {
        return "\nNIM = " + nim + "\nNAMA = " + nama + "\nJURUSAN = " + jurusan + "\nALAMAT = " + alamat+"\n";
    }
    
}
