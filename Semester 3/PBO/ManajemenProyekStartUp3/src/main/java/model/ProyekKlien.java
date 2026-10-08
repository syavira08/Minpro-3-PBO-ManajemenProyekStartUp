/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
 
import controller.Validasi;
 
/**
 * 
 * @author WINDOWS 11 PRO
 */
public class ProyekKlien extends Proyek {
    private String namaKlien;
    private String jenisKebutuhan;
 
    public ProyekKlien(String idProjek, String namaProjek, String deadline, String namaKlien, String jenisKebutuhan) {
        super(idProjek, namaProjek, deadline);
        setNamaKlien(namaKlien);
        setJenisKebutuhan(jenisKebutuhan);
    }
 
    public String getNamaKlien() {
        return namaKlien;
    }
 
    public void setNamaKlien(String namaKlien) {
        if (Validasi.isTeksValid(namaKlien)) {
            this.namaKlien = namaKlien;
        } else {
            System.out.println("Nama klien tidak valid!");
        }
    }
 
    public String getJenisKebutuhan() {
        return jenisKebutuhan;
    }
 
    public void setJenisKebutuhan(String jenisKebutuhan) {
        if (Validasi.isTeksValid(jenisKebutuhan)) {
            this.jenisKebutuhan = jenisKebutuhan;
        } else {
            System.out.println("Jenis kebutuhan tidak valid!");
        }
    }
    
    @Override
    public String getJenisProjek() {
        return "Klien";
    }
 
    @Override
    public void update(String namaBaru, String deadlineBaru, String klienBaru, String kebutuhanBaru) {
        update(namaBaru, deadlineBaru);
        setNamaKlien(klienBaru);
        setJenisKebutuhan(kebutuhanBaru);
    }
 
    @Override
    public void cetakData() {
        super.cetakData();
        System.out.println("Nama Klien      : " + namaKlien);
        System.out.println("Jenis Kebutuhan : " + jenisKebutuhan);
    }
}
