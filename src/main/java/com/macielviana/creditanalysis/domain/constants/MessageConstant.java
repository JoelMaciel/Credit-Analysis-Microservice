package com.macielviana.creditanalysis.domain.constants;

public class MessageConstant {

    public static final String CLIENT_NEGATIVE = "Operation not permitted. Customer %s with negative name";

    public static final String POINT_SCORE_DOWN = "Operation not permitted. Customer %s with score below 200 points";

    private MessageConstant() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
