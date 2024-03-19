import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.chart.PieChart.Data;

public class DataPad {
    private static final Logger LOGGER = Logger.getLogger(HtmlAnalyzer.class.getName());
        static {
        LOGGER.setLevel(Level.OFF);
    }
    private String data;
    private int level;
    private TiposDataPad type;
    public DataPad(String data, int level, TiposDataPad type){
        this.data=data;
        this.level=level;
        this.type=type;
    }
    public String getData() {
        return data;
    }
    public TiposDataPad getType() {
        return type;
    }
    public int getLevel() {
        return level;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setType(TiposDataPad type) {
        this.type = type;
    }
    public static boolean isEndTag(String line){
        return line.endsWith(">");
    }
    public static boolean isStartTag(String line){
        return line.startsWith("</");
    }
    public static DataPad parse(String line, int level) {
        DataPad pad;
        String data;
        line=line.replaceAll("  ", "");
        if (isEndTag(line)) {
            if(isStartTag(line)){
                pad = parseDataPadClosing(line, level);
                data = pad.getData().replace("</", "");
            }
            else{
                pad = parseDataPadOpening(line, level);
                data = pad.getData().replace("<", "");
            }
            data = data.replace(">", "");
            pad.setData(data);
        } else {
            pad = parseDataPadText(line, level);
            LOGGER.info("Dado coletado é do tipo: texto");
        }
        return pad;
    }
    public static DataPad parseDataPadClosing(String line, int level){
        LOGGER.info("Dado coletado é do tipo: fechamento");
        return new DataPad(line, level, TiposDataPad.fechamento); 
    }
    public static DataPad parseDataPadOpening(String line, int level){
        LOGGER.info("Dado coletado é do tipo: abertura");
        return  new DataPad(line, level, TiposDataPad.abertura);
    }
    public static DataPad parseDataPadText(String line, int level){
        return new DataPad(line, level, TiposDataPad.texto);
    }
}
