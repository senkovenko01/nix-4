package ua.com.alevel;


public class ReverseString {

    private static String reverseString(String string) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            reversedString.append(string.charAt(i));
        }
        return reversedString.toString();
    }

    public static String reverse(String str, String d) {
        return str.replaceAll(d, reverse(d));
    }


    public static String reverse(String str, int firstIndex, int lastIndex) {
        String subString = str.substring(firstIndex, ++lastIndex);
        return str.replaceAll(subString, reverse(subString));
    }

    public static String reverse(String input) {
        StringBuilder resultReverse = new StringBuilder();
        StringBuilder singleWord = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isWhitespace(input.charAt(i))) {
                singleWord.append(input.charAt(i));
                if (i == input.length() - 1) {
                    singleWord.reverse();
                    resultReverse.append(singleWord.toString());
                }
            } else {
                String tempString = singleWord.toString();
                singleWord.delete(0, singleWord.toString().length());
                singleWord.append(reverseString(tempString));
                singleWord.append(input.charAt(i));
                resultReverse.append(singleWord.toString());
                singleWord.delete(0, singleWord.toString().length());
            }
        }
        return resultReverse.toString();
    }


}
