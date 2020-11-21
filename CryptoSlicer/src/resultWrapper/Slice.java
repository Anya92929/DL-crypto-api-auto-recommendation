package resultWrapper;

import javafx.util.Pair;
import main.slicer.backward.MethodCallSiteInfo;
import main.slicer.backward.SlicingCriteria;
import polyglot.ast.Assert;
import slicing.BaseSlicing;
import soot.*;
import soot.jimple.GotoStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.Stmt;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.scalar.BackwardFlowAnalysis;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

import static slicing.SlicingEngine.*;

public class Slice{
    //Intraprocedual slice of sMethod

private SootMethod sMethod;
private Unit criteriaUnit;  //added
private Value criteriaValue; //added
private DataFlowGraph dfg;



private Set<SlicingCriteria> callerCriteria;
private HashMap<Unit,Object> unitMarkMap;
private boolean summarizeSliceTrace = false;
private Set<List<Pair<String,String>>> sliceTraces=new HashSet<>();
private boolean isFirst = true;
private Value sourceValue;
private MethodCallSiteInfo sourceCallSite;

//private Set<Pair<Unit,Value>> startValue=new HashSet<>();


//private List<List<Pair<SootMethod,Value>>> summaryPointList;

public Slice(SootMethod m){
    sMethod = m;
    Body b  = m.retrieveActiveBody();
    UnitGraph graph = new ExceptionalUnitGraph(b);
    unitMarkMap = new HashMap<>();
    Iterator unitIt = graph.iterator();
    cfg = graph;
    dfg = new DataFlowGraph();
    while(unitIt.hasNext()) {
        Unit s = (Unit) unitIt.next();
        unitMarkMap.put(s,"none");

    }
    callerCriteria = new HashSet<SlicingCriteria>();
}

    public DataFlowGraph getDfg() {
        return dfg;
    }

