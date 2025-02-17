package Sumit;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        String file="src\\Sumit\\word.txt";
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        ArrayList<String>randomWord =new ArrayList<>();
        try (BufferedReader ok = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line= ok.readLine())!=null){
                randomWord.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("something went wrong");
        }
        String word = randomWord.get(ran.nextInt(0,8));
        int len = word.length(), i, noOfGuesses = 0;
        int noOfClues = ran.nextInt(1, word.length());
        ArrayList<Character> list = new ArrayList<>();
        for (i = 0; i < len; i++) {
            list.add('_');
        }
        for (i = 0; i < noOfClues; i++) {
            int ok = ran.nextInt(0, len);
            char letter = word.charAt(ok);
            for (int j = 0; j < len; j++) {
                if (word.charAt(j) == letter)
                    list.set(j, letter);
            }
        }
        while (noOfGuesses != 6) {
            HangMan obj = new HangMan(noOfGuesses);
            System.out.print(list);
            System.out.print("Enter your guess: ");
            char guess = sc.next().toLowerCase().charAt(0);
            if (list.contains(guess)) {
                System.out.println("Already has the letter");
                continue;
            } else {
                if (word.contains(Character.toString(guess))) {
                    for (i = 0; i < len; i++) {
                        if (guess == word.charAt(i)) {
                            list.set(i, guess);
                            System.out.println("correct guess!!");
                        }
                    }
                    if (!list.contains('_')) {
                        System.out.println("You wonnnnn");
                        break;
                    }
                } else noOfGuesses++;
            }
            if (noOfGuesses == 6) {
                HangMan obj2 = new HangMan(noOfGuesses);
                System.out.println("you lostt");
                System.out.println("The word was: "+word);
            }
        }
    }

    HangMan(int x) {
        switch (x) {

            case 0 -> System.out.println("""
                    
                    
                    
                    """);
            case 1 -> System.out.println("""
                      O
                    
                    
                    """);
            case 2 -> System.out.println("""
                      O
                     /
                    
                    """);
            case 3 -> System.out.println("""
                      O
                     /| 
                    
                    """);
            case 4 -> System.out.println("""
                      O
                     /|\\
                    
                    """);
            case 5 -> System.out.println("""
                      O
                     /|\\
                     /
                    """);
            case 6 -> System.out.println("""
                     O
                    /|\\
                    /\\
                    """);
        }
    }
}



