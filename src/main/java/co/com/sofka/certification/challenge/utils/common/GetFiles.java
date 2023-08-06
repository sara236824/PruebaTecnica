package co.com.sofka.certification.challenge.utils.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GetFiles {

    public static String getFile(String fileroute) throws IOException{
        return new String(Files.readAllBytes(Paths.get(fileroute)));
    }
}
