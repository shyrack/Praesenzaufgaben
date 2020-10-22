package jahn.florian.praesenzaufgaben.drei.zusatzaufgabe;

import jahn.florian.praesenzaufgaben.drei.Index;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {

        Index index = new Index();

        try (BufferedReader reader = new BufferedReader(new FileReader("zauberlehrling.txt"))) {

            String line;
            int lineIndex = 0;

            while ((line = reader.readLine()) != null) {

                lineIndex++;
                String[] words = line.split(" ");

                for (String word : words) {

                    if (word.length() > 0) {

                        char firstLetter = word.charAt(0);

                        if ((word.length() > 3) && (((int) firstLetter <= 90) && ((int) firstLetter >= 65))) {

                            index.wortHinzufuegen(word, lineIndex);
                        }
                    }
                }
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        System.out.println(index);

    }

}