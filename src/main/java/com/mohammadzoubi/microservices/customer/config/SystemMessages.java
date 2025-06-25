package com.mohammadzoubi.microservices.customer.config;

public class SystemMessages {
    //Bad Requests Messages
    public static final String CUSTOMER_NAME_NOT_BLANK_MESSAGE = "Customer name must not be blank. ";
    public static final String CUSTOMER_NAME_MAX_SIZE_MESSAGE =
            "Customer name max "
                    + SystemConfig.CUSTOMER_NAME_MAX_SIZE
                    + "characters";
    public static final String PHONE_NUMBER_MAX_SIZE_MESSAGE =
            "Phone number max "
                    + SystemConfig.PHONE_NUMBER_MAX_SIZE
                    + " digits.";
    public static final String INVALID_EMAIL_MESSAGE = "Invalid email";
}
