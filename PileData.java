public class PileData extends Pile{
    @Override
    public void dataTreat(DataPad data) {
        super.dataTreat(data);
        if(isLevelEquals(data)){
            restartPile();
            add(data);
        }else if(isLevelBigger(data)){
            add(data);
        }
    }
    public boolean isLevelEquals(DataPad data){
        return data.getLevel()==getElement().getLevel();
    }
    public boolean isLevelBigger(DataPad data){
        return data.getLevel()==getElement().getLevel();
    }
}