package recurssion;

public class RecursionExamples {

    public static void main(String[] args) {
        String reversedString = reserveString("Hello World");
        System.out.println("Reversed String: " + reversedString);
    }

    private static String reserveString(String s) {
        if(s.length() == 1) return s;
        char lastChar = s.charAt(s.length()-1);
        return lastChar + reserveString(s.substring(0, s.length()-1));
    }
}
