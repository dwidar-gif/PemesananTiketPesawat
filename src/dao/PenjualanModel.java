/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Android Team
 */
public class PenjualanModel extends BaseModel{
    
    public String idPenjualan;
    public String tglBerangkat;
    // pelanggan
    public String idPelanggan;
    public String namaPelanggan;
    public String alamatPelanggan;
    public String teleponPelanggan;
    //tiket 
    public String kodeTicket;
    public String maskapai;
    public String kelas;
    public String tujuan;
    public double harga;
    public String tiketStatus;
    
    public int jumlahTiket;
    public double totalHarga;
    public double jumlahBayar;
    public String createTime;
    public String status;
    
    public PenjualanModel() {
        
    }
}
