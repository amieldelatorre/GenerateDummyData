import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.classes.ResultingClass;
import org.classes.User;
import org.classes.Weight;
import org.randomobjects.GenerateRandom;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        GenerateRandom randomGenerator = new GenerateRandom();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number of users you want to generate: ");
        int numberOfUsers = 0;
        try {
            numberOfUsers = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("The value must be an integer!");
            System.exit(1);
        }
        if (numberOfUsers <= 0) {
            System.out.println("The value has to be an integer greater than 0!");
            System.exit(1);
        }

        System.out.println("Please enter the path for the output file: ");
        String strPath = scanner.next();
        Path path = Paths.get(strPath);

        if (Files.notExists(path)) {
            System.out.println("Path does not exist!");
            System.exit(1);
        }

        List<User> generatedUsers = randomGenerator.generateRandomUsers(numberOfUsers);
        List<List<Weight>> generatedWeightsForEachUser = new ArrayList<>();

        for (User generatedUser : generatedUsers) {
            int randomAmount = (int) Math.round(30 + 60 * Math.random());
            generatedWeightsForEachUser.add(randomGenerator.generateRandomWeights(generatedUser.getEmail(), randomAmount));
        }


        List<Weight> flatWeightsList = generatedWeightsForEachUser.stream().flatMap(List::stream).toList();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            ResultingClass results = new ResultingClass();
            results.setUsers(generatedUsers);
            results.setWeights(flatWeightsList);

            String filename = "output.json";

            mapper.writeValue(new File(strPath + "/" + filename), results);
        } catch (IOException e) {
            System.out.println("Error writing to file!");
            System.exit(1);
        }
    }
}