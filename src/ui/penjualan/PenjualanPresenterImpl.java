/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.penjualan;

import dao.BasePresenter;
import dao.PelangganModel;
import dao.PenjualanModel;
import dao.TiketModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.pelanggan.PelangganPresenter;
import ui.tiket.TiketPresenter;
import utils.Config;

/**
 *
 * @author Android Team
 */
public class PenjualanPresenterImpl extends BasePresenter<PenjualanMvpView> implements PenjualanPresenter<PenjualanModel> {

    public static final String TABLE_NAME = "penjualan";
    public static final String ID_PENJUALAN = "id";
    public static final String TGL_BERANGKAT = "book_date";
    // Pelanggan
    public static final String PELANGGAN_ID = "cust_id";
    public static final String PELANGGAN_NAMA = "cust_name";
    public static final String PELANGGAN_ALAMAT = "cust_address";
    public static final String PELANGGAN_TELEPON = "cust_phone";
    // Tiket
    public static final String TIKET_ID = "tiket_id";
    public static final String MASKAPAI = "tiket_maskapai";
    public static final String KELAS = "tiket_class";
    public static final String TUJUAN = "tiket_destination";
    public static final String HARGA = "tiket_price";
    public static final String JUMLAH_BAYAR = "jml_bayar";
    public static final String TIKET_STATUS = "tiket_status";

    public static final String JUMLAH = "jumlah";
    public static final String TOTAL = "total";
    public static final String CREATE_TIME = "create_at";
    public static final String STATUS = "status";

    public static final String STATUS_COMPLETED = "berhasil";
    public static final String STATUS_CANCELED = "dibatalkan";

    protected ArrayList<PenjualanModel> listOfOngoingOrder;

    public PenjualanPresenterImpl() {
        listOfOngoingOrder = new ArrayList<>();
    }

    @Override
    public void save(PenjualanModel model) {
        try {
            String sql = "insert into " + TABLE_NAME + " values('"
                    + model.idPenjualan + "','"
                    + model.tglBerangkat + "','"
                    + model.idPelanggan + "','"
                    + model.namaPelanggan + "','"
                    + model.alamatPelanggan + "','"
                    + model.teleponPelanggan + "','"
                    + model.kodeTicket + "','"
                    + model.maskapai + "','"
                    + model.kelas + "','"
                    + model.tujuan + "','"
                    + model.harga + "','"
                    + model.tiketStatus + "','"
                    + model.jumlahTiket + "','"
                    + model.totalHarga + "','"
                    + model.jumlahBayar + "','"
                    + model.createTime + "','"
                    + model.status + "')";
            mDataManager.executeSQL(sql);
            model.message = "Data berhasil disimpan.";
            mMvpView.onSucceed(DataAccessType.INSERT, model);
        } catch (Exception e) {
            e.printStackTrace();
            mMvpView.onError(DataAccessType.INSERT);
        }
    }

    public void save(ArrayList<PenjualanModel> results) {
        try {
            for (PenjualanModel model : results) {
                String sql = "insert into " + TABLE_NAME + " values('"
                        + model.idPenjualan + "','"
                        + model.tglBerangkat + "','"
                        + model.idPelanggan + "','"
                        + model.namaPelanggan + "','"
                        + model.alamatPelanggan + "','"
                        + model.teleponPelanggan + "','"
                        + model.kodeTicket + "','"
                        + model.maskapai + "','"
                        + model.kelas + "','"
                        + model.tujuan + "','"
                        + model.harga + "','"
                        + model.tiketStatus + "','"
                        + model.jumlahTiket + "','"
                        + model.totalHarga + "','"
                        + model.jumlahBayar + "','"
                        + model.createTime + "','"
                        + model.status + "')";
                mDataManager.executeSQL(sql);
            }
            PenjualanModel callback = new PenjualanModel();
            callback.message = "Data berhasil disimpan.";
            mMvpView.onSucceed(DataAccessType.INSERT, callback);
        } catch (Exception e) {
            e.printStackTrace();
            mMvpView.onError(DataAccessType.INSERT);
        }
    }

