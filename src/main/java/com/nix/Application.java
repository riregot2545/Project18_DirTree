package com.nix;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Application {
    private static DirTreeProcessor processor;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Path directoryPath;
        Path outputPath;
        if (args.length < 2) {
            System.out.println("Args is empty, enter path to file in console");
            System.out.print("Path to directory: ");
            directoryPath = Paths.get(scanner.nextLine());
            System.out.print("Path to output file: ");
            outputPath = Paths.get(scanner.nextLine());
        } else {
            directoryPath = Paths.get(args[0]);
            outputPath = Paths.get(args[1]);
        }
        processor = new DirTreeProcessor(directoryPath.toFile(), outputPath.toFile());
        processor.proceed();
    }
}
