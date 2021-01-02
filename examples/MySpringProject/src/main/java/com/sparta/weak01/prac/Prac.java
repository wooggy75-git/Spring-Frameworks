package com.sparta.weak01.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac {

    public static int countFruit(String fruit) {
        List<String> fruits = new ArrayList<>();
        fruits.add("감");
        fruits.add("배");
        fruits.add("감");
        fruits.add("딸기");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("딸기");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("감");

        int count = 0;
        for (String item : fruits) {
            if (item == fruit) count++;
            //if (item.equals(fruit)) count++;
        }

        return count;
    }

     public static void main(String[] args) {
         Course course = new Course();
         course.title = "웹개발의 봄, Spring";
         course.tutor = "남병광";
         System.out.println(course.title);
         System.out.println(course.tutor);

         String title = "프론트엔드의 꽃, React";
         String tutor = "임민영";
         Course course2 = new Course(title, tutor, 44);
         System.out.println(course2.title);
         System.out.println(course2.tutor);
         System.out.println(course2.days);
    }
}
