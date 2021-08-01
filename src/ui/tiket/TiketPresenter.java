/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.tiket;

import dao.BasePresenter;
import dao.TiketModel;
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
public class TiketPresenter extends BasePresenter<TiketMvpView> implements BaseFormPresenter<TiketModel> {

    public static final String TABLE_NAME = "tiket";
    public static final String TIKET_ID = "tiket_id";
    public static final String MASKAPAI = "maskapai_name";
    public static final String KELAS = "maskapai_class";
    public static final String TUJUAN = "destination";
    public static final String HARGA = "price";
    public static final String STATUS = "status";

    public TiketPresenter() {

    }

    @Override
    public void save(TiketModel model) {
        try {
            String sql = "insert into tiket values('"
                    + model.kodeTicket + "','"
                    + model.maskapai + "','"
                    + model.kelas + "','"
                    + model.tujuan + "','"
                    + model.harga + "','"
                    + model.status + "')";
            mDataManager.executeSQL(sql);
            model.message = "Data berhasil disimpan.";
            mMvpView.onSucceed(DataAccessType.INSERT, model);
        } catch (Exception e) {
            e.printStackTrace();
            mMvpView.onError(DataAccessType.INSERT);
        }
    }

    @Override
    public void update(TiketModel model) {
        try {
            String sql = "update tiket set "
                    + MASKAPAI + "='" + model.maskapai + "',"
                    + KELAS + "='" + model.kelas + "',"
                    + TUJUAN + "='" + model.tujuan + "',"
                    + HARGA + "='" + model.harga + "', "
                    + STATUS + "='" + model.status + "' "
                    + "where " + TIKET_ID + "='" + model.kodeTicket + "'";
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
            String sql = "delete from " + TABLE_NAME + " where " + TIKET_ID + "='" + id + "'";
            mDataManager.executeSQL(sql);
            TiketModel model = new TiketModel();
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
            String sql = "select right (" + TIKET_ID + ",2)+1 from " + TABLE_NAME;
            ResultSet rs = mDataManager.execute(sql);
            if (rs.next()) {
                rs.last();
                String no = rs.getString(1);
                while (no.length() < 3) {
                    no = "T00" + no;
                    value = no; // update value id
                }
            } else {
                value = "T001"; // update value id
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public ArrayList getData() {
        String sql = "select * from " + TABLE_NAME;
        ArrayList<TiketModel> results = new ArrayList<>();
        try {
            ResultSet rs = mDataManager.execute(sql);
            while (rs.next()) {
                TiketModel item = new TiketModel();
                item.kodeTicket = rs.getString(TIKET_ID);
                item.maskapai = rs.getString(MASKAPAI);
                item.kelas = rs.getString(KELAS);
                item.tujuan = rs.getString(TUJUAN);
                item.harga = rs.getDouble(HARGA);
                item.status = rs.getString(STATUS);

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
            cari = JOptionPane.showInputDialog(null, "Inputkan kriteria pencarian", "Input", JOptionPane.QUESTION_MESSAGE);
        }
        DefaultTableModel data = new DefaultTableModel(null, Config.TABLE_HEADER_TIKET);
        table.setModel(data);
        String sql = "select * from " + TABLE_NAME + " where "
                + TIKET_ID + " like '%" + cari + "%'" + "or "
                + MASKAPAI + " like '%" + cari + "%'" + "or "
                + TUJUAN + " like '%" + cari + "%'";
        try {
            ResultSet rs = mDataManager.execute(sql);
            while (rs.next()) {
                TiketModel item = new TiketModel();
                item.kodeTicket = rs.getString(TIKET_ID);
                item.maskapai = rs.getString(MASKAPAI);
                item.kelas = rs.getString(KELAS);
                item.tujuan = rs.getString(TUJUAN);
                item.harga = rs.getDouble(HARGA);
                item.status = rs.getString(STATUS);

                String column[] = {item.kodeTicket, item.maskapai, item.kelas, item.tujuan, String.valueOf(item.harga), item.status};
                data.addRow(column);
            }
            rs.last();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
