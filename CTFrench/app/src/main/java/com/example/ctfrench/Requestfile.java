package com.example.ctfrench;

public class Requestfile {
    public static String request_treatment(String input) {
        if (input.length() > 1){
            return "warning";
        }

        if (input.equals("a")) {
            return "c";
        }

        if (input.equals("b")) {
            return "g";
        }

        if (input.equals("c")) {
            return "k";
        }

        if (input.equals("d")) {
            return "w";
        }

        if (input.equals("e")) {
            return "m";
        }

        if (input.equals("f")) {
            return "u";
        }if (input.equals("g")) {
            return "z";
        }

        if (input.equals("h")) {
            return "a";
        }

        if (input.equals("i")) {
            return "l";
        }

        if (input.equals("j")) {
            return "y";
        }

        if (input.equals("k")) {
            return "o";
        }

        if (input.equals("l")) {
            return "t";
        }

        if (input.equals("m")) {
            return "e";
        }

        if (input.equals("n")) {
            return "h";
        }

        if (input.equals("o")) {
            return "v";
        }

        if (input.equals("p")) {
            return "n";
        }

        if (input.equals("q")) {
            return "p";
        }

        if (input.equals("r")) {
            return "f";
        }

        if (input.equals("s")) {
            return "q";
        }

        if (input.equals("t")) {
            return "b";
        }

        if (input.equals("u")) {
            return "i";
        }

        if (input.equals("v")) {
            return "r";
        }

        if (input.equals("w")) {
            return "s";
        }

        if (input.equals("x")) {
            return "j";
        }

        if (input.equals("y")) {
            return "d";
        }

        if (input.equals("z")) {
            return "x";
        }

        if (input.equals("-")) {
            return "_";
        }


        return "";
    }

}
