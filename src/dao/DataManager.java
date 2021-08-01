/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Android Team
 */
public class DataManager {

    Connection mConnection;
    Statement mStatement;
    ResultSet mResultSet;

    public DataManager() {
        mConnection = DBConnection.setConnection();
    }

    /**
     * Login query
     *
     * @param query
     * @return ResultSet
     */
    public ResultSet execute(String query) {
        try {
            mStatement = mConnection.createStatement();
            return mStatement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeSQL(String query) {
        try {
            mStatement = mConnection.createStatement();
            mStatement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