    public void setSource(Object source){
    if(source instanceof Value){
        sourceValue = (Value) source;
    }
    else if(source instanceof SlicingCriteria){
        isCriteriaSlice = true;
        sourceCallSite = ((SlicingCriteria) source).getMethodCallSiteInfo();
    }
}
public Value getSourceValue(){
    return sourceValue;
}
public DirectedGraph getCfg(){
    return cfg;
}
public void addEdgeInDfg(Unit start, Unit end, Value dataflow){
    dfg.addEdge(start,end,dataflow);
}
/*
public void addStartValue(Unit u, Value v){
    startValue.add(new Pair<Unit,Value>(u,v));
}

public Set<Pair<Unit,Value>> getStartValue(){
    return startValue;
}*/

/*public void writeAllOpTraces(){
    for(Pair<Unit, Value> startPoint: startValue){
        writeOpTracesForStartValue(startPoint.getKey(),startPoint.getValue());
    }
}
public void writeOpTracesForStartValue(Unit u, Value v){
if(debug_flag){
    System.out.print("Write Trace for Start Value ");
    System.out.print(v);
    System.out.println(" at Unit: "+u);
}


}*/
public void markUnit(Unit u, Object s){
    if(unitMarkMap.containsKey(u)){
        if(unitMarkMap.get(u)instanceof String){
            //change value for "none", "OFF"
            unitMarkMap.put(u,s);
        }
        else{//Hash add <SootMethod,Value> for unitMardMap, add more
            Object mark = unitMarkMap.get(u);
            if(s instanceof List && mark instanceof List){
                List markList = (List) mark;
                ((List) mark).addAll((List)s);
            }

        }

    }
    else{
        try
        {
            throw new NullPointerException("unitMarkMap");
        }
        catch(NullPointerException e)
        {
            System.out.println("=====No such a unit in this Method.========");
            System.out.print("Unit: ");
            System.out.println(u.toString());
            System.out.print("Method: ");
            System.out.println(sMethod.getName());
            System.out.println("===========================================");
            throw e; // rethrowing the exception
        }
    }
}



public boolean getTraceSummarized(){
    return summarizeSliceTrace;
}



public void collectSliceTrace(){

    if(summarizeSliceTrace){

        return;
    }
    else{
        if(debug_flag){
            System.out.println("collect and store slice for method: "+sMethod);
        }
        summarizeSliceTrace=true;
        sliceTraces = new HashSet<>();
        Body b  = sMethod.retrieveActiveBody();
        UnitGraph graph = new ExceptionalUnitGraph(b);
        Iterator unitIt = graph.iterator();
        List<Pair<String,String>> recorder = new ArrayList<>();
        recordUnit(unitIt,recorder);
        if(debug_flag){
            System.out.println("Finish collecting slice for Method "+sMethod);
        }


    }
}


private Set<List<Pair<String,String>>> getAllTraces(){
    try{
        assert summarizeSliceTrace;
    }
    catch(AssertionError e){
        System.err.println("Slice Traces haven't been summarized yet.");
        throw e;
    }
    return sliceTraces;
}

private void recordUnit(Iterator unitIt,List<Pair<String,String>> currTrace){
    if(unitIt.hasNext()) {
        Unit s = (Unit) unitIt.next();
        if (unitMarkMap.get(s) instanceof String) {
            if(isFirst) {
                isFirst = false;
            }
            if(unitMarkMap.get(s)=="ON") {
                currTrace.add(new Pair<String, String>(s.toString(), sMethod.toString()));
            }
            recordUnit(unitIt,currTrace);
        }
        else if(unitMarkMap.get(s) instanceof SlicingCriteria){
            try{
                assert isFirst=true;
            }
            catch (AssertionError e){
                throw e;
            }
            //This should always be the start point if there is such one
            SlicingCriteria sc = (SlicingCriteria)unitMarkMap.get(s) ;
            insertTransformationAtCallSite(currTrace,s,sc);
            recordUnit(unitIt,currTrace);
        }
        else{
            Set<Pair<SootMethod,Value>> summaryPoints = (Set) unitMarkMap.get(s);
            Set<List<Pair<String,String>>> summaryTraces = new HashSet<>();
            for(Pair<SootMethod,Value> summaryPoint: summaryPoints){
                SootMethod summaryMethod = summaryPoint.getKey();
                Value summaryValue = summaryPoint.getValue();
                Slice branchSlice = analysisResult.get(summaryMethod).getSummarySliceByValue(summaryValue);
                if(debug_flag){
                    System.out.println("Get summarization in "+branchSlice.getMethod() +"for value "+summaryValue);
                }
                if(!branchSlice.getTraceSummarized()){
                    branchSlice.collectSliceTrace();
                }
                if(debug_flag){
                    System.out.println("summarization in "+branchSlice.getMethod() + " for value "+summaryValue+ " is");
                    System.out.println(branchSlice.getAllTraces());
                }
                summaryTraces.addAll(branchSlice.getAllTraces());
            }
            for(List<Pair<String,String>> branch: summaryTraces){
                List<Pair<String,String>> newTrace= new ArrayList<>();
                newTrace.addAll(currTrace);
                newTrace.addAll(branch);

                recordUnit(unitIt,newTrace);
            }
        }
    }
    else{
        List<Pair<String,String>> completeTrace = new ArrayList<>();
        completeTrace.addAll(currTrace);
        sliceTraces.add(completeTrace);
    }
}


public void writeCompleteTraces( Stack<List<Pair<String,String>>> unitTrace,Stack<SlicingCriteria> callerStack) throws IOException {
    if(debug_flag){
        System.out.println("Start summarize slice");
    }
    if(!summarizeSliceTrace) {
        collectSliceTrace();
    }

    for(List<Pair<String,String>> sliceTrace: sliceTraces){
        unitTrace.push(sliceTrace);
        if(!callerCriteria.isEmpty()) {
            for (SlicingCriteria caller : callerCriteria) {
                if(!callerStack.contains(caller)) {
                    callerStack.push(caller);
                    SootMethod callerMethod = caller.getMethodCallSiteInfo().getCaller().getMethod();
                    Slice callerSlice = analysisResult.get(callerMethod).getSliceByCriteria(caller);


                    if (!callerSlice.getTraceSummarized()) {
                        callerSlice.collectSliceTrace();
                    }
                    callerSlice.writeCompleteTraces( unitTrace, callerStack);
                    callerStack.pop();
                }
                else{//recursive caller, end
                    printTrace(unitTrace);
                }

            }
        }
        else{//No caller, end of the trace
            printTrace( unitTrace);
        }
        unitTrace.pop();
    }
}

private void insertTransformationAtCallSite(List<Pair<String,String>> unitTrace,Unit criteriaUnit, SlicingCriteria sc){
    Set<Integer> args = sc.getParameters();
   // List<Pair<String,String>> transformationUnits = new ArrayList<>();
    Stmt stmt = (Stmt) criteriaUnit;
    try {
        assert stmt.containsInvokeExpr();
    }
    catch(AssertionError e){
        System.err.println("Unexpected callsite which doesn't contain invokeExpr: ");
        System.err.println(criteriaUnit);
        System.err.println(sc);
        throw e;
    }
InvokeExpr invokeExpr = null;

    try {
        invokeExpr = stmt.getInvokeExpr();
    }
    catch(RuntimeException e) {


        if(stmt instanceof GotoStmt){
            GotoStmt goToStmt = (GotoStmt) stmt;
            Unit target = goToStmt.getTarget();
            invokeExpr = ((Stmt)target).getInvokeExpr();
        }
        else{
            System.err.println("Unexpected callsite which cannot get invokeExpr directly: ");
            System.err.println(criteriaUnit);
            System.err.println(sc);
            throw e;
        }

    }

    List<Value> argList = invokeExpr.getArgs();
    for(Integer arg: args){
        if(arg==-1) {

            List<ValueBox> uses = invokeExpr.getUseBoxes();
            for (ValueBox vb : uses) {
                if (vb.getValue() instanceof Local && !argList.contains(vb.getValue())) {
                    Value passedThis = vb.getValue();
                    unitTrace.add(new Pair<String, String>("@this = "+passedThis.toString(), sc.getMethodCallSiteInfo().toString()));
                }

            }
        }
        else{

            Value passedArg = invokeExpr.getArg(arg);
            unitTrace.add(new Pair<String,String>("@parameter"+arg+" = "+passedArg.toString(),sc.getMethodCallSiteInfo().toString()));
        }
    }


}

private void printTrace(Stack<List<Pair<String,String>>> unitTrace) throws IOException {
    realSliceCount++;
    if(sliceCount>MAX_SLICE_FOR_EACH_CRITERIA) {
        return;
    }
    else {
        sliceCount++;
        Stack<List<Pair<String, String>>> copyTrace = (Stack) unitTrace.clone();

        writer.write("--------------------Slice---------No. " + sliceCount + "------------\n");
        if (debug_flag) {
            System.out.print("--------------------Slice---------------------\n");
        }
        while (!copyTrace.isEmpty()) {
            List<Pair<String, String>> traceFrag = copyTrace.pop();
            for (Pair<String, String> line : traceFrag) {
                writer.write("Unit: " + line.getKey() + " | Method: " + line.getValue() + "\n");
                if (debug_flag) {
                    System.out.print("Unit: " + line.getKey() + " | Method: " + line.getValue() + "\n");
                }
            }
        }
    }

}

public Object getUnitMark(Unit u){
    try{
        assert unitMarkMap.containsKey(u);
    }
    catch (AssertionError e){
        System.err.println("Unit Not Found in this Method");
        System.err.println("Method: "+sMethod.toString());
        System.err.println("Unit: "+u.toString());
        throw e;
    }
    return unitMarkMap.get(u);

}

public void addCallerSlicingCriteria(SlicingCriteria s){

        callerCriteria.add(s);
}

public Set<SlicingCriteria> getCallerCriteria(){
    return callerCriteria;
}
public boolean isChecked(Unit u){
    return unitMarkMap.get(u)!="none";

}

public boolean isInSlice(Unit u){
    if(unitMarkMap.containsKey(u)){
        return unitMarkMap.get(u)=="ON";
    }
    return false;
}


public SootMethod getMethod(){
    return sMethod;
}


public void writeDfg() throws IOException {

    for(DataFlowEdge dataflowEdge: dfg.getDataFlows()){
        dfgWriter.write(dataflowEdge.toString()+"\n");
    }

}


   /* public int countSummaryTraces(){
    int count = 1;

    for (Map.Entry<Unit, Object> entry : unitMarkMap.entrySet()) {
        if(!(entry.getValue() instanceof String)){
            List<Pair<SootMethod,Value>> summaryValues = (List) entry.getValue();
            int i = summaryValues.size();
            assert i!=0;
            count = count* i;

        }
    }
    return count;

}


public void writeSliceTraces(){
    Stack<List<Pair<String,String>>> sliceTrace = new Stack<>();
    List<Pair<String,String>> unitList = new ArrayList<>();
    Body b  = sMethod.retrieveActiveBody();
    UnitGraph graph = new ExceptionalUnitGraph(b);
    Iterator unitIt = graph.iterator();
    while(unitIt.hasNext()) {
        Unit unit = (Unit) unitIt.next();
        Object unitMark = unitMarkMap.get(unit);

    }

}

public void writeSummaryTraceNo(int index){
    Body b  = sMethod.retrieveActiveBody();
    UnitGraph graph = new ExceptionalUnitGraph(b);
    Iterator unitIt = graph.iterator();


    while(unitIt.hasNext()) {
        Unit unit = (Unit) unitIt.next();
        Object mark = unitMarkMap.get(unit);
        if(mark instanceof String){
            String markString = (String) mark;
            if(markString.equals("ON")){
                //Write
            }
        }
        else{
            assert mark instanceof List;
            List<Pair<SootMethod,Value>> summaryValueList = (List) mark;
            int size = summaryValueList.size();
            assert size!=0;
            int i = index%size;
            Pair<SootMethod,Value> summaryValue = summaryValueList.get(i);
            Slice summarySlice = analysisResult.get(summaryValue.getKey()).getSummarySliceByValue(summaryValue.getValue());
            int countSummaryTrace = summarySlice.countSummaryTraces();



            index = (index-i)/size;


        }


    }

}*/


public String getSignature(){
    if(isCriteriaSlice) {
        return "Slice{"+"Method:"+sMethod.toString()+" for CallSite: "+sourceCallSite.toString()+"}";
    }
    else{
        return "Slice{"+"Method:"+sMethod.toString()+" for Value: "+sourceValue.toString()+"}";
    }
}





}