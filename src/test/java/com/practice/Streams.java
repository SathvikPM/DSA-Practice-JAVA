package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        //create a list
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //converting list to Stram
        Stream<Integer> listSteam1 =list.stream();
        //printing the Stram
//        System.out.println("printing Stream Elements");
//        listSteam.forEach(n->System.out.print(n+" "));  //once the stream is used  with terminal Operation we cant able to use again
        filterEvenStrems(listSteam1);

       //problem 2
        List<Integer> list2= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Stream<Integer> listStream2=list2.stream();

        converttoSquare(listStream2);
        //problem 3
        List<Integer> list3= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Stream<Integer> listStream3=list3.stream();

        squareEvenNumbersFromStream(listStream3);
        //problem 4
        List<Integer> list4= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Stream<Integer> listStream4=list4.stream();

        squareEvenNumbersFromStreamAndPrintOnlySquares(listStream4);

        //problem 5
        List<Integer> list5= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);

        Stream<Integer> listStream5=list5.stream();

        findFirstNumberGreaterThan10(listStream5);


        //problem 6
        List<Integer> list6= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);

        Stream<Integer> listStream6=list6.stream();

        countElementsGreaterThanFive(listStream6);

        //problem 7
        List<Integer> list7= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);

        Stream<Integer> listStream7=list7.stream();

        countElementsGreaterThanFive(listStream7);

        //problem 8
        List<Integer> list8= Arrays.asList(1,2,3,4,5);

        Stream<Integer> listStream8=list8.stream();

        productOfAllElemets(listStream8);

        //problem 9
        List<Integer> list9= Arrays.asList(1,2,3,4,5);

        Stream<Integer> listStream9=list9.stream();

        sumOfAllElemets(listStream9);


        //problem 10
        List<Integer> list10= Arrays.asList(1,2,3,4,5);

        Stream<Integer> listStream10=list10.stream();

        sumOfAllEvenElemets(listStream10);








    }
    public  static  void filterEvenStrems(Stream<Integer> stream){

        Stream<Integer> evenStream=stream.filter(n->n%2==0);
        System.out.println("printing filtered  Stream Elements");

        evenStream.forEach(n->System.out.print(n+" "));
        System.out.println();

    }
    public  static  void converttoSquare(Stream<Integer> stream){

        Stream<Integer> squaredStream=stream.map(n->n*n);
        System.out.println("printing squared  Stream Elements");
        squaredStream.forEach(n->System.out.print(n+" "));
        System.out.println();

    }

    public  static  void squareEvenNumbersFromStream(Stream<Integer> stream){

       Stream<Integer> evenSquaredStream=stream.map(n->n%2==0 ? n*n : n );
        System.out.println("printing squared even   Stream Elements");

        evenSquaredStream.forEach(n->System.out.print(n +" "));
        System.out.println();
    }

    public  static  void squareEvenNumbersFromStreamAndPrintOnlySquares(Stream<Integer> stream){

        Stream<Integer> evenStream=stream.filter(n->n%2==0);
        Stream<Integer> squaredStream=evenStream.map(n->n*n);
        List<Integer> squaredlist=squaredStream.toList(); //converting Stream to list
        System.out.println("printing squared even   Stream Elements");
        System.out.print(squaredlist);
        System.out.println();

    }

    public  static  void findFirstNumberGreaterThan10(Stream<Integer> stream){

        Stream<Integer> filteredStream=stream.filter(n->n>10);
        Optional<Integer> first =filteredStream.findFirst();
        System.out.println("printing first element greater than 10");
        System.out.println(first.get());
        System.out.println();




    }

    public  static  void countElementsGreaterThanFive(Stream<Integer> stream){

        Stream<Integer> filteredStream=stream.filter(n->n>5);
        Long count =filteredStream.count();
        System.out.println("printing count of the  elements greater than 5");
        System.out.println(count);
        System.out.println();

    }


    public  static  void productOfAllElemets(Stream<Integer> stream){

         int product=stream.reduce(1,(a,b)->a*b);
        System.out.println("printing product of the  elements");
        System.out.println(product);
        System.out.println();

    }

    public  static  void sumOfAllElemets(Stream<Integer> stream){

        int sum=stream.reduce(0,(a,b)->a+b);
        System.out.println("printing sum of the  elements");
        System.out.println(sum);
        System.out.println();

    }


    public  static  void sumOfAllEvenElemets(Stream<Integer> stream){

        Stream<Integer> filteredEven=stream.filter(n->n%2==0);

        int sum=filteredEven.reduce(0,(a,b)->a+b);
        System.out.println("printing sum of even elements");
        System.out.println(sum);
        System.out.println();

    }




}
