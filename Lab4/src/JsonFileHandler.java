import java.io.*;
import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileHandler {
    ObjectMapper mapper = new ObjectMapper();
    Statement_Handler statementHandler = new Statement_Handler();

    public void readFile() {
        try {
            JsonNode root = mapper.readTree(new File("src/file.json"));
            if (root.isArray()) {
                for (JsonNode node : root) {
                    String date = node.get("date").asText();
                    int amount = node.get("amount").asInt();
                    String description = node.get("description").asText();
                    statementHandler.addTransaction(new Statement(date, amount, description));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JsonFileHandler fileHandler = new JsonFileHandler();
        fileHandler.readFile();
    }
}