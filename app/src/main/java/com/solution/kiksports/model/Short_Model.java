package com.solution.kiksports.model;

public class Short_Model {
    private String Title;
    private String Url;

    public Short_Model(String title, String url) {
        Title = title;
        Url = url;
    }

    public String getTitle() {
        return Title;
    }

    public String getUrl() {
        return Url;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
