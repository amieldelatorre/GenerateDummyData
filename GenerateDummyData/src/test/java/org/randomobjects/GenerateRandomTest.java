package org.randomobjects;

import org.classes.User;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateRandomTest {

    @Test
    void generateRandomWeights() {
        fail ("Not Implemented");
    }

    @Test
    void generateRandomUsers() {
        GenerateRandom random = new GenerateRandom();

        int userListSize = 5;
        List<User> randomUserList = random.generateRandomUsers(userListSize);

        assert (randomUserList.size() == userListSize);

        List<User> newList = new ArrayList<User>();
        for (int i = 0; i < randomUserList.size(); i++) {
            assert (!newList.contains(randomUserList.get(i)));
        }

    }
}