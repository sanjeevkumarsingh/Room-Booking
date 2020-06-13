package com.coding.util;

import org.springframework.stereotype.Component;

/*
 *Util.java - A class with utility function to support condition and calculation functionality.
 *
 * @author Sanjeev Kumar Singh
 * @version test
 */
@Component
public class Util {
    /**
     * Return the true if the password meets the length condition else false.
     *
     * @param password A string password that is to verify it's length.
     * @return boolean if verified the length then it's true else false.
     */

    public boolean validatePassword(String password) {
        if (password != null && password.length() >= 8 && password.length() <= 10)
            return true;
        return false;
    }
    /**
     * Return the true if the password meets the length condition else false.
     *
     * @param email A string email that is to verify with email paterm.
     * @return boolean if verified the length then it's true else false.
     */
    public boolean validateEmail(String email) {

        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }


}
