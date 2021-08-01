/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Android Team
 */
public interface Presenter<T extends MvpView> {
    void attachView(T view);
    void detachView();
}
