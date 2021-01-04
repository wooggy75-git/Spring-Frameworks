package com.sparta.weak04.utils;

import com.sparta.weak04.models.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class NaverShopSearch {
    public String search(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "dIHO7YieJhhWK71sUgyK");
        headers.add("X-Naver-Client-Secret", "71If2co4WH");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    public List<ItemDto> fromJSONtoItems(String result) {
        JSONObject jsonObject = new JSONObject(result);
        //System.out.println(jsonObject);
        JSONArray items = jsonObject.getJSONArray("items");
        List<ItemDto> itemDtoList = new ArrayList<>();
//        for (int i=0; i<items.length(); i++) {
//            JSONObject item = items.getJSONObject(i);
//            System.out.println(item);
//        }
        for (Object o : items) {
            JSONObject item = (JSONObject) o;
//            System.out.println(item);
//            String title = item.getString("title");
//            String images = item.getString("image");
//            int lprice = item.getInt("lprice");
//            String link = item.getString("link");
//            System.out.println(lprice);
            ItemDto itemDto = new ItemDto(item);
            itemDtoList.add(itemDto);
        }

        return itemDtoList;
    }

    public static void main(String[] args) {
        NaverShopSearch naverShopSearch = new NaverShopSearch();
        String result = naverShopSearch.search("아이맥");
    }
}
