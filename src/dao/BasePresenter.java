/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.DataManager;
import interfaces.MvpView;
import interfaces.Presenter;

/**
 *
 * @author Android Team
 * @param <T>
 */
public abstract class BasePresenter<T extends MvpView> implements Presenter<T>{

    public T mMvpView;
    public DataManager mDataManager;
    
    public enum DataAccessType {
        SELECT, INSERT, UPDATE, DELETE
    }
    
    public BasePresenter() {
        mDataManager = new DataManager();
    }
    
    @Override
    public void attachView(T view) {
        mMvpView = view;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }
    
    public boolean isViewAttached() {
        return mMvpView != null;
    }
}
