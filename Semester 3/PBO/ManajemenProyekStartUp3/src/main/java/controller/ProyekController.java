/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
 
import java.util.ArrayList;
import model.Proyek;
import model.ProyekInternal;
import model.ProyekKlien;
 
/**
 * 
 * @author WINDOWS 11 PRO
 */
public class ProyekController implements ProyekCrud {
    private final ArrayList<Proyek> daftarProjek = new ArrayList<>();
 
    public ProyekController() {
        daftarProjek.add(new ProyekInternal(
                "PRJ001",
                "Sistem HR Internal",
                "30-11-2026",
                "Engineering",
                "Digitalisasi proses HR perusahaan"
        ));
 
        daftarProjek.add(new ProyekKlien(
                "PRJ002",
                "Website Company Profile",
                "15-12-2026",
                "PT Maju Bersama",
                "Pembuatan Website"
        ));
 
        daftarProjek.add(new ProyekInternal(
                "PRJ003",
                "Dashboard Analytics",
                "10-01-2027",
                "Product",
                "Monitoring performa aplikasi startup"
        ));
    }
 
    @Override
    public boolean tambahProjek(Proyek proyek) {
        if (isIdSudahAda(proyek.getIdProjek())) {
            return false;
        }
        daftarProjek.add(proyek);
        return true;
    }
 
    @Override
    public ArrayList<Proyek> getDaftarProjek() {
        return daftarProjek;
    }
 
    private int cariIndexById(String id) {
        for (int i = 0; i < daftarProjek.size(); i++) {
            if (daftarProjek.get(i).getIdProjek().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
 
    @Override
    public boolean isIdSudahAda(String id) {
        return cariIndexById(id) != -1;
    }
 
    @Override
    public Proyek cariProjekById(String id) {
        int index = cariIndexById(id);
        if (index == -1) {
            return null;
        }
        return daftarProjek.get(index);
    }
 
    @Override
    public boolean updateProjek(String id, String namaBaru, String deadlineBaru, String data1, String data2) {
        Proyek p = cariProjekById(id);
        if (p == null) {
            return false;
        }
        
        p.update(namaBaru, deadlineBaru, data1, data2);
        return true;
    }
 
    @Override
    public boolean hapusProjek(String id) {
        int index = cariIndexById(id);
        if (index == -1) {
            return false;
        }
        daftarProjek.remove(index);
        return true;
    }
}
