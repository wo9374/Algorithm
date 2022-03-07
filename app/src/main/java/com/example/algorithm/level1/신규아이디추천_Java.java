package com.example.algorithm.level1;

public class 신규아이디추천_Java {
    public String solution(String new_id) {

        String result = "";
        for (char c: new_id.toLowerCase().toCharArray()){
            if (Character.isLetterOrDigit(c) || c == '-' || c == '_' || c == '.' )
                result += c;
        }

        while (result.contains(".."))
            result = result.replace("..", ".");

        if (!result.equals("") && result.charAt(0)=='.')
            result = result.substring(1);
        if (!result.equals("") && result.charAt(result.length()-1)=='.')
            result = result.substring(0, result.length() - 1);


        if (result.equals(""))
            result = "a";


        if (result.length() >= 16){
            result = result.substring(0,15);

            if (result.charAt(result.length()-1) == '.')
                result = result.substring(0, result.length()-1);
        }

        if (result.length() <=2){
            while (result.length() < 3){
                result += result.charAt(result.length()-1);
            }
        }

        return result;
    }
}