    @Override
    public void update(PenjualanModel model) {
        try {
            String sql = "update " + TABLE_NAME + " set "
                    + TGL_BERANGKAT + "='" + model.tglBerangkat + "',"
                    + PELANGGAN_ID + "='" + model.idPelanggan + "',"
                    + PELANGGAN_NAMA + "='" + model.namaPelanggan + "',"
                    + PELANGGAN_ALAMAT + "='" + model.alamatPelanggan + "',"
                    + PELANGGAN_TELEPON + "='" + model.teleponPelanggan + "',"
                    + TIKET_ID + "='" + model.kodeTicket + "',"
                    + MASKAPAI + "='" + model.maskapai + "',"
                    + KELAS + "='" + model.kelas + "',"
                    + TUJUAN + "='" + model.tujuan + "',"
                    + HARGA + "='" + model.harga + "',"
                    + TIKET_STATUS + "='" + model.tiketStatus + "',"
                    + JUMLAH + "='" + model.jumlahTiket + "',"
                    + TOTAL + "='" + model.totalHarga + "',"
                    + JUMLAH_BAYAR + "='" + model.jumlahBayar + "',"
                    + CREATE_TIME + "='" + model.createTime + "',"
                    + STATUS + "='" + model.status + "'"
                    + "where " + ID_PENJUALAN + "='" + model.idPenjualan + "'";
            mDataManager.executeSQL(sql);
            model.message = "Data berhasil dirubah";
            mMvpView.onSucceed(DataAccessType.UPDATE, model);
        } catch (Exception e) {
            e.printStackTrace();
            mMvpView.onError(DataAccessType.UPDATE);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "delete from " + TABLE_NAME + " where " + ID_PENJUALAN + "='" + id + "'";
            mDataManager.executeSQL(sql);
            PenjualanModel model = new PenjualanModel();
            model.message = "Data berhasil dihapus.";
            mMvpView.onSucceed(DataAccessType.DELETE, model);
        } catch (Exception e) {
            e.printStackTrace();
            mMvpView.onError(DataAccessType.DELETE);
        }
    }

