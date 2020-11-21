package slicing;

import resultWrapper.ResultInMethod;
import resultWrapper.Slice;
import soot.Body;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.scalar.FlowSet;

import java.util.Iterator;
import java.util.Stack;

import static slicing.SlicingEngine.analysisResult;

public class BackwardSummarySlicer{

    private BackwardSummarySlicing analysis;

    public BackwardSummarySlicer(Value v, Slice slice,Stack<SootMethod> callees){
        SootMethod sMethod = slice.getMethod();
        Body body = sMethod.retrieveActiveBody();
        UnitGraph graph = new ExceptionalUnitGraph(body);

        analysis = new BackwardSummarySlicing(graph, v, slice,callees);
        //slice.storeAnalysis(analysis);


        ResultInMethod result = analysisResult.get(sMethod);
        Iterator unitIt = graph.iterator();
        try {
            assert unitIt.hasNext() == true;
        }catch(AssertionError e){
            System.out.println("===========================");
            System.out.println("Empty Unit Iterator for Summary Mehtod");
            System.out.print("Method: ");
            System.out.println(sMethod.toString());
            System.out.println("===========================");
            throw e;
        }

        if(unitIt.hasNext()) {
            Unit s = (Unit) unitIt.next();
            FlowSet summaryFlowSet = (FlowSet) analysis.getFlowBefore(s);
            result.addSummaryFlowForValue(v,summaryFlowSet);
        }



    }




}