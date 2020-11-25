package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserCallsCollection {


    private String phoneLog;
    private List<UserCalls> userCallsList = new ArrayList<>();

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");



    public List<UserCalls> createUserCallsCollection(String phoneLog){

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(phoneLog));

            String line;
            long phoneNum;
            LocalDateTime callStart;
            LocalDateTime callEnd;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                phoneNum = Long.parseLong(data[0]);
                callStart = LocalDateTime.parse(data[1],dateFormatter);
                callEnd = LocalDateTime.parse(data[2],dateFormatter);

                userCallsList.add(new UserCalls(phoneNum,callStart,callEnd));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not found :" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userCallsList;

    }


}
