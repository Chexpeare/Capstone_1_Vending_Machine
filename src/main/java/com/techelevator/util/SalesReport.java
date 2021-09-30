package com.techelevator.util;

import com.techelevator.view.Menu;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class SalesReport {
    static final String logFilePath = "capstone/logs/SalesReport.txt";
    static final String salesReportFile = "capstone/logs/" + fileName() + ".txt";
    //    private static final String logFilePath = "/Users/chexpeare/MeritAmerica/PairProgrammingBackup/pair-programming-4/logs/search.log";

    /** CONSTRUCTOR */
    public SalesReport(Menu menu) {

    }

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

    public static void createSalesReport() throws IOException {

        File outputFile = new File(salesReportFile);
        String canonical = outputFile.getCanonicalPath();

        try (FileOutputStream stream = new FileOutputStream(canonical, true);
             PrintWriter writer = new PrintWriter(stream)){

            LocalDateTime timestamp = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss");
//            writer.println(timestamp.format(formatter) + " : " + message);

        } catch (Exception e) {
            throw new SalesReportException(e.getMessage() + "occurred while trying to create " + salesReportFile + ".");
        }
    }

    public static void displaySalesReport() throws IOException {
        System.out.println("\n(Optional) Choice #4 is hidden and reserved for a Sales Report\n");
        System.out.println("____________________________________");
        System.out.println("Vendo-Matic 800 Sales Report");
        System.out.println("------------------------------------");
        System.out.println("<<<Report will appear here>>>\n");
        System.out.println("____________________________________");
        System.out.println("*** End of report ***");

        File inputFile = new File(salesReportFile);
        String canonical = inputFile.getCanonicalPath();
        FileReader readerFile = new FileReader(canonical);
        BufferedReader reader = new BufferedReader(readerFile);
        String currentLine = reader.readLine();
        System.out.println("Building SalesReport: " + currentLine);
        }
    private static TemporalAccessor fileName() {
//        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyHHmmss");
//        TemporalAccessor fileNameDateTime = formatter.parse("022310141505"); // 012318123456
        TemporalAccessor fileNameDateTime = formatter.parse("012318123456"); // 022310141505
        return fileNameDateTime;
    }

}
