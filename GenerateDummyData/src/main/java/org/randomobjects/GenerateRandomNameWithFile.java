package org.randomobjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateRandomNameWithFile implements GenerateRandomName {
    private static final String firstNamesFileName = "FirstNames.txt";
    private static final String lastNamesFileName = "LastNames.txt";

    @Override
    public String generateRandomFirstName() {
        String firstName;
        try {
            firstName = generateRandomName(firstNamesFileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return firstName;
    }

    @Override
    public String generateRandomLastName() {
        String lastName;
        try {
            lastName = generateRandomName(lastNamesFileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return lastName;
    }

    private String generateRandomName(String filename) throws FileNotFoundException {
        URL local = this.getClass().getResource("");
        String pathToThisClass = local.getPath();
        int startIndexOfOrgFolder = pathToThisClass.indexOf("classes");
        int endIndexOfOrgFolder = startIndexOfOrgFolder + 7;

        String pathToNamesFile = pathToThisClass.substring(0, endIndexOfOrgFolder + 1) + filename;
        File namesFile = new File(pathToNamesFile);
        Scanner scanner = new Scanner(namesFile);
        List<String> nameList = new ArrayList<String>();

        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            nameList.add(name);
        }
        int randomIndex = (int) (nameList.size() * Math.random());
        return nameList.get(randomIndex);
    }
}
