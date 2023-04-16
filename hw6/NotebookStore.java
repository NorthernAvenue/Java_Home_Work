package Java.hw6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Notebook {
    private String brand;
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Notebook(String brand, String model, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }
}

public class NotebookStore {
    private List<Notebook> notebooks = new ArrayList<>();

    public void addNotebook(Notebook notebook) {
        notebooks.add(notebook);
    }

    public List<Notebook> filterNotebooks(Map<String, Object> filters) {
        List<Notebook> filteredNotebooks = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            boolean matches = true;
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                String property = filter.getKey();
                Object value = filter.getValue();
                switch (property) {
                    case "brand":
                        matches &= notebook.getBrand().equals(value);
                        break;
                    case "model":
                        matches &= notebook.getModel().equals(value);
                        break;
                    case "ram":
                        matches &= notebook.getRam() >= (int) value;
                        break;
                    case "storage":
                        matches &= notebook.getStorage() >= (int) value;
                        break;
                    case "os":
                        matches &= notebook.getOs().equals(value);
                        break;
                    case "color":
                        matches &= notebook.getColor().equals(value);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown filter property: " + property);
                }
                if (!matches) {
                    break;
                }
            }
            if (matches) {
                filteredNotebooks.add(notebook);
            }
        }
        return filteredNotebooks;
    }

    public static void main(String[] args) {
        NotebookStore store = new NotebookStore();
        store.addNotebook(new Notebook("Lenovo", "IdeaPad 3", 8, 512, "Windows 10", "Gray"));
        store.addNotebook(new Notebook("Apple", "MacBook Air", 16, 512, "MacOS", "Silver"));
        store.addNotebook(new Notebook("HP", "Pavilion", 16, 1000, "Windows 11", "Black"));
        store.addNotebook(new Notebook("Dell", "XPS 13", 16, 1000, "Ubuntu", "White"));
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();
        System.out.println("Enter the filter criteria:");
        System.out.println("1 - RAM");
        System.out.println("2 - Storage");
        System.out.println("3 - Operating System");
        System.out.println("4 - Color");
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                System.out.println("Enter the minimum RAM:");
                int ram = scanner.nextInt();
                filters.put("ram", ram);
                break;
            case "2":
                System.out.println("Enter the minimum storage:");
                int storage = scanner.nextInt();
                filters.put("storage", storage);
                break;
            case "3":
                System.out.println("Enter the operating system:");
                String os = scanner.next();
                filters.put("os", os);
                break;
            case "4":
                System.out.println("Enter the color:");
                String color = scanner.next();
                filters.put("color", color);
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
        List<Notebook> filteredNotebooks = store.filterNotebooks(filters);
        if (filteredNotebooks.isEmpty()) {
            System.out.println("No notebooks found.");
        } else {
            System.out.println("Matching notebooks:");
            for (Notebook notebook : filteredNotebooks) {
                System.out.println(notebook.getBrand() + " " + notebook.getModel() + ", RAM: " + notebook.getRam()
                        + "GB, Storage: " + notebook.getStorage() + "GB, OS: " + notebook.getOs() + ", Color: "
                        + notebook.getColor());
                scanner.close();
            }
        }
    }
}