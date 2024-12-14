package game;

import game.characters.Entity;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * A utility class that deserializes a JSON file and maps its data to an entity object.
 *
 * This class is responsible for converting a JSON file into a Java object, enabling the
 * creation of game entities from JSON data.
 */
public class JsonMapper {

    /**
     * Maps the content of a JSON file to an object.
     *
     * This method reads a JSON file and updates the provided object with the data
     * contained in the file. It uses the Jackson library for JSON deserialization.
     *
     * @param jsonFilepath The file path of the JSON file to deserialize.
     * @param object The object to be updated with the deserialized data.
     * @param <T> The type of object to be mapped.
     */
    public static <T> void mapObject(String jsonFilepath, T object) {

        // Create an instance of the ObjectMapper to handle the deserialization
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read and update the object with the data from the JSON file
            objectMapper.readerForUpdating(object).readValue(new File(jsonFilepath));

        } catch (JsonMappingException e) {
            // Handle errors related to JSON mapping
            System.err.println("Error while mapping JSON " + e.getMessage());

        } catch (IOException e) {
            // Handle errors related to file processing
            System.err.println("Error processing the file.json " + e.getMessage());
        }
    }
}
