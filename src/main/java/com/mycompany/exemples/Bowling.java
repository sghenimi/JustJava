package com.mycompany.exemples;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Bowling {
    HashMap<String, Integer> players;

    Bowling() {
        players = new HashMap<String, Integer>();
    }

    public void addPlayer(String name, int p) {
        players.put(name, p);
    }

    public void getWinner() {
        Map.Entry<String, Integer> max_e = null;
        for (Map.Entry<String, Integer> e : players.entrySet()) {

            if ( (max_e == null) ||(e.getValue()).compareTo(max_e.getValue()) > 0)
                max_e = e;
        }

        System.out.println(max_e.getKey());
    }

    public void getWinnerJava8() {
        // players.forEach((kp,vp) -> System.out.println( kp + " : " + vp));
        /*First Method*/
        //String maxValPlayers = players.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        /*Second method*/
        String maxValPlayers = Collections.max(players.entrySet(), Map.Entry.comparingByValue()).getKey();
         System.out.println(maxValPlayers);
    }

}
class ProgramBowling {
    public static void main(String[] args) {
        Bowling game = new Bowling();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            String input = sc.nextLine();
            String[] values = input.split(" ");
            String name = values[0];
            int points = Integer.parseInt(values[1]);
            game.addPlayer(name, points);
        }
        System.out.println( "### Players : "+ game.players);
        game.getWinnerJava8();
    }
}