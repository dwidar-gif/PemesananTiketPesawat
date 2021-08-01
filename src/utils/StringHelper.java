/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Android Team
 */
public final class StringHelper {

    public static boolean isNotEmpty(String value) {
        return value != null || !value.isEmpty();
    }

    public static boolean isEmpty(String value) {
        return !isNotEmpty(value);
    }

    public static boolean validateField(String... text) {
        for (String value : text) {
            if (isEmpty(value)) {
                return false;
            }
        }
        return true;
    }
}
