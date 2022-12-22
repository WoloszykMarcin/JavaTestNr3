package pl.kurs.task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileListingRunner {
    public static void main(String[] args) {
        final File rootDir = new File("C:\\Users\\Marcin\\IdeaProjects");

        List<File> javaFiles = new ArrayList<>();

        findJavaFiles(javaFiles, rootDir);


        javaFiles.stream()
                .collect(Collectors.groupingBy(FileListingRunner::getDayFromFile, Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);
    }

    public static void findJavaFiles(List<File> list, File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory())
                findJavaFiles(list, f);
            else if (f.getName().endsWith(".java")) {
                list.add(f);
            }
        }
    }

    public static DayOfWeek getDayFromFile(File file) {
        FileTime creationTime = null;

        try {
            creationTime = (FileTime) Files.getAttribute(Paths.get(file.getPath()), "creationTime");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DateFormat df = new SimpleDateFormat("EEE, dd/MM/yyyy");
        String creationDate = df.format(creationTime.toMillis());
        LocalDate ld = LocalDate.ofInstant(creationTime.toInstant(), ZoneId.of("UTC"));
        return ld.getDayOfWeek();
    }
}


    //ZESTAWIENIE z dwóch workspace'ów:

    // Workspace nr 1: (kurs Javy)
        //    TUESDAY=43
        //    MONDAY=123
        //    SUNDAY=8
        //    SATURDAY=8
        //    THURSDAY=69
        //    FRIDAY=21
        //    WEDNESDAY=20

    // Workspace nr 2:
        //    SUNDAY=80
        //    SATURDAY=21
        //    FRIDAY=47
        //    THURSDAY=25
        //    WEDNESDAY=75
        //    MONDAY=5

