package com.company;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Bill implements TelephoneBillCalculator{


    UserCallsCollection userCallsCollection = new UserCallsCollection();
    private DateTimeFormatter dateFormatterHours = DateTimeFormatter.ofPattern("HH:mm:ss");

    LocalTime startFull = LocalTime.of(8,0,0);
    LocalTime endFull = LocalTime.of(16,0,0);

    private double rate = 1.00;
    private double reducedRate = 0.50;


    @Override
    public BigDecimal calculate(String phoneLog) {

        List<UserCalls> userCallsList = userCallsCollection.createUserCallsCollection(phoneLog);

        long price = 0;


        for (UserCalls userCalls:userCallsList){

            if((userCalls.getCallStart().isAfter(ChronoLocalDateTime.from(startFull)) || userCalls.getCallStart().equals(startFull)) &&
              (userCalls.getCallEnd().isBefore(ChronoLocalDateTime.from(endFull)) || userCalls.getCallEnd().equals(endFull))){

                price += (userCalls.getCallStart().until(userCalls.getCallEnd(), ChronoUnit.MINUTES)) * rate;


            }else{
                price += (userCalls.getCallStart().until(userCalls.getCallEnd(), ChronoUnit.MINUTES)) * reducedRate;
            }

        }

        return BigDecimal.valueOf(price);
    }
}
