/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.login;

import interfaces.MvpView;

/**
 *
 * @author Android Team
 */
public interface LoginMvpView extends MvpView{
    void onSucceess(String name);
    void onError();
}
