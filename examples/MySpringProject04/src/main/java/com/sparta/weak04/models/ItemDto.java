package com.sparta.weak04.models;

import lombok.Getter;
import org.json.JSONObject;

@Getter
public class ItemDto {
    private String title;
    private String image;
    private String link;
    private int lprice;

    public ItemDto(JSONObject item) {
        this.title = item.getString("title");
        this.image = item.getString("image");
        this.link = item.getString("link");
        this.lprice = item.getInt("lprice");
    }
}
