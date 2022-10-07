package org.randomobjects;

public class RandomPassword {
    private static final String possiblePasswordCombinations = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "abcdefghijklmnopqrstuvxyz"
            + "0123456789"
            + "`~!@#$%^&*()-_=+{[}]|\\;:'\",<.>/?";

    public static String RandomString(int stringLength) {
        StringBuilder randomString = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            int randomIndex = (int)(possiblePasswordCombinations.length() * Math.random());
            randomString.append(possiblePasswordCombinations.charAt(randomIndex));
        }
        return randomString.toString();
    }
}
