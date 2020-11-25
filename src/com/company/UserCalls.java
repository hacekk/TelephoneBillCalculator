package com.company;

import java.time.LocalDateTime;

public class UserCalls {

    private long phoneNum;
    private LocalDateTime callStart;
    private LocalDateTime callEnd;

    public UserCalls(long phoneNum, LocalDateTime callStart, LocalDateTime callEnd) {
        this.phoneNum = phoneNum;
        this.callStart = callStart;
        this.callEnd = callEnd;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public LocalDateTime getCallStart() {
        return callStart;
    }

    public LocalDateTime getCallEnd() {
        return callEnd;
    }


}
