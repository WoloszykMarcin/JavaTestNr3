package pl.kurs.task1;

import java.io.File;

public class LargestJavaFileRunner {
    public static void main(String[] args) {
        final File rootDir = new File("C:\\Users\\Marcin\\IdeaProjects");
        File largestFile = findLargestJavaFile(rootDir);

        printLargestJavaFile(largestFile);
        //Workspace nr 1: (kurs Javy)
        //Largest .java file: C:\Users\Marcin\IdeaProjects\OperationsOnFiles\src\main\java\pl\kurs\dziecipalacze\ChildService.java (7.1806640625 KB)

    }

    public static File findLargestJavaFile(File directory) {
        File largestFile = null;
        long largestFileSize = 0;

        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                File largestChildFile = findLargestJavaFile(file);

                if (largestChildFile != null && largestChildFile.length() > largestFileSize && largestChildFile.getName().endsWith(".java")) {
                    largestFile = largestChildFile;
                    largestFileSize = largestChildFile.length();
                }
            } else if (file.getName().endsWith(".java")) {
                if (file.length() > largestFileSize) {
                    largestFile = file;
                    largestFileSize = file.length();
                }
            }
        }
        return largestFile;
    }

    public static void printLargestJavaFile(File largestFile) {
        if (largestFile != null) {
            double sizeInKb = getFileSizeInKilobytes(largestFile);
            System.out.println("Largest .java file: " + largestFile + " (" + sizeInKb + " KB)");
        } else {
            System.out.println("No .java files found.");
        }
    }


    public static double getFileSizeInKilobytes(File file) {
        return (double) file.length() / 1024;
    }
}