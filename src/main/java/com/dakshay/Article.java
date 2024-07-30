package com.dakshay;


import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
public class Article {

    private String id;
    private String title;
    private String excerpt;
    private List<Tag> tags;
    private List<Category> categories;
    private Long createdAt;
    private Long updatedAt;

}
