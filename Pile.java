import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Pile{
    protected static final Logger LOGGER = Logger.getLogger(HtmlAnalyzer.class.getName());
        static {
        LOGGER.setLevel(Level.OFF);
    }
    protected ArrayList<DataPad> pile;
    public Pile(){
        this.pile= new ArrayList<>();
    }
    public void add(DataPad tmp){
        LOGGER.info("Dado: " + tmp.getData() + ", de nivel: " + tmp.getLevel() + ", e tipo: " + tmp.getType());
        LOGGER.info("Tamanho da pilha é: " + pile.size());
        pile.add(tmp);
    }
    public void pop(){
        if(!pile.isEmpty()){
            DataPad tmp = pile.get(pile.size()-1);
            LOGGER.info("Dado: " + tmp.getData() + ", de nivel: " + tmp.getLevel() + ", e tipo: " + tmp.getType());
            pile.remove(pile.size()-1);
        }
        LOGGER.info("Tamanho da pilha é: " + pile.size());
    }
    public DataPad getElement(){
        DataPad data = pile.get(getSize()-1);
        return data;
    }
    public int getSize(){
        return this.pile.size();
    }
    public ArrayList<DataPad> getPile() {
        return pile;
    }
    public void restartPile(){
        while(pile.size()>0){
            pop();
        }
        LOGGER.info("Pilha foi reiniciada.");
    }
    public void dataTreat(DataPad data){
        LOGGER.info("Pilha esta tratando um dado.");
    }
}