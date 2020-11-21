package resultWrapper;


import soot.Unit;
import soot.Value;

public class DataFlowEdge{
    private Unit startUnit;
    private Unit endUnit;
    private Value dataflow;

    public DataFlowEdge(Unit start, Unit end, Value v){
        startUnit = start;
        endUnit = end;
        dataflow = v;
    }



    public Unit getStartUnit(){
        return startUnit;
    }
    public Unit getEndUnit(){
        return endUnit;
    }
    public Value getDataFlow(){
        return dataflow;
    }


    public String toString(){

        return "DataFlow{"+startUnit.toString()+"----"+dataflow.toString()+"---->"+endUnit.toString()+"}";
    }

}