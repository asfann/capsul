package com.company;

public class Password {
    private String passwordStr;

    public Password(String passwordStr) {
        setPasswordStr(passwordStr);
    }

    public Password() {

    }

    public String getPasswordStr() {
        return passwordStr;
    }

    public boolean setPasswordStr(String passwordStr) {
        if (passwordStr.length() < 9) {
            return false;
        } else {
            for (int i = 0; i < passwordStr.length(); i++) {
                if (Character.isDigit(passwordStr.charAt(i))) {
                }
            }
            for (int j = 0; j < passwordStr.length(); j++) {
                if (Character.isUpperCase(passwordStr.charAt(j))) {
                }
            }
            for (int k = 0; k < passwordStr.length(); k++) {
                if (Character.isLowerCase(passwordStr.charAt(k))) {
                }
            }
        }
        return true;
    }
}
// passwordStr // it should contain uppercase and lowercase letters and digits
// and its length must be more than 9 symbols

