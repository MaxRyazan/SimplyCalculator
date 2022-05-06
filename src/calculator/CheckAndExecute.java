package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CheckAndExecute {
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите выражение, которое вы хотите посчитать в любом формате");
            String line = reader.readLine();
            String operation = operationConverter(line);
            double result = getResult(line, operation);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String operationConverter(String string) {
        String operation = "";
        String newLine = string.replace(" ", "");
        char[] charArr = newLine.toCharArray();
        for (char c : charArr) {
            switch (c) {
                case '+' -> operation = "+";
                case '-' -> operation = "-";
                case '*' -> operation = "*";
                case '/' -> operation = "/";
            }
        }
        return operation;
    }

    public double getResult(String inputLine, String operation) {
        double result = 0;
        String[] temp;
        String input = inputLine.replace(" ", "");
        try {
            if (checkOperation(operation)) {
                switch (operation) {
                    case ("+") -> {
                        temp = input.split("\\+");
                        result = Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]);
                    }
                    case ("-") -> {
                        temp = input.split("-");
                        result = Integer.parseInt(temp[0]) - Integer.parseInt(temp[1]);
                    }
                    case ("*") -> {
                        temp = input.split("\\*");
                        result = Integer.parseInt(temp[0]) * Integer.parseInt(temp[1]);
                    }
                    case ("/") -> {
                        temp = input.split("/");
                        if (temp[1].equals("0")) {
                            System.out.println("Ошибка! Делить на 0 нельзя!");
                            break;
                        }
                        result = (double) Integer.parseInt(temp[0]) / Integer.parseInt(temp[1]);
                    }
                }
            }
        }catch (Exception e) {
            System.out.println("Введены не корректные данные. Вводить допускается только числа и арифм.операции");
        }
        return result;
    }


    public boolean checkOperation(String operation){
        if(operation.length()==1) {
            return (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/"));
        }
        return false;
    }

}