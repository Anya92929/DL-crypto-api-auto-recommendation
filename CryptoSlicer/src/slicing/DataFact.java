package slicing;

import soot.Unit;
import soot.Value;

import java.util.HashSet;
import java.util.Set;

public class DataFact{
    private Value value;
    private Set<Unit> genUnit;

    public DataFact(Value v){
        value = v;
        genUnit = new HashSet<Unit>();
    }

    public DataFact(Value v, Unit u){
        value = v;
        genUnit = new HashSet<Unit>();
        genUnit.add(u);
    }
    public void addGenUnit(Unit u){
        genUnit.add(u);
    }
    public void mergeGenUnit(DataFact data){
        assert this.equals(data);
        genUnit.addAll(data.getGenUnit());

    }






    public Value getValue(){
        return value;
    }
    public Set<Unit> getGenUnit(){
        return genUnit;
    }


    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            DataFact dataFact = (DataFact) obj;
            return value.equivTo(dataFact.getValue());
        } else {
            return false;
        }
    }
}