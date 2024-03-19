public class PilePad extends Pile {
    public void dataTreat(DataPad data){
        super.dataTreat(data);
        if(data.getType()==TiposDataPad.abertura){
            LOGGER.info("Pilha adicionou um dado.");
            pile.add(data);
            return;
        }
        else if(getElement().getData().equals(data.getData())==true){
            LOGGER.info("Pilha removeu um dado.");
            pop();
        }
        else{
            LOGGER.info("Pilha encontrou um erro no HTML.");
            System.out.println("malformed HTML");
            System.exit(1);
        }
    }
}
