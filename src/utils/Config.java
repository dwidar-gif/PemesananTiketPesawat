/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Android Team
 */
public final class Config {

    public static final Object[] TABLE_HEADER_PELANGGAN = {"Kode", "Nama", "Alamat", "Telepon"};
    public static final Object[] TABLE_HEADER_PENJUALAN = {"Kode", "Id Pelanggan", "Pelanggan", "Id Tiket", "Maskapai", "Kelas", "Tujuan", "Harga", "Jumlah", "Total"};
    public static final Object[] TABLE_HEADER_TIKET = {"Kode Tiket", "Maskapai", "Kelas", "Tujuan", "Harga", "Status"};
    public static final Object[] TABLE_HEADER_PEMBATALAN = {"Kode Booking", "Tgl Berangkat","Nama", "Maskapai", "Kelas", "Tujuan", "Harga", "Status"};
}
