package resultWrapper;



import soot.Unit;
import soot.Value;

import java.io.IOException;
import java.util.*;

import static slicing.SlicingEngine.dfgWriter;

public class DataFlowGraph{

    private set<List<Unit>> dataFlowTraces;
    //private Slice slice;
    private Set<DataFlowEdge> dataFlowEdges;
    private HashMap<Unit,Set<Slice>> calleeSlice;
    private Set<Slice> callerSlice;

    public DataFlowGraph(){
        dataFlowEdges = new HashSet<>();
        calleeSlice = new HashMap<>();
        callerSlice = new HashSet<>();
    }

    public Set<DataFlowEdge> getDataFlows(){
        return dataFlowEdges;
    }

    public void addEdge(Unit start, Unit end, Value dataflow){
        DataFlowEdge newEdge = new DataFlowEdge(start, end, dataflow);
        dataFlowEdges.add(newEdge);

    }

    public void addCalleeLink(Unit u, Slice s){
        Set<Slice> calleeS = null;
        if(calleeSlice.containsKey(u)){
            calleeS = calleeSlice.get(u);
        }
        else{
            calleeS = new HashSet<>();
        }
        calleeS.add(s);
    }

    public void addCallerLink(Slice s){
        callerSlice.add(s);
    }

    public HashMap<Unit,Set<Slice>> getCalleeLink(){
        return calleeSlice;
    }
    public Set<Slice> getCallerLink(){
        return callerSlice;
    }

    public void writeCallerLink() throws IOException {
        dfgWriter.write("----------CallerLinks----------------\n");
        for(Slice s: callerSlice) {
            dfgWriter.write(s.getSignature()+"\n");
        }
        dfgWriter.write("------------------------------------\n");
    }

    public void writeCalleeLink() throws IOException {
        dfgWriter.write("----------CalleeLinks----------------\n");
        for(Unit u: calleeSlice.keySet()){
            Set<Slice> valueSlices = calleeSlice.get(u);
            for(Slice valueSlice: valueSlices){
                dfgWriter.write("Unit:"+u.toString()+"----"+valueSlice.getSourceValue()+"---->"+valueSlice.getSignature()+"\n");
            }
        }
        dfgWriter.write("------------------------------------\n");
    }







    }