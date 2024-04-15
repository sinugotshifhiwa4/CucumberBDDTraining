package com.automation.steps.components;

public class HandleExceptions {

    /**
     * Method to handle exceptions and print error details.
     * @param methodName The name of the method where the exception occurred.
     * @param e The exception object containing error details.
     */
    public static void handleException(String methodName, Exception e){

        // Print a message indicating the method where the exception occurred
        System.err.println("An Exception occurred on method " + methodName + " : " + e.getMessage());
        // Print the stack trace of the exception for detailed error analysis
        e.printStackTrace();
    }
}
