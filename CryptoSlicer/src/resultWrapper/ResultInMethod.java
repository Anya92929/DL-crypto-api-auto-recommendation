package resultWrapper;


import main.slicer.backward.SlicingCriteria;
import soot.SootMethod;
import soot.Value;
import soot.toolkits.scalar.FlowSet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ResultInMethod{

    private SootMethod sMethod;
    private Map<SlicingCriteria,Slice> criteriaSliceMap = null;
    private Map<Value, Slice> summarySliceMap = null;
    private Map<Value,FlowSet> summaryFlowMap=null;


    public ResultInMethod(SootMethod m){
        sMethod = m;
        criteriaSliceMap=new HashMap<>();
        summarySliceMap = new HashMap<>();
        summaryFlowMap = new HashMap<>();


    }




    public Slice getSliceByCriteria(SlicingCriteria key){
        if(criteriaSliceMap.containsKey(key)){
            return criteriaSliceMap.get(key);
        }
        else{
            return null;
        }
    }

    public Slice getSummarySliceByValue(Value v){
        if(summarySliceMap.containsKey(v)){
            return summarySliceMap.get(v);
        }
        else{
            return null;
        }
    }

    public FlowSet getSummaryFlowByValue(Value v){
        if(summaryFlowMap.containsKey(v)){
            return summaryFlowMap.get(v);
        }
        else{
            return null;
        }
    }

    public void creatSliceForCriteria(SlicingCriteria key){
        Slice slice = new Slice(sMethod);
        slice.setSource(key);
        criteriaSliceMap.put(key,slice);
    }

    public void createSummarySliceForValue(Value v){
        Slice slice = new Slice(sMethod);
        slice.setSource(v);
        summarySliceMap.put(v,slice);
    }

    public void addSummaryFlowForValue(Value v,FlowSet dataFact){
        summaryFlowMap.put(v,dataFact);
    }


    public boolean hasSliceforCriteria(SlicingCriteria key){
        return criteriaSliceMap.containsKey(key);
    }

    public boolean hasSummarySliceforValue(Value v){
        return summarySliceMap.containsKey(v);
    }

    public boolean hashSummaryFlowforValue(Value v){
        return summaryFlowMap.containsKey(v);
    }

    public Map<Value, Slice> getAllSummarySlices(){
        return summarySliceMap;
    }

    public Collection<Slice> getSlicesForCriteria(){
        return criteriaSliceMap.values();
    }
    public Collection<Slice> getSlicesForValue(){
        return summarySliceMap.values();
    }






}