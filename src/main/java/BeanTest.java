import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;

public class BeanTest {
    public static void main(String[] args) throws JsonProcessingException {
        // ObjectMapper will print it out in JSON format
        ObjectMapper mapper = new ObjectMapper(); // from new jackson-databind dependency in pom.xl from Steve
        Album theStruts = new Album(
                35,
                "The Struts",
                "Everybody Wants",
                2014,
                75,
                "Rock");

        Author mitchAlbom = new Author(
                6,
                "Mitch",
                "Albom"
        );

        Author arthurMorgan = new Author(
                7,
                "Arthur",
                "Morgan"
        );

        Quote albom = new Quote(
                11,
                "Each of us was in your life for a reason.",
                mitchAlbom
        );

        Quote morgan = new Quote(
                11,
                "Atta girl.",
                arthurMorgan
        );

        ArrayList<Quote> authorQuotes = new ArrayList<>(Arrays.asList(albom, morgan));

        // this would be how to put the objects into an array so you can loop through them, then sout!
//        ArrayList<Album> albums = new ArrayList<>(Arrays.asList(theStruts));

        // this is how you would use ObjectMapper (the newest dependency in pom.xl)
        // will display it all in JSON format!
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(albom));

    }
}
