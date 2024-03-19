import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Connection {
    public InputStream connect(URL url) throws IOException {
        try{
            url.openConnection();
            return url.openStream();
        }catch(Exception e){
            System.out.println(e);
            System.exit(1);
        }
        return null;
    }
}