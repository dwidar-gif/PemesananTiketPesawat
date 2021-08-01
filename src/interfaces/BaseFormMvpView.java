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
public interface BaseFormMvpView extends BaseDaoMvpView {

    /**
     * Clear input text / set input text to empty.
     *
     */
    void clearForm();

    /**
     * Handle default avail button when no action needed or after action like
     * save, update and delete.
     *
     */
    void setDefaultButton();

    /**
     * Set form input to disable or enable
     *
     * @param enabled
     */
    void formReadyToFilled(boolean enabled);
}
