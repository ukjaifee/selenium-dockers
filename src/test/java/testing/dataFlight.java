package testing;

import net.bytebuddy.dynamic.scaffold.TypeWriter;

import java.io.InputStream;
import java.nio.file.Path;

public class dataFlight {

    public static InputStream getData(String path) throws Exception{
        InputStream stream=dataFlight.class.getClassLoader().getResourceAsStream(path);
        return stream;

    }
}
