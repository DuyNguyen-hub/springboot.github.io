package com.spring.cookie.model;

public class Color {
    private String bgColor;
    private String ftColor;
    private String ftSize;

    public Color(){}
    public Color(String bgColor, String ftColor, String ftSize) {
        this.bgColor = bgColor;
        this.ftColor = ftColor;
        this.ftSize = ftSize;
    }
    public String getBgColor() {
        return bgColor;
    }
    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
    public String getFtColor() {
        return ftColor;
    }
    public void setFtColor(String ftColor) {
        this.ftColor = ftColor;
    }
    public String getFtSize() {
        return ftSize;
    }
    public void setFtSize(String ftSize) {
        this.ftSize = ftSize;
    }

    
}