    @Override
    public String generateFormId() {
        String value = "";
        try {
            String sql = "select right (" + ID_PENJUALAN + ",2)+1 from " + TABLE_NAME;
            ResultSet rs = mDataManager.execute(sql);
            if (rs.next()) {
                rs.last();
                String no = rs.getString(1);
                while (no.length() < 3) {
                    no = "B00" + no;
                    value = no; // update value id
                }
            } else {
                value = "B001"; // update value id
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public ArrayList getData() {
        String sql = "select * from " + TABLE_NAME;
        ArrayList<PenjualanModel> results = new ArrayList<>();
        try {
            ResultSet rs = mDataManager.execute(sql);
            while (rs.next()) {
                PenjualanModel item = new PenjualanModel();
                item.idPenjualan = rs.getString(ID_PENJUALAN);
                item.tglBerangkat = rs.getString(TGL_BERANGKAT);
                item.idPelanggan = rs.getString(PELANGGAN_ID);
                item.namaPelanggan = rs.getString(PELANGGAN_NAMA);
                item.alamatPelanggan = rs.getString(PELANGGAN_ALAMAT);
                item.teleponPelanggan = rs.getString(PELANGGAN_TELEPON);
                item.kodeTicket = rs.getString(TIKET_ID);
                item.maskapai = rs.getString(MASKAPAI);
                item.kelas = rs.getString(KELAS);
                item.tujuan = rs.getString(TUJUAN);
                item.harga = rs.getDouble(HARGA);
                item.jumlahBayar = rs.getDouble(JUMLAH_BAYAR);
                item.tiketStatus = rs.getString(TIKET_STATUS);
                item.jumlahTiket = rs.getInt(JUMLAH);
                item.totalHarga = rs.getDouble(TOTAL);
                item.createTime = rs.getString(CREATE_TIME);
                item.status = rs.getString(STATUS);
                results.add(item);
            }
            return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PenjualanModel findById(String id) {
        PenjualanModel model = new PenjualanModel();
        try {
            String sql = "select * from " + TABLE_NAME + " where id='" + id + "'";
            ResultSet resultSet = mDataManager.execute(sql);
            if (resultSet.next()) {
                model.idPenjualan = resultSet.getString(ID_PENJUALAN);
                model.tglBerangkat = resultSet.getString(TGL_BERANGKAT);
                // Pelanggan 
                model.idPelanggan = resultSet.getString(ID_PENJUALAN);
                model.namaPelanggan = resultSet.getString(PELANGGAN_NAMA);
                model.alamatPelanggan = resultSet.getString(PELANGGAN_ALAMAT);
                model.teleponPelanggan = resultSet.getString(PELANGGAN_TELEPON);
                // Tiket
                model.kodeTicket = resultSet.getString(TIKET_ID);
                model.maskapai = resultSet.getString(MASKAPAI);
                model.kelas = resultSet.getString(KELAS);
                model.tujuan = resultSet.getString(TUJUAN);
                model.harga = resultSet.getDouble(HARGA);
                model.jumlahBayar = resultSet.getDouble(JUMLAH_BAYAR);
                model.tiketStatus = resultSet.getString(TIKET_STATUS);

                model.jumlahTiket = resultSet.getInt(JUMLAH);
                model.totalHarga = resultSet.getDouble(TOTAL);
                model.createTime = resultSet.getString(CREATE_TIME);
                model.status = resultSet.getString(STATUS);
            }
            resultSet.last();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    public PelangganModel findPelangganById(String id) {
        PelangganModel model = new PelangganModel();
        try {
            String sql = "select * from " + PelangganPresenter.TABLE_NAME + " where " + PelangganPresenter.ID + "='" + id + "'";
            ResultSet resultSet = mDataManager.execute(sql);
            if (resultSet.next()) {
                model.idPelanggan = resultSet.getString(PelangganPresenter.ID);
                model.nama = resultSet.getString(PelangganPresenter.NAMA);
                model.alamat = resultSet.getString(PelangganPresenter.ALAMAT);
                model.telepon = resultSet.getString(PelangganPresenter.TELEPON);
            }
            resultSet.last();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    public TiketModel findTiketById(String id) {
        TiketModel model = new TiketModel();
        try {
            String sql = "select * from " + TiketPresenter.TABLE_NAME + " where " + TiketPresenter.TIKET_ID + "='" + id + "'";
            ResultSet resultSet = mDataManager.execute(sql);
            if (resultSet.next()) {
                model.kodeTicket = resultSet.getString(TiketPresenter.TIKET_ID);
                model.maskapai = resultSet.getString(TiketPresenter.MASKAPAI);
                model.kelas = resultSet.getString(TiketPresenter.KELAS);
                model.tujuan = resultSet.getString(TiketPresenter.TUJUAN);
                model.harga = resultSet.getDouble(TiketPresenter.HARGA);
                model.status = resultSet.getString(TiketPresenter.STATUS);
            }
            resultSet.last();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    public PenjualanModel getItemOfCurrentOrder(int index) {
        return listOfOngoingOrder.get(index);
    }

    public void removeItemOfCurrentOrder(String id) {
        for (PenjualanModel item : listOfOngoingOrder) {
            if (item.equals(id)) {
                listOfOngoingOrder.remove(item);
            }
        }
    }

    public void cancelOrder(String id) {
        try {
            String sql = "update " + TABLE_NAME + " set "
                    + STATUS + "='" + STATUS_CANCELED + "'"
                    + " where " + ID_PENJUALAN + "='" + id + "'";
            mDataManager.executeSQL(sql);

            PenjualanModel model = new PenjualanModel();
            model.message = "Order " + id + " telah dibatalkan";
            mMvpView.onSucceed(DataAccessType.UPDATE, model);
        } catch (Exception e) {
            e.printStackTrace();
            mMvpView.onError(DataAccessType.UPDATE);
        }
    }

    public void searchById(JTable table, String value) {
        String cari = JOptionPane.showInputDialog(null, "Inputkan kriteria pencarian", "Input", JOptionPane.QUESTION_MESSAGE);
        DefaultTableModel data = new DefaultTableModel(null, Config.TABLE_HEADER_PEMBATALAN);
        table.setModel(data);
        String sql = "select * from " + TABLE_NAME + " where "
                + ID_PENJUALAN + " like '%" + cari + "%'" + "or "
                + MASKAPAI + " like '%" + cari + "%'" + "or "
                + KELAS + " like '%" + cari + "%'";
        try {
            ResultSet rs = mDataManager.execute(sql);
            while (rs.next()) {
                PenjualanModel item = new PenjualanModel();
                item.idPenjualan = rs.getString(ID_PENJUALAN);
                item.tglBerangkat = rs.getString(TGL_BERANGKAT);
                item.idPelanggan = rs.getString(PELANGGAN_ID);
                item.namaPelanggan = rs.getString(PELANGGAN_NAMA);
                item.alamatPelanggan = rs.getString(PELANGGAN_ALAMAT);
                item.teleponPelanggan = rs.getString(PELANGGAN_TELEPON);
                item.kodeTicket = rs.getString(TIKET_ID);
                item.maskapai = rs.getString(MASKAPAI);
                item.kelas = rs.getString(KELAS);
                item.tujuan = rs.getString(TUJUAN);
                item.harga = rs.getDouble(HARGA);
                item.jumlahBayar = rs.getDouble(JUMLAH_BAYAR);
                item.tiketStatus = rs.getString(TIKET_STATUS);
                item.jumlahTiket = rs.getInt(JUMLAH);
                item.totalHarga = rs.getDouble(TOTAL);
                item.createTime = rs.getString(CREATE_TIME);
                item.status = rs.getString(STATUS);

                String column[] = {item.idPenjualan, item.tglBerangkat, item.namaPelanggan, item.maskapai, item.kelas, item.tujuan, String.valueOf(item.harga), item.status};
                data.addRow(column);
            }
            rs.last();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
