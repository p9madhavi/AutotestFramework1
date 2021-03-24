package utils;

import domain.User;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.testng.CommandLineArgs.LOG;

public class TestDataProvider {


    public static Logger LOG = Logger.getLogger(TestDataProvider.class);
    File VALID_USER_FILE = new File("src\\test\\resources\\testData\\validUsers.csv");
    File INVALID_USER_FILE = new File("src\\test\\resources\\testData\\invalidUsers.csv");
    List<User> validUsers = new ArrayList<User>();
    List<User> inValidUsers = new ArrayList<User>();
    Random rnd = new Random();
    User aUser;

    public TestDataProvider() {
        LOG.debug("Inside the TestDataProvider Method");
        if (validUsers.size()==0) {
            LOG.debug("Valid Users size" + validUsers.size());
            populateValidUsers();
        }
        LOG.debug("Inside the TestDataProvider invalid user ");
        if(inValidUsers.size()==0){
            LOG.debug("InValid Users size" + inValidUsers.size());
            populateInValidUsers();
        }
    }

    public User getValidUser() {
        LOG.debug("validUsers.size()" + validUsers.size());
        int validUserIndex = rnd.nextInt(validUsers.size());
        return validUsers.get(validUserIndex);

    }
    public User getInValidUser(){
        LOG.debug("invalidUsers.size()" + inValidUsers.size());
        int inValidUserIndex = rnd.nextInt(inValidUsers.size());
        return inValidUsers.get(inValidUserIndex);
    }

    private void populateValidUsers() {
        //file read
        //convert them into user list
//        LOG.debug("Before Try Block");
        try {
           List<String > lines = FileHelper.readValidFile(VALID_USER_FILE);
//            LOG.debug("lines size" + lines.size());

            User aUser;
            for (String line : lines) {
                if (!line.contains("##")) {
                    aUser = new User();
                    aUser.setUserName(line.split(",")[0]);
                    aUser.setPwd(line.split(",")[1]);
                    validUsers.add(aUser);
                }
            }
        } catch (IOException exp) {
            System.out.println("IO Exception");
        }
    }
    private void populateInValidUsers() {
        LOG.debug("Before Try Block for invaliduser");
        try {
            List<String > lines = FileHelper.readInValidFile(INVALID_USER_FILE);

            LOG.debug("lines size" + lines.size());

            User aUser;
            for (String line : lines) {
                if (!line.contains("##")) {
                    aUser = new User();
                    aUser.setUserName(line.split(",")[0]);
                    aUser.setPwd(line.split(",")[1]);
                    inValidUsers.add(aUser);
                }
            }
        } catch (IOException exp) {
            System.out.println("IO Exception");
        }
    }
}
