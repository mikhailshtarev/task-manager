package com.example.taskmanager.entity;

public enum ParserEnum {
    CLIENT("Chrome/4.0.249.0 Safari/532.5"),
    REFERER("http://www.google.com");
    private String value;

   private ParserEnum (String value){
       this.value=value;
   }

    public String getValue() {
        return value;
    }
}
