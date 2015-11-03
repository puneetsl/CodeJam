package me.puneetsingh.utils;

public class Strings {
    public static Character[] toCharacterArray(String sourceString) {
        char[] charArrays;
        charArrays = sourceString.toCharArray();
        Character[] characterArray = new Character[charArrays.length];
        for (int i = 0; i < charArrays.length; i++) {
            characterArray[i] = charArrays[i];
        }
        return characterArray;
    }
}
