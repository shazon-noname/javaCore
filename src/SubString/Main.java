package src.SubString;

public class Main {
    public static void main(String[] args) {
        String header1 = "Content-Type: text/html; charset=utf-8;";
        String header2 = "Content-Type: text/html; charset=windows-1251;";
        String header3 = "Content-Type: text/html; charset=ISO-8859-1;";

        String header4 = "Content-Type: text/html; charset=";
        String header5 = "Content-Type: text/html; charset=;";
        String header6 = "Content-Type: text/html;";



        System.out.println(getEncoding(header1));
        System.out.println(getEncoding(header2));
        System.out.println(getEncoding(header4));
        System.out.println(getEncoding(header5));
        System.out.println(getEncoding(header6));
    }


    public static String getEncoding ( String header) {
        String charsetStr = "charset=";
        int start = header.indexOf(charsetStr);
        int end = header.indexOf(';',start);

        if (start < 0 || end < 0) {
            return "";
        }

        String encoding = header.substring(start + charsetStr.length(), end);
        return encoding;
    }
}
