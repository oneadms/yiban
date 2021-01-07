package com.builder.yiban;

public class ImageDetails implements java.io.Serializable{

    private final String name;
    private final String studnetID;
    private final String reason;
    private final String date;
    private final String[] vector;
    private int index = 0;
    public ImageDetails(String name, String studnetID, String reason, String date) {
        this.name = name;
        this.studnetID = studnetID;
        this.reason = reason;
        this.date = date;
        vector = new String[]{name,studnetID,reason,date};
    }
    public String next(){

        return vector[index++];
    }

    public String getName() {
        return name;
    }

    public String getStudnetID() {
        return studnetID;
    }

    public String getReason() {
        return reason;
    }

    public String getDate() {
        return date;
    }
}
