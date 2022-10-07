package org.classes;

import org.junit.jupiter.api.Test;
import org.randomobjects.GenerateRandom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testEquals() {
        User user1 = new User();
        user1.setFirstName("test1");
        user1.setLastName("tester1");
        user1.setPassword("testing");
        user1.setEmail("test1.tester1@email.com");
        Date dob1 = new Date(-547864502122L);
        user1.setDateOfBirth(dob1);
        user1.setGender(0);
        user1.setProvider(0);
        user1.setUnits(0);

        User user2 = new User();
        user2.setFirstName("test1");
        user2.setLastName("tester1");
        user2.setPassword("testing");
        user2.setEmail("test1.tester1@email.com");
        user2.setDateOfBirth(dob1);
        user2.setGender(0);
        user2.setProvider(0);
        user2.setUnits(0);

        User user3 = new User();
        user3.setFirstName("test3");
        user3.setLastName("tester3");
        user3.setPassword("testing");
        user3.setEmail("test3.tester3@email.com");
        Date dob2 = new Date(-547864502122L);
        user3.setDateOfBirth(dob2);
        user3.setGender(0);
        user3.setProvider(0);
        user3.setUnits(0);

        User user4 = user1;

        assert (!user1.equals(user3));
        assert (user1.equals(user2));
        assert (user1.equals(user4));
    }

    @Test
    void testEqualsList() {
        User user1 = new User();
        user1.setFirstName("test1");
        user1.setLastName("tester1");
        user1.setPassword("testing");
        user1.setEmail("test1.tester1@email.com");
        Date dob1 = new Date(-547864502122L);
        user1.setDateOfBirth(dob1);
        user1.setGender(0);
        user1.setProvider(0);
        user1.setUnits(0);

        User user2 = new User();
        user2.setFirstName("test2");
        user2.setLastName("tester2");
        user2.setPassword("testing");
        user2.setEmail("test2.tester2@email.com");
        user2.setDateOfBirth(dob1);
        user2.setGender(0);
        user2.setProvider(0);
        user2.setUnits(0);

        User user3 = new User();
        user3.setFirstName("test3");
        user3.setLastName("tester3");
        user3.setPassword("testing");
        user3.setEmail("test3.tester3@email.com");
        Date dob2 = new Date(-547864502122L);
        user3.setDateOfBirth(dob2);
        user3.setGender(0);
        user3.setProvider(0);
        user3.setUnits(0);

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        User user4 = user1;

        User user5 = new User();
        user5.setFirstName("test1");
        user5.setLastName("tester1");
        user5.setPassword("testing");
        user5.setEmail("test1.tester1@email.com");
        user5.setDateOfBirth(dob1);
        user5.setGender(0);
        user5.setProvider(0);
        user5.setUnits(0);

        User user6 = new User();
        user6.setFirstName("test6");
        user6.setLastName("tester6");
        user6.setPassword("testing");
        user6.setEmail("test6.tester6@email.com");
        user6.setDateOfBirth(dob1);
        user6.setGender(0);
        user6.setProvider(0);
        user6.setUnits(0);


        assert (userList.contains(user4));
        assert (userList.contains(user5));
        assert (!userList.contains(user6));

    }
}