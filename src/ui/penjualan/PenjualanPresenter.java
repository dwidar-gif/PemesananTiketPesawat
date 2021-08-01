/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.penjualan;

import interfaces.BaseFormPresenter;

/**
 *
 * @author Android Team
 */
public interface PenjualanPresenter<T> extends BaseFormPresenter<T> {
    T findById(String id);
}
