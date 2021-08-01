/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.pelanggan;

import ui.tiket.*;
import dao.BaseModel;
import dao.BasePresenter;
import interfaces.BaseFormMvpView;

/**
 *
 * @author Android Team
 * @param <T>
 */
public interface PelangganMvpView<T extends BaseModel> extends BaseFormMvpView {
    void onSucceed(BasePresenter.DataAccessType dataAccessType, T model);
}
