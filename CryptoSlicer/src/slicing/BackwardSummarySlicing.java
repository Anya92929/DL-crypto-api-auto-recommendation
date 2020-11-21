package slicing;

import main.slicer.backward.SlicingCriteria;
import resultWrapper.Slice;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.jimple.DefinitionStmt;
import soot.jimple.ReturnStmt;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.scalar.ArraySparseSet;
import soot.toolkits.scalar.FlowSet;

import java.util.List;
import java.util.Stack;

import static slicing.SlicingEngine.debug_flag;


public class BackwardSummarySlicing extends BaseSlicing{

    private Value value;
    private boolean isStart = false;

    public BackwardSummarySlicing(DirectedGraph graph, Value v, Slice s, Stack<SootMethod> callees){

        super(graph,s,callees);
        value = v;
        doAnalysis();





    }


@Override
    protected void transferFunction(FlowSet inSet, Unit currUnit, FlowSet outSet, FlowSet kill, FlowSet gen){

        if (slice.getUnitMark(currUnit) == "none") {
            slice.markUnit(currUnit, "OFF");
        }
        if(isStart) {


            flowFunction(inSet, currUnit, outSet,kill,gen);

            //dfg.addEdge(currUnit,inSet,outSet);
            if (debug_flag) {
                System.out.println("--------Summary---------");
                System.out.println(currUnit);
                System.out.println(inSet);
                System.out.println(outSet);
                System.out.println("---------------------------");


            }
        }
        else{
            if(currUnit instanceof ReturnStmt){
                Value retValue = ((ReturnStmt) currUnit).getOp();
                if(retValue.equivTo(value)){
                    isStart = true;
                    gen.add(new DataFact(retValue,currUnit));
                    slice.markUnit(currUnit,"ON");
                   // slice.addStartValue(currUnit,value);
                }
            }
        }
    }


/*
    @Override
    protected Object entryInitialFlow() {
        FlowSet entryFlow = new ArraySparseSet();
        entryFlow.add(value);
        return entryFlow;
    }*/





}