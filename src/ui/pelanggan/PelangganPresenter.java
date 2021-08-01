/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.pelanggan;

import dao.BasePresenter;
import dao.PelangganModel;
import interfaces.BaseFormPresenter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utils.Config;

/**
 *
 * @author Android Team
 */
public class PelangganPresenter extends BasePresenter<PelangganMvpView> implements BaseFormPresenter<PelangganModel> {

    public static final String TABLE_NAME = "customer";
    public static final String ID = "id";
    public static final String NAMA = "name";
    public static final String ALAMAT = "address";
    public static final String TELEPON = "phone";

    public PelangganPresenter() {

    }

    @Override
    public void save(PelangganModel model) {
        try {
            String sql = "insert into " + TABLE_NAME + " values('"
                    + model.idPelanggan + "','"
                    + model.nama + "','"
                    + model.alamat + "','"
                    + model.telepon + "')";
            mDataManager.executeSQL(sql);
            model.message = "Data berhasil disimpan.";
            mMvpView.onSucceed(DataAccessType.INSERT, model);
        } catch (Exception e) {
            e.printStackTrace();
            mMvpView.onError(DataAccessType.INSERT);
        }
    }

    @Override
    public void update(PelangganModel model) {
        try {
            String sql = "update " + TABLE_NAME + " set "
                    + NAMA + "='" + model.nama + "',"
                    + ALAMAT + "='" + model.alamat + "',"
                    + TELEPON + "='" + model.telepon + "'"
                    + "where " + ID + "='" + model.idPelanggan + "'";
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
            String sql = "delete from " + TABLE_NAME + " where " + ID + "='" + id + "'";
            mDataManager.executeSQL(sql);
            PelangganModel model = new PelangganModel();
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
            String sql = "select right (" + ID + ",2)+1 from " + TABLE_NAME;
            ResultSet rs = mDataManager.execute(sql);
            if (rs.next()) {
                rs.last();
                String no = rs.getString(1);
                while (no.length() < 3) {
                    no = "K00" + no;
                    value = no; // update value id
                }
            } else {
                value = "K001"; // update value id
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public ArrayList getData() {
        String sql = "select * from " + TABLE_NAME;
        ArrayList<PelangganModel> results = new ArrayList<>();
        try {
            ResultSet rs = mDataManager.execute(sql);
            while (rs.next()) {
                PelangganModel item = new PelangganModel();
                item.idPelanggan = rs.getString(ID);
                item.nama = rs.getString(NAMA);
                item.alamat = rs.getString(ALAMAT);
                item.telepon = rs.getString(TELEPON);
                results.add(item);
            }
            return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void searchById(JTable table) {
        searchById(table, null);
    }

    public void searchById(JTable table, String value) {
        String cari = value;
        if (value == null) {
            JOptionPane.showInputDialog(null, "Inputkan kriteria pencarian", "Input", JOptionPane.QUESTION_MESSAGE);
        }
        DefaultTableModel data = new DefaultTableModel(null, Config.TABLE_HEADER_PELANGGAN);
        table.setModel(data);
        String sql = "select * from " + TABLE_NAME + " where "
                + ID + " like '%" + cari + "%'" + "or "
                + NAMA + " like '%" + cari + "%'" + "or "
                + TELEPON + " like '%" + cari + "%'";
        try {
            ResultSet rs = mDataManager.execute(sql);
            while (rs.next()) {
                PelangganModel item = new PelangganModel();
                item.idPelanggan = rs.getString(ID);
                item.nama = rs.getString(NAMA);
                item.alamat = rs.getString(ALAMAT);
                item.telepon = rs.getString(TELEPON);

                String column[] = {item.idPelanggan, item.nama, item.alamat, item.telepon};
                data.addRow(column);
            }
            rs.last();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
