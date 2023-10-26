package org.example;

import com.groupdocs.merger.Merger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String home = System.getProperty("user.home");

        Scanner scan = new Scanner(System.in);

        System.out.println("Write first document path: ");
        String firstFile = scan.nextLine();

        System.out.println("Write second document path: ");
        String secondFile = scan.nextLine();

        int whereFirstFullName = firstFile.lastIndexOf("\\");
        String firstFullName = firstFile.substring(whereFirstFullName + 1);
        String firstName = firstFullName.split("\\.")[0];
        String firstExtension = firstFullName.split("\\.")[1];

        int whereSecondFullName = secondFile.lastIndexOf("\\");
        String secondFullName = secondFile.substring(whereSecondFullName + 1);
        String secondName = secondFullName.split("\\.")[0];

        String path = home + "\\Downloads\\" + firstName + "-and-" + secondName + "." + firstExtension;

        Merger merger = new Merger(firstFile);
        {
            merger.join(secondFile);
            merger.save(path);
        }

        System.out.println("Document is in the path: " + path);
    }
}