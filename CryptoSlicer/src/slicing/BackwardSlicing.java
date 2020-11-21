package slicing;

import main.slicer.backward.MethodCallSiteInfo;
import main.slicer.backward.SlicingCriteria;
import resultWrapper.DataFlowGraph;
import resultWrapper.ResultInMethod;
import resultWrapper.Slice;
import soot.*;
import soot.jimple.*;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.scalar.ArraySparseSet;
import soot.toolkits.scalar.FlowSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import static slicing.SlicingEngine.debug_flag;
import static slicing.SlicingEngine.currentBeginningCriteria;

public class BackwardSlicing extends BaseSlicing{

    private MethodCallSiteInfo methodCallSiteInfo;
    private boolean isStart = false;
    private Set<Integer> slicingArgIds;
    private Stack<MethodCallSiteInfo> callers;

    public BackwardSlicing(DirectedGraph graph, SlicingCriteria criteria,  Slice s,Stack<MethodCallSiteInfo> callsiteStack){

        super(graph,s,new Stack<SootMethod>());

        methodCallSiteInfo = criteria.getMethodCallSiteInfo();
        Set<Integer> slicingParams = criteria.getParameters();
        slicingArgIds = new HashSet<Integer>(slicingParams);
        callers = callsiteStack;
        doAnalysis();





    }
    @Override
    protected void transferFunction(FlowSet inSet, Unit currUnit, FlowSet outSet, FlowSet kill, FlowSet gen){



    if(slice.getUnitMark(currUnit)=="none") {
        slice.markUnit(currUnit, "OFF");
    }

    /*find start point*/
    if(!isStart) {
        if (currUnit.toString().contains(methodCallSiteInfo.getCallee().toString()) && currUnit.getJavaSourceStartLineNumber() == methodCallSiteInfo.getLineNumber()) {
            Set<Value> criteriaValues = getUseFromStatement(currUnit, slicingArgIds);
            if (criteriaValues.isEmpty()) {
                return;
            }
            isStart = true;
            for(Value criteriaValue: criteriaValues){
                //slice.addStartValue(currUnit,criteriaValue);

                gen.add(new DataFact(criteriaValue,currUnit));
            }
            //If it is the begining criteria, mark it as ON, otherwise, when it is a callsite in a caller mark it as slicingCriteria
            if(matchWithBeginningCriteria(methodCallSiteInfo.getCallee().getMethod())){
                slice.markUnit(currUnit,"ON");
                if(debug_flag){
                    System.out.println("Record begining criteria");
                }
            }
            else {
                SlicingCriteria sc = new SlicingCriteria(methodCallSiteInfo,slicingArgIds);
                slice.markUnit(currUnit, sc);
            }

        }
    }
    /*For every unit*/
    else{
        flowFunction(inSet,currUnit,outSet,kill,gen);


    }

//dfg.addEdge(currUnit,inSet,outSet);

if(debug_flag){
        System.out.println("----------------------");
        System.out.println(currUnit);
    System.out.println(inSet);
    System.out.println(outSet);

    for(ValueBox vb: currUnit.getUseAndDefBoxes()){
        System.out.println(vb);
        Value v = vb.getValue();
        if(v instanceof FieldRef){
            System.out.println("FieldRef");
            SootField sf = ((FieldRef) v).getField();
            if(sf.isStatic()){
                System.out.println("Static Field");
            }
        }
        if(v instanceof Local){
            System.out.println("Local");
        }
        if(v instanceof Constant){
            System.out.println("Constant");
        }
        if(v instanceof Expr) {
            System.out.println("Expr");
        }
        if(v instanceof IntConstant){
            System.out.println("IntConstant");
        }
        if(v instanceof Ref){
            System.out.println("Ref");
        }
        if(v instanceof IdentityRef){
            System.out.println("IdentityRef");
        }
    }
    System.out.println("---------------------------");



}




}
private boolean matchWithBeginningCriteria(SootMethod calleeInCurrentSlicingCriteira){
        SootMethod calleeInBeginingSlicingCriteria = currentBeginningCriteria.getMethodCallSiteInfo().getCallee().getMethod();
        return calleeInBeginingSlicingCriteria.equals(calleeInCurrentSlicingCriteira);
}



}