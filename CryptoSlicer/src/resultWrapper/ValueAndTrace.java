package resultWrapper;

import soot.Value;

import java.util.List;
import java.util.Set;

public class ValueAndTrace extends Object{
    private Value value;
    private Set<List<Edge>> traces;



    public void setValue(Value v){
        value = v;
    }

    public Value getValue(){
        return value;
    }

    public boolean containValue(Value v){
        return value.equivTo(v);
    }
    public void addTrace(List<Edge> trace){
        traces.add(trace);
    }
    /*public void updateTrace(ValueAndTrace oldValueAndTrace,Edge e){
        Value startValue = e.getStartNode();
        Value endValue = e.getEndNode();
        if(oldValueAndTrace.getValue().equivTo(startValue)&&value.equivTo(endValue)){
            for(List<Edge> trace: traces){
                List<Edge> newTrace = trace.clone();
                newTrace.add(e);
                //newValueAndTrace.addTrace(newTrace);
            }
        }
        else{//unmatched

        }
    }

    public Set<List<Edge>> getTraces(){
        return traces;
    }*/

}