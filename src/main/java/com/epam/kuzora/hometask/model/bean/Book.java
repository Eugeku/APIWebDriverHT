package com.epam.kuzora.hometask.model.bean;

public class Book {

    private Integer ID;
    private String Title;
    private String Description;
    private Integer PageCount;
    private String Excerpt;
    private String PublishDate;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getPageCount() {
        return PageCount;
    }

    public void setPageCount(Integer pageCount) {
        PageCount = pageCount;
    }

    public String getExcerpt() {
        return Excerpt;
    }

    public void setExcerpt(String excerpt) {
        Excerpt = excerpt;
    }

    public String getPublishDate() {
        return PublishDate;
    }

    public void setPublishDate(String publishDate) {
        PublishDate = publishDate;
    }
}
