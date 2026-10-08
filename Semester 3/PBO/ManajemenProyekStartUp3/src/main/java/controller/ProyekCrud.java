/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;
 
import java.util.ArrayList;
import model.Proyek;
 
/**
 * 
 * @author WINDOWS 11 PRO
 */
public interface ProyekCrud {
    boolean tambahProjek(Proyek proyek);
 
    ArrayList<Proyek> getDaftarProjek();
 
    boolean isIdSudahAda(String id);
 
    Proyek cariProjekById(String id);
 
    boolean updateProjek(String id, String namaBaru, String deadlineBaru, String data1, String data2);
 
    boolean hapusProjek(String id);
}
