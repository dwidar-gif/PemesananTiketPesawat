/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;

/**
 *
 * @author Android Team
 */
public interface BaseFormPresenter<T>  {

    /**
     * Get data from db and show into table.
     */
    ArrayList<T> getData();

    /**
     * Insert data into DB Step action after insert : showDataTable(),
     * clearForm(), formReadyToFilled(false), setDefaultButton().
     *
     */
    void save(T model);

    /**
     * Update data into DB Step action after update : showDataTable(),
     * clearForm(), formReadyToFilled(false), setDefaultButton().
     *
     */
    void update(T model);

    /**
     * Remove data into DB Step action after remove : showDataTable(),
     * clearForm(), formReadyToFilled(false), setDefaultButton().
     *
     */
    void delete(String id);

    /**
     * Generate new form id, auto increment base on current form id, Call this
     * method after click button add / insert.
     *
     */
    String generateFormId();
}
