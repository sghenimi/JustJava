package com.mycompany.exemples;

import java.util.Scanner;

/**
 * class Shape
 * */
abstract class Shape {
    int width;
    abstract void area();
};

/**
 * class Square
 * */
class Square extends Shape{
    public Square(int w){
        this.width = w;
    }
    public void area(){
        System.out.println("## Square : " + this.width * this.width);
    }
}
/**
 * class Circle
 * */
class Circle extends Shape{
    public Circle(int w){
        this.width = w;
    }
    public void area(){
        System.out.println("## Circle : " + Math.PI * this.width * this.width);
    }
}

/**
 * Main class test
 * */
class Program {
    public static void main(String[ ] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        Square a = new Square(x);
        Circle b = new Circle(y);
        a.area();
        b.area();
    }
}
