package pl.kurs.task1;

import java.io.File;

public class TheLargestJavaFileRunner {
    public static void main(String[] args) {
        final File rootDir = new File("C:\\Users\\Marcin\\IdeaProjects");
        File theLargestFile = findTheLargestFile(rootDir);

        printTheLargestJavaFile(theLargestFile);
        //Workspace nr 1: (kurs Javy)
        //The largest .java file: C:\Users\Marcin\IdeaProjects\OperationsOnFiles\src\main\java\pl\kurs\dziecipalacze\ChildService.java (7.1806640625 KB)

    }

    public static File findTheLargestFile(File directory) {
        File theLargestFile = null;
        long theLargestFileSize = 0;

        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                File largestChildFile = findTheLargestFile(file);

                if (largestChildFile != null && largestChildFile.length() > theLargestFileSize && largestChildFile.getName().endsWith(".java")) {
                    theLargestFile = largestChildFile;
                    theLargestFileSize = largestChildFile.length();
                }
            } else if (file.getName().endsWith(".java")) {
                if (file.length() > theLargestFileSize) {
                    theLargestFile = file;
                    theLargestFileSize = file.length();
                }
            }
        }
        return theLargestFile;
    }

    public static void printTheLargestJavaFile(File theLargestFile) {
        if (theLargestFile != null) {
            double sizeInKb = getFileSizeInKilobytes(theLargestFile);
            System.out.println("The largest .java file: " + theLargestFile + " (" + sizeInKb + " KB)");
        } else {
            System.out.println("No .java files found.");
        }
    }


    public static double getFileSizeInKilobytes(File file) {
        return (double) file.length() / 1024;
    }
}