package org.randomobjects;

import org.classes.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GenerateRandom {

    public List<Weight> generateRandomWeights(String userEmail, int amount) {
        List<Weight> randomWeights = new ArrayList<Weight>();

        Random random = new Random();

        boolean weightIncreasing = random.nextBoolean();
        double startingWeight = 40 + 60 * Math.random();

        // Generate first weight
        Weight firstWeight = new Weight();
        firstWeight.setEmail(userEmail);
        firstWeight.setPoundage(startingWeight);
        firstWeight.setUnits(0);
        LocalDate localDate = LocalDate.now(ZoneId.systemDefault()).minusDays(amount);
        Date date = java.sql.Date.valueOf(localDate);
        firstWeight.setDate(date);

        randomWeights.add(firstWeight);
        for (int i = 1; i < amount; i++)
            randomWeights.add(generateRandomWeight(randomWeights.get(i-1).getPoundage(), weightIncreasing, userEmail, amount-i));

        return randomWeights;
    }

    public Weight generateRandomWeight(double previousWeight, boolean weightIncreasing, String userEmail, int toSubtractFromDate) {
        Weight randomWeight = new Weight();
        randomWeight.setUnits(0);
        randomWeight.setEmail(userEmail);

        double changeMagnitude = 0.5 * Math.random();
        if (weightIncreasing)
            randomWeight.setPoundage(previousWeight + changeMagnitude);
        else
            randomWeight.setPoundage(previousWeight - changeMagnitude);

        LocalDate localDate = LocalDate.now(ZoneId.systemDefault()).minusDays(toSubtractFromDate);
        Date date = java.sql.Date.valueOf(localDate);
        randomWeight.setDate(date);

        return randomWeight;
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
