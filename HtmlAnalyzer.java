import java.io.IOException;
import java.net.URL;

public class HtmlAnalyzer {

    public void main(String[] args) throws IOException {
        if (seHouverArgumento(args)) {
            Reader reader = new Reader(new Connection().connect(new URL(args[0])));
            analiser(reader);
        }
    }

    public void analiser(Reader reader) throws IOException{
        String line;
        PilePad pile = new PilePad();
        PileData pileHigherText = new PileData();
        DataPad textToignore = new DataPad("", -1, TiposDataPad.texto);
        line = reader.readData();
        pileHigherText.add(textToignore);
        do {
            DataPad data = DataPad.parse(line, pile.getSize());
            if(analisaSeDataTipoTexto(data)){
                pileHigherText.dataTreat(data);
            }else{
                pile.dataTreat(data);
            }
            line = reader.readData();
        } while (seFimDoHtml(line));
        for (DataPad dataPad : pileHigherText.getPile()) {
            System.out.println(dataPad.getData());
        }
    }
    public boolean analisaSeDataTipoTexto(DataPad data){
        return data.getType()==TiposDataPad.texto;
    }
    public boolean seFimDoHtml(String line){
        return line != null;
    }
    public boolean seHouverArgumento(String[] args){
        return args.length != 0;
    }
}