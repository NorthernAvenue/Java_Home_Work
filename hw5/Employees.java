package Java.hw5;

import java.util.*;

public class Employees {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList(
                "Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов",
                "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников",
                "Петр Петин", "Иван Ежов");

        HashMap<String, Integer> map = new HashMap<>();
        for (String employee : employees) {
            String[] fullName = employee.split(" ");
            String firstName = fullName[0];
            Integer count = map.get(firstName);
            map.put(firstName, (count == null) ? 1 : count + 1);
        }

        List<Map.Entry<String, Integer>> sortedList = new LinkedList<>(map.entrySet());
        Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
