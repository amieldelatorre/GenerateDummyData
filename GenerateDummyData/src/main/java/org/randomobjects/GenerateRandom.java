package org.randomobjects;

import org.classes.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenerateRandom {

    public List<Weight> generateRandomWeights(String userEmail, int amount) {
        List<Weight> randomWeights = new ArrayList<Weight>();


        return randomWeights;
    }

    public List<User> generateRandomUsers(int amount) {
        List<User> randomUsers = new ArrayList<User>();

        if (amount <= 0)
            throw new RuntimeException();

        randomUsers.add(generateRandomUser());

        while (amount - randomUsers.size() != 0) {
            User newRandomUser = generateRandomUser();
            if (!randomUsers.contains(newRandomUser))
                randomUsers.add(newRandomUser);
        }

        return randomUsers;
    }

    public Weight generateRandomWeight(double startingWeight, boolean weightIncreasing, String userEmail) {
        Weight randomWeight = new Weight();
        randomWeight.setUnits(0);
        randomWeight.setUserEmail(userEmail);

        double changeMagnitude = 0.25 * Math.random();
        if (weightIncreasing)
            randomWeight.setPoundage(startingWeight + changeMagnitude);
        else
            randomWeight.setPoundage(startingWeight - changeMagnitude);

        return randomWeight;
    }

    public User generateRandomUser() {
        User randomUser = new User();
        GenerateRandomName randomNames = new GenerateRandomNameWithFile();
        int passwordLength = (int)(8 + 8 * Math.random()) ;
        String randomPassword = RandomPassword.RandomString(passwordLength);
        Date currentDate = new Date();

        long epochMs = currentDate.getTime();
        long msFor18Years = 1000L * 60 * 60 * 24 * 7 * 52 * 18;
        Date randomDate = new Date((long) ((epochMs - msFor18Years) - (epochMs * Math.random())));

        randomUser.setFirstName(randomNames.generateRandomFirstName());
        randomUser.setLastName(randomNames.generateRandomLastName());
        randomUser.setPassword(randomPassword);
        randomUser.setEmail(String.format("%s.%s@email.com", randomUser.getFirstName().toLowerCase(),
                randomUser.getLastName().toLowerCase()));
        randomUser.setDateOfBirth(randomDate);
        randomUser.setGender((int) Math.round(Math.random()));
        randomUser.setProvider(0);
        randomUser.setUnits(0);
        return randomUser;
    }
}
