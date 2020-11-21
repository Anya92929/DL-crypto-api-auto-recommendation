package resultWrapper;

import soot.Value;

public class Edge{
    private Value startValue;
    private Value endValue;
    private String edgeInfo;
    public Edge(Value v1,Value v2,String s){
        startValue = v1;
        endValue = v2;
        edgeInfo = s;
    }

    public String getOperation(){
        return edgeInfo;
    }

    public Value getStartNode(){
        return startValue;
    }
    public Value getEndNode(){
        return endValue;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
