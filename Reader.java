import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Reader {

    private BufferedReader bReader;

    public Reader(InputStream Istream){
        InputStreamReader isr = new InputStreamReader(Istream);
        bReader = new BufferedReader(isr);
    }
    public String readData() throws IOException{
        return bReader.readLine();
    }
}