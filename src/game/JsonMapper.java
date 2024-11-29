package game;

import game.characters.Entity;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Deserialize json file and creates an entity object
 */
public class JsonMapper {

    /**
     * Method to map the info in json file to the entity object
     * @param jsonFilepath File path of the json file to deserialize
     * @param object Object that stores the mapped information
     * @param <T> Object Type to be mapped
     */
    public static <T> void mapObject(String jsonFilepath, T object) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            objectMapper.readerForUpdating(object).readValue(new File(jsonFilepath));

        } catch (JsonMappingException e) {
            System.err.println("Error while mapping JSON " + e.getMessage());

        } catch (IOException e) {
            System.err.println("Error processing the file.json " + e.getMessage());
        }
    }
}
