/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.login;

import dao.BasePresenter;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Android Team
 */
public class LoginPresenter extends BasePresenter<LoginMvpView> {

    public LoginPresenter() {

    }

    public void login(String username, String password) {
        try {
            String name = "";
            String sql = "select * from user where username='" + username + "' and password='" + password + "'";
            ResultSet resultSet = mDataManager.execute(sql);
            if (resultSet.next()) {
                name = resultSet.getString("name");
            }
            resultSet.last();
            if (resultSet.getRow() >= 1) {
                mMvpView.onSucceess(name);
            } else if (resultSet.getRow() == 0) {
                mMvpView.onError();
            }
        } catch (Exception e) {
            e.printStackTrace();
            mMvpView.onError();
        }
    }
}
