package src.Working_with_files_and_networking;

import java.io.File;
import java.util.Scanner;

public class FolderSizeMeter {
    private static final String[] sizeNames = {" b", " kb", " MB", " GB"};

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter the path or exit: ");
            String path = new Scanner(System.in).nextLine();

            System.out.println("wait...");

            if (path.equals("exit")) {
                return;
            }

            File folder = new File(path);
            String size = getHumanReadableSize(getFolderSize(folder));

            System.out.println("Size your folder - " + size);
        }
    }


    public static long getFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        }
        File[] files = folder.listFiles();
        if (files == null) {
            return 0;
        }
        long length = 0;
        for (File file : files) {
            length += getFolderSize(file);
        }
        return length;
    }

    public static String getHumanReadableSize2(Long length) {
        int power = (int) (Math.log(length) / Math.log(1024)); // logₐ(b) = log(b) / log(a), ступень - це тип розміру з масиву sizeNames
        double value = length / Math.pow(1024, power);
        int roundedValue = (int) (Math.round(value * 100) / 100);
        return roundedValue + sizeNames[power];
    }

    public static String getHumanReadableSize(Long length) {
        int power = 0;
        double result = length;
        while (result >= 1024 && power < sizeNames.length - 1) {
            result /= 1024;
            power++;
        }
        return (Math.round(result * 100) / 100) + sizeNames[power];
    }
}
