package Java.hw5;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Phonebook {
    private HashMap<String, List<String>> book;

    public Phonebook() {
        book = new HashMap<String, List<String>>();
    }

    public void addPhoneNumber(String name, String number) {
        List<String> listOfNumbers;
        if (book.containsKey(name)) {
            listOfNumbers = book.get(name);
        } else {
            listOfNumbers = new ArrayList<String>();
        }
        listOfNumbers.add(number);
        book.put(name, listOfNumbers);
    }

    public void printPhoneNumbers(String name) {
        if (book.containsKey(name)) {
            List<String> listOfNumbers = book.get(name);
            System.out.println("Phone numbers for " + name + ":");
            for (String number : listOfNumbers) {
                System.out.println(number);
            }
        } else {
            System.out.println(name + " was not found in the phone book.");
        }
    }
}