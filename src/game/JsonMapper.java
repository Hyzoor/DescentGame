package game;

import game.characters.Entity;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class JsonMapper {

    public static void mapEntity(String jsonFilepath, Entity entity) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            objectMapper.readerForUpdating(entity).readValue(new File(jsonFilepath));

        } catch (JsonMappingException e) {
            System.out.println("Error while mapping JSON " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Error processing the file.json " + e.getMessage());
        }
    }
}
