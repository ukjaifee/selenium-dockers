package testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class dataLoader {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T getData(String path, Class<T> type) throws Exception {
     InputStream stream=dataFlight.getData(path);
       return mapper.readValue(stream, type);
    }


    public static void main(String[] args) throws Exception {
        TestingData testingData=  getData("test-data/flight-reservation/passenger-1.json", TestingData.class);

        System.out.println("City is "+ testingData.getExpectedPrice());
    }
}
