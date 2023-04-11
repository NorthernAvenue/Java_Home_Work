package Java.hw2;
import java.util.HashMap;
import java.util.Map;

public class Json{
    public static void main(String[] args) {
        Map<String, String> filters = new HashMap<>();
        filters.put("name", "Ivanov");
        filters.put("country", "Russia");
        filters.put("city", "Moscow");
        filters.put("age", null);

        StringBuilder whereClause = new StringBuilder();
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().equals("null")) {
                if (whereClause.length() > 0) {
                    whereClause.append(" AND ");
                }
                whereClause.append(entry.getKey()).append("='").append(entry.getValue()).append("'");
            }
        }

        String sqlQuery = "SELECT * FROM students";
        if (whereClause.length() > 0) {
            sqlQuery += " WHERE " + whereClause.toString();
        }
        System.out.println(sqlQuery);
    }
}


