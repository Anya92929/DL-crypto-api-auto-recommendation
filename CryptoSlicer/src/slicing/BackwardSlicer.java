package slicing;

import main.analyzer.backward.MethodWrapper;
import main.slicer.backward.MethodCallSiteInfo;
import main.slicer.backward.SlicingCriteria;
import resultWrapper.DataFlowGraph;
import resultWrapper.ResultInMethod;
import resultWrapper.Slice;
import soot.Body;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.scalar.FlowSet;


import java.util.*;

import static slicing.SlicingEngine.analysisResult;
import static slicing.SlicingEngine.MAX_CALLER_DEP;
import static slicing.SlicingEngine.debug_flag;


public class BackwardSlicer{


    //private Slice slice;
    //private DataFlowGraph dataFlowGraph;
    private BackwardSlicing backwardSlicing;
    private int depth;
    private Slice slice;





    public BackwardSlicer(SlicingCriteria slicingCriteria,int d,Slice s,Stack<MethodCallSiteInfo> callers){
        depth = d;
        MethodCallSiteInfo callSiteInfo = slicingCriteria.getMethodCallSiteInfo();
        SootMethod m = callSiteInfo.getCaller().getMethod();
        Body b  = m.retrieveActiveBody();
        slice = s;


        UnitGraph graph = new ExceptionalUnitGraph(b);
           // Slice slice = resultInMethod.getSliceByCriteria(slicingCriteria);
            backwardSlicing = new BackwardSlicing(graph, slicingCriteria, slice,callers);
           // slice.storeAnalysis(backwardSlicing);
            if(depth<MAX_CALLER_DEP) {
                Iterator unitIt = graph.iterator();
                Set<Value> valueSet = new HashSet<>();
                if (unitIt.hasNext()) {
                    Unit u = (Unit) unitIt.next();
                    FlowSet flowAtStartMethod = (FlowSet) backwardSlicing.getFlowBefore(u);
                    if(debug_flag){
                        System.out.println(u);
                        System.out.println("flowAtStartMethod: "+flowAtStartMethod);
                    }
                    for (Object flow : flowAtStartMethod) {
                        Value value = ((DataFact) flow).getValue();
                        valueSet.add(value);

                    }
                }

                if (!valueSet.isEmpty()) {

                    MethodWrapper thisMethod = slicingCriteria.getMethodCallSiteInfo().getCaller();
                    List<MethodCallSiteInfo> callSiteForThisMethod = getCallsiteListFromMethodWrapper(thisMethod);

                    Set<Integer> params = new HashSet<>();
                    for (Value value : valueSet) {
                        int paramIndex = backwardSlicing.getArgIndexOrThisFromCalleeValue(value);
                        if (paramIndex >= -1) {

                            params.add(paramIndex);

                        } else {
                            //"constant" or FieldValue?

                        }

                    }
                    if(debug_flag){
                        System.out.println("==========================================");
                        System.out.println("Reach entry point of method "+m.toString());
                        System.out.println("-------------------------------------------");
                        System.out.println("Hold flow set");
                        for(Value v: valueSet) {
                            System.out.println(v.toString());
                        }
                        System.out.println("-----------------------------------------");
                        System.out.println("found callsite:");
                        for(MethodCallSiteInfo callSite: callSiteForThisMethod){
                            System.out.println(callSite);
                        }
                        System.out.println("--------------------------------------");
                        System.out.println("passed out flow set");
                        for(Integer id: params){
                            System.out.println("argId: "+id);
                        }
                        System.out.println("=========================================");

                    }
                    if(!params.isEmpty()) {
                        for (MethodCallSiteInfo callSite : callSiteForThisMethod) {
                            if (!callers.contains(callSite)) {

                                SlicingCriteria newCriteria = new SlicingCriteria(callSite, params);//How to handle -1
                                ResultInMethod resultInMethod;
                                if (!analysisResult.containsKey(callSite.getCaller().getMethod())) {
                                    if (debug_flag) {
                                        System.out.println("Backward Slicing for slicingCriteria: " + newCriteria);
                                        System.out.println("First traverse for method: " + callSite.getCaller().getMethod().toString());
                                    }
                                    resultInMethod = new ResultInMethod(callSite.getCaller().getMethod());
                                    analysisResult.put(callSite.getCaller().getMethod(), resultInMethod);
                                    resultInMethod.creatSliceForCriteria(newCriteria);
                                } else {
                                    if (debug_flag) {
                                        System.out.println("Backward Slicing for slicingCriteria: " + newCriteria);

                                    }
                                    resultInMethod = analysisResult.get(callSite.getCaller().getMethod());
                                    if (!resultInMethod.hasSliceforCriteria(newCriteria)) {
                                        if (debug_flag) {
                                            System.out.println("Create slice for this slicingCriteria");

                                        }
                                        resultInMethod.creatSliceForCriteria(newCriteria);
                                    } else {
                                        // Has already slicing for this criteria.

                                        //Notice where to parse entire analysis result.
                                        //summarize result here.
                                        if (debug_flag) {
                                            System.out.println("Already has slice for slicingCriteria: " + newCriteria);
                                            System.out.println("Skip");
                                        }
                                        return;
                                    }
                                }
                                slice.addCallerSlicingCriteria(newCriteria);
                                Slice newSlice = resultInMethod.getSliceByCriteria(newCriteria);
                                slice.getDfg().addCallerLink(newSlice);
                                callers.push(callSite);
                                BackwardSlicer callerSlicer = new BackwardSlicer(newCriteria, depth + 1, newSlice, callers);
                                callers.pop();
                            }
                            else{
                                if(debug_flag){
                                    System.out.println("Analysis terminate because of callsite recursive");
                                }
                            }
                        }


                    }

                }
                else{
                    if(debug_flag){
                        System.out.println("Analysis terminate because of Empty data flow set");
                    }
                }
            }
            else{
                if(debug_flag){
                    System.out.println("Analysis terminate because of run out depth budget");
                }
            }











    }



    private List<MethodCallSiteInfo> getCallsiteListFromMethodWrapper(MethodWrapper thisMethod){

        List<MethodCallSiteInfo> callSiteForThisMethod = new ArrayList<>();
        List<MethodWrapper> callersForThisMethod = thisMethod.getCallerList();
        for(MethodWrapper caller: callersForThisMethod){
            List<MethodCallSiteInfo> callSites = caller.getCalleeList();
            for(MethodCallSiteInfo callSite: callSites){
                if(callSite.getCallee().toString().equals(thisMethod.toString())){
                    callSiteForThisMethod.add(callSite);

                }
            }
        }
        return callSiteForThisMethod;



    }





















}