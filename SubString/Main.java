package SubString;

public class Main {
    public static void main(String[] args) {
        String header1 = "Content-Type: text/html; charset=utf-8;";
        String header2 = "Content-Type: text/html; charset=windows-1251;";
        String header3 = "Content-Type: text/html; charset=ISO-8859-1;";
        System.out.println(getEncoding(header1));
        System.out.println(getEncoding(header2));
        System.out.println(getEncoding(header3));
    }


    public static String getEncoding ( String header) {
        String charsetStr = "charset=";
        int start = header.indexOf(charsetStr) + charsetStr.length();
        int end = header.indexOf(';',start);
        String encoding = header.substring(start, end);
        return encoding;
    }
}
