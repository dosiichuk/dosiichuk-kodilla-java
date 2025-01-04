package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;

public class ExceptionModuleRunner {

    public static void main(String[] args) {
        FileReaderWithoutHandling fileReader = new FileReaderWithoutHandling();
        try {
            fileReader.readFile();
        } catch (Exception e) {
            System.out.println("Problem while reading a file!");
        }

        FileReader fileReader2 = new FileReader();
        try {
            fileReader2.readFile("names.txt");
        } catch (FileReaderException e) {
            System.out.println("Problem while reading a file!");
        }
    }
}
