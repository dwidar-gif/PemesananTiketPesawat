/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.penjualan;

import dao.BasePresenter;
import dao.PenjualanModel;
import interfaces.BaseFormMvpView;

/**
 *
 * @author Android Team
 */
public interface PenjualanMvpView extends BaseFormMvpView {
    void onSucceed(BasePresenter.DataAccessType dataAccessType, PenjualanModel model);
}
