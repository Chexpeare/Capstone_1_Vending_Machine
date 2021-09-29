package com.techelevator.util;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SalesReport {
    public SalesReport(Menu menu) {

    }

    private static final String logFilePath = "capstone/logs/SalesReport.txt";
//    private static final String logFilePath = "/Users/chexpeare/MeritAmerica/PairProgrammingBackup/pair-programming-4/logs/search.log";

    public static void log(String message) throws IOException {
        File outputFile = new File(logFilePath);
        String canonical = outputFile.getCanonicalPath();

        try (FileOutputStream stream = new FileOutputStream(canonical, true);
             PrintWriter writer = new PrintWriter(stream)){

            LocalDateTime timestamp = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss");
            writer.println(timestamp.format(formatter) + " : " + message);

        } catch (Exception e) {
            throw new SalesReportException(e.getMessage() + "occurred while trying to write " + message + " to the log.");
        }
    }

    public static void displayReport() {
        System.out.println("\n(Optional) Choice #4 is hidden and reserved for a Sales Report\n");
        System.out.println("____________________________________");
        System.out.println("Vendo-Matic 800 Sales Report");
        System.out.println("------------------------------------");
        System.out.println("<<<Report will appear here>>>\n");
        System.out.println("____________________________________");
        System.out.println("*** End of report ***");

    }

}

//public class TELog {
//    private static final String logFilePath = "capstone/logs/process.log";
////    private static final String logFilePath = "/Users/chexpeare/MeritAmerica/PairProgrammingBackup/pair-programming-4/logs/search.log";
//
//    public static void log(String message) throws IOException {
//        File outputFile = new File(logFilePath);
//        String canonical = outputFile.getCanonicalPath();
//
//        try (FileOutputStream stream = new FileOutputStream(canonical, true);
//             PrintWriter writer = new PrintWriter(stream)){
//
//            LocalDateTime timestamp = LocalDateTime.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss");
//            writer.println(timestamp.format(formatter) + " : " + message);
//
//        } catch (Exception e) {
//            throw new TELogException(e.getMessage() + "occurred while trying to write " + message + " to the log.");
//        }
//    }
//}

