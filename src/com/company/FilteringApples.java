package com.company;

import java.awt.desktop.AppForegroundListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {
  private  static  List<Apple> apples= Arrays.asList(new Apple(150,Color.RED), new Apple(150,Color.GREEN),
            new Apple(250,Color.RED), new Apple(110,Color.GREEN),
            new Apple(50,Color.RED), new Apple(120,Color.GREEN),
            new Apple(90,Color.RED), new Apple(110,Color.GREEN),
            new Apple(60,Color.RED), new Apple(130,Color.GREEN)
  );

    public static void main(String[] args) {






        Comparator<Apple> comparateur = new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight()-a2.getWeight();
            }
        };



        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight()-a2.getWeight();
            }
        });

        for (Apple  apple: apples) {
            System.out.println(apple);
        }
        System.out.println("*************get  apples by color gree*********************");
        //--------------------------question 9------------------------------------------
        for (Apple  apple: filterGreenApples()) {
            System.out.println(apple);
        }
        System.out.println("**********version 2 o get green class static");
    // instance de class static appleColorPredicate
        AppleColorPredicate appleColorPredicate=new AppleColorPredicate();
        for (Apple  apple: filter(appleColorPredicate)) {
            System.out.println(apple);
        }
        System.out.println("**********version 2 o get green class anonyme");
        // instance de class static appleColorPredicate

        for (Apple  apple: filter(new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor()==Color.GREEN;
            }
           }
           )
           )
          {
            System.out.println(apple);
          }
        System.out.println("**********expression lambda");


        System.out.println("****************trie apples by weight******************");
        //--------------------------question 10------------------------------------------
        for (Apple  apple: filterApplesByWeight(150)) {
            System.out.println(apple);
        }
        System.out.println("***************trie version deux weight");
        for (Apple  apple: filter(new AppleWeightPredicate())){
            System.out.println(apple);
        }
        System.out.println("**********version trie version deux weight class anonyme");


        for (Apple  apple: filter(new ApplePredicate() {
                                      @Override
                                      public boolean test(Apple apple) {
                                          return apple.getWeight()>=150;
                                      }
                                  }))
        {
            System.out.println(apple);
        }
        System.out.println("****************get apples by color******************");
        //--------------------------question 1&------------------------------------------
        for (Apple  apple: filterApplesByColor(Color.RED)) {
            System.out.println(apple);
        }
        System.out.println("***************aples by color and weight");
        for (Apple  apple: filter(new AppleRedAndHeavyPredicatepermettant())){
            System.out.println(apple);
        }
        System.out.println("**********aples by color and weight class anonyme");


        for (Apple  apple: filter(new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight()>=150 && apple.getColor()==Color.RED;
            }
        }))
        {
            System.out.println(apple);
        }
    }
    public enum Color{
        RED,GREEN
    }

     public static class  Apple {
        private int weight;
        private  Color color;

         public Apple(int weight, Color color) {
             this.weight = weight;
             this.color = color;
         }

         public int getWeight() {
             return weight;
         }

         public void setWeight(int weight) {
             this.weight = weight;
         }

         public Color getColor() {
             return color;
         }

         public void setColor(Color color) {
             this.color = color;
         }

         @Override
         public String toString() {
             return "Apple{" +
                     "weight=" + weight +
                     ", color=" + color +
                     '}';
         }
     }

     // question  9
     public static List<Apple> filterGreenApples(){
      List<Apple> apples2 =new ArrayList<Apple>();
         for (Apple apple:apples) {
             if(apple.getColor() ==Color.GREEN){
                 apples2.add(apple);
           }

         }

      return apples2;
     }
     //question 10
     public static List<Apple> filterApplesByWeight(int w){
         List<Apple> apples2 =new ArrayList<Apple>();
         for (Apple apple:apples) {
             if(apple.getWeight() >= w ){
                 apples2.add(apple);
             }

         }

         return apples2;
     }
    //question 11
    public static List<Apple> filterApplesByColor(Color color){
        List<Apple> apples2 =new ArrayList<Apple>();
        for (Apple apple:apples) {
            if(apple.getColor() == color){
                apples2.add(apple);
            }

        }

        return apples2;
    }
    // interface  fonctionelle
    //question 12
    public interface  ApplePredicate extends Predicate<Apple>{

    }
//13
    public static class AppleWeightPredicate implements  ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight()>=150;

        }
    }
//14
    public static class AppleColorPredicate implements  ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return apple.getColor()==Color.GREEN;

        }
    }
    //14
    public static class AppleRedAndHeavyPredicatepermettant  implements  ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return apple.getColor()==Color.RED && apple.getWeight()>=150;

        }
    }

    public static List<Apple> filter(ApplePredicate applePredicate) {
        List<Apple> apples2 = new ArrayList<>();
        for (Apple apple : apples) {
            if (applePredicate.test(apple) == true) {
                apples2.add(apple);
            }
        }
        return apples2;
    }
// expresion lamda
    public static List<Apple> filter(Predicate<Apple> predicate) {
        List<Apple> apples2 = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple) == true) {
                apples2.add(apple);
            }
        }
        return apples2;
    }

}
