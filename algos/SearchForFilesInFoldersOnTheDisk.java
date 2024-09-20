package algos;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SearchForFilesInFoldersOnTheDisk {
    public static void main(String[] args) {
        ArrayList<File> fileList = new ArrayList<>();
        File file = new File("C:\\Users\\marya\\Downloads");  // use your path
        searchFiles(file, fileList);

        for (File file1 : fileList) {
            System.out.println(file1.getAbsolutePath());
        }

        fileList.clear();

        System.out.println();

        searchFilesBFS(file, fileList);

        for (File file1 : fileList) {
            System.out.println(file1.getAbsolutePath());
        }


    }

    public static void searchFiles(File rootFile, List<File> fileList) {
        if (rootFile.isDirectory()) {
            System.out.println("Searching at: " + rootFile.getAbsolutePath());
            File[] directoryFiles = rootFile.listFiles();
            if ( directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        searchFiles(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".jpg")) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }

    public static void searchFilesBFS(File rootFile, List<File> fileList) {
        Queue<File> queue = new LinkedList<>();
        queue.add(rootFile);

        while (!queue.isEmpty()) {
            File currentFile = queue.poll();
            System.out.println("Searching at: " + rootFile.getAbsolutePath());
            File[] directoryFiles = currentFile.listFiles();
            if (directoryFiles!=null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        queue.add(file);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".jpg")) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}
