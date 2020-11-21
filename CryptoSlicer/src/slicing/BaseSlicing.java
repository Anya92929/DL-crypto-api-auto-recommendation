/*
This is a base slicing class.

 */

package slicing;

import javafx.util.Pair;
import main.slicer.backward.MethodCallSiteInfo;
import resultWrapper.DataFlowGraph;
import resultWrapper.ResultInMethod;
import resultWrapper.Slice;
import soot.*;
import soot.jimple.*;
import soot.jimple.internal.JimpleLocalBox;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.scalar.ArraySparseSet;
import soot.toolkits.scalar.BackwardFlowAnalysis;
import soot.toolkits.scalar.FlowSet;


import java.util.*;

import static slicing.SlicingEngine.analysisResult;
import static slicing.CallGraphBuilder.classHierarchy;
import static slicing.SlicingEngine.debug_flag;


public abstract class BaseSlicing extends BackwardFlowAnalysis{

    private FlowSet emptySet;
    protected Slice slice;
    protected HashMap<Value, Set<Unit>>unclosedEdge= new HashMap<>();
    //protected Stack<MethodCallSiteInfo> callSiteStack = new Stack<MethodCallSiteInfo>();
    protected Stack<SootMethod> calleeStack = new Stack<SootMethod>();



    public BaseSlicing(DirectedGraph graph,Slice s,Stack<SootMethod> calleePosition) {
        super(graph);
        this.slice = s;
        this.emptySet = new ArraySparseSet();
        this.calleeStack = calleePosition;
        //this.dfg = new DataFlowGraph(graph);


    }


    @Override
    protected void flowThrough(Object in, Object node, Object out){

        FlowSet inSet = (FlowSet) in,
                outSet = (FlowSet) out;
        Unit currUnit = (Unit) node;



        FlowSet kill = new ArraySparseSet();
        FlowSet gen = new ArraySparseSet();

        transferFunction(inSet, currUnit,outSet,kill,gen);

        for(Object genObj: gen){
            if(genObj instanceof Value){
                System.out.println("Exception");
            }
        }
        if(!kill.isEmpty()){
            if(kill.size()!=1){
                if(debug_flag){
                    System.out.println("More than 1 killed value for this statement");
                }
            }
            for(Object inValue: inSet){
                DataFact inData = (DataFact) inValue;
                for(Object killedValue: kill) {
                    if (inData.equals(killedValue)) {
                        for(Unit usageUnit: inData.getGenUnit()) {
                            slice.getDfg().addEdge(currUnit, usageUnit,inData.getValue());
                        }
                    }
                }
            }


        }

        inSet.difference(kill,outSet);
        outSet.union(gen);

    }

    private void closeEdgeForKilledValue(Value v,Unit currUnit){
        try{
            assert unclosedEdge.containsKey(v);
        }
        catch(AssertionError e){
            throw e;
        }
        Set<Unit> usages = unclosedEdge.get(v);
        if(usages==null){
            System.err.print("Value: ");
            System.err.println(v);
            System.err.println("In Unit: "+currUnit);
        }
        for(Unit use: usages){
            slice.getDfg().addEdge(currUnit,use,v);
        }
        unclosedEdge.remove(v);

    }

    private void openEdgeForGenValue(Value v, Unit currUnit){
        Set<Unit> usages = null;
        if(unclosedEdge.containsKey(v)){
            usages = unclosedEdge.get(v);
        }
        else{
            usages = new HashSet<>();
            unclosedEdge.put(v,usages);
        }
        usages.add(currUnit);

    }

    protected abstract void transferFunction(FlowSet inSet, Unit currUnit, FlowSet outSet, FlowSet kill, FlowSet gen);

    @Override
    protected void copy(Object source, Object dest) {
        // TODO Auto-generated method stub
        FlowSet srcSet = (FlowSet) source,
                destSet = (FlowSet) dest;
        srcSet.copy(destSet);

    }

    @Override
    protected void merge(Object in1, Object in2, Object out) {
        // TODO Auto-generated method stub
        FlowSet inSet1 = (FlowSet) in1,
                inSet2 = (FlowSet) in2,
                outSet = (FlowSet) out;

        FlowSet diff1 = new ArraySparseSet();
        FlowSet overlap1 = new ArraySparseSet();
        FlowSet diff2 = new ArraySparseSet();
        FlowSet overlap2 = new ArraySparseSet();
        inSet1.difference(inSet2,diff1);
        inSet1.difference(diff1,overlap1);
        inSet2.difference(inSet1,diff2);
        inSet2.difference(diff2,overlap2);
        outSet.union(diff1);
        outSet.union(diff2);
        for(Object data1: overlap1){
            for(Object data2: overlap2){
               DataFact dataFact1 = (DataFact) data1;
               DataFact dataFact2 = (DataFact) data2;
               if(dataFact1.equals(dataFact2)){
                   dataFact1.mergeGenUnit(dataFact2);
                   outSet.add(dataFact1);
                   break;
               }
            }
        }


    }

    @Override
    protected Object newInitialFlow() {
        // TODO Auto-generated method stub
        return emptySet.clone();
    }

    @Override
    protected Object entryInitialFlow() {

        return emptySet.clone();
    }





    protected Set<Value> getUseFromStatement(Unit currUnit, Set<Integer> argIds){
        /*example
		=======================
 Current Unit: $r6 = virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>($r7)
------------------------
ValueBox: LinkedRValueBox(virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>($r7))
Value in: virtualinvoke $r6.<java.lang.StringBuilder: java.lang.StringBuilder append(java.lang.String)>($r7)
- - - - - - - - - -
	 UseBoxes of that value ImmediateBox($r7)
	 Value in that box: $r7
- - - - - - - - - -
	 UseBoxes of that value JimpleLocalBox($r6)
	 Value in that box: $r6
------------------------
ValueBox: ImmediateBox($r7)
Value in: $r7
------------------------
ValueBox: JimpleLocalBox($r6)
Value in: $r6
		 */
        if(debug_flag){
            System.out.println("------------------------");
            System.out.println("args: "+argIds);
        }
        Set<Value> rValues = new HashSet<Value>();
        List<ValueBox> useBoxes = currUnit.getUseBoxes();
        if(useBoxes.isEmpty()) {
            if (currUnit instanceof GotoStmt) {
                GotoStmt stmt = (GotoStmt) currUnit;
                Unit target = stmt.getTarget();
                useBoxes = target.getUseBoxes();
            }
        }
        for(ValueBox vb: useBoxes){
            if(vb.getValue().toString().contains("invoke")){
                for(int argId: argIds) {
                    //System.out.println("Debug: contains invoke");
                    if (argId == -1) { // get the object $r6 out
                        //System.out.println("slicing for -1");
                        if(debug_flag){
                            System.out.println("Resove value as: "+vb.getValue().getUseBoxes());
                        }
                        for (ValueBox vbb : vb.getValue().getUseBoxes()) {
                            //System.out.println("\tcheck for vbb "+vbb.toString());
                            if (vbb instanceof JimpleLocalBox) {

                                //System.out.println("Found object: "+vbb.toString());
                                //System.out.println("Return value is: "+vbb.getValue().toString());
                                rValues.add(vbb.getValue());
                            }


                        }
                        //System.out.println("None of them are JimpleLocalBox");
                    } else {
                        //System.out.println("Slicing not for -1");
                        rValues.add(vb.getValue().getUseBoxes().get(argId).getValue());
                    }
                }
            }

        }

        return rValues;



    }

    protected void flowFunction(FlowSet inSet, Unit currUnit,FlowSet outSet,FlowSet kill, FlowSet gen){
        if(debug_flag&&currUnit.toString().contains("$r3 = $r4[$i1]")||(debug_flag&&currUnit.toString().contains("staticinvoke <twitter4j.internal.http.HttpParameter: java.lang.String encode(java.lang.String)>($r7)")
      )||(debug_flag&&currUnit.toString().contains("r1 = $r0.<org.apache.http.impl.auth.NTLMEngineImpl$Type2Message: byte[] challenge>"))){
            System.out.println(currUnit.toString());
            System.out.println("===========DEBUG===================");
            System.out.println("InSet:");
            for(Object o: inSet){
                System.out.println(o.toString());
            }
            System.out.println("====================================");
            List<String> categories = getUnitCategory(currUnit);
            for(String category: categories){
                System.out.println("This stmt is a "+category);
            }

        }
        /* DefinitionStmt includes AssignStmt and IdentityStmt*/
        if(currUnit instanceof DefinitionStmt){

            Stmt stmt = (Stmt) currUnit;
            if(stmt.containsInvokeExpr()){
                callFlow(inSet,currUnit,outSet, kill, gen);
            }
            else{
                if(debug_flag&&currUnit.toString().contains("$r3 = $r4[$i1]")||(debug_flag&&currUnit.toString().contains("staticinvoke <twitter4j.internal.http.HttpParameter: java.lang.String encode(java.lang.String)>($r7)")
                )||(debug_flag&&currUnit.toString().contains("r1 = $r0.<org.apache.http.impl.auth.NTLMEngineImpl$Type2Message: byte[] challenge>"))) {
                System.out.println("is an ordinaryFlow");
                }
                    /* AssignStmt doesn't contain invokeExpr and IdentityStmt */
                ordinaryFlow(inSet, currUnit,outSet,kill, gen);

            }


        }
        else if(currUnit instanceof InvokeStmt){
            invokeFlow(inSet, currUnit,outSet, kill, gen);

        }
        else{
            //do nothing
        }
        //What kind of Unit
        //If callsite, whether flowSet used or defined


    }

    /*
    When to enter ordinaryFlow: 1. DefinationStmt, no InvokeExpr in it;
     */
    protected void ordinaryFlow(FlowSet inSet, Unit currUnit,FlowSet outSet, FlowSet kill, FlowSet gen){

        List<ValueBox> defBox = currUnit.getDefBoxes();
        try {
            assert defBox.size() == 1;
        }
        catch(AssertionError e){
            System.out.println("=====================");
            System.out.println("More than one defBoxes");
            System.out.print("Unit: ");
            System.out.println(currUnit.toString());
            for(ValueBox vb: defBox){
                System.out.println(vb.toString());
            }
            System.out.println("=======================");
            throw e;
        }
        Value defValue = defBox.get(0).getValue();

        if(inSet.contains(new DataFact(defValue))){
            slice.markUnit(currUnit, "ON");

            kill.add(new DataFact(defValue,currUnit));
            addAtomUseValueFromUnit(currUnit,gen);




            if(debug_flag&&currUnit.toString().contains("$r3 = $r4[$i1]")||(debug_flag&&currUnit.toString().contains("staticinvoke <twitter4j.internal.http.HttpParameter: java.lang.String encode(java.lang.String)>($r7)")
            )||(debug_flag&&currUnit.toString().contains("r1 = $r0.<org.apache.http.impl.auth.NTLMEngineImpl$Type2Message: byte[] challenge>"))){

                    System.out.println("For this statement:");
                System.out.println("Kill value: "+kill);
                System.out.println("gen Value: "+gen);
                System.out.println("inSet: "+inSet);
                System.out.println("outSet: "+outSet);
            }



        }else{
           //Nothing to do.
        }
    }
/*
protected String getOperation(Unit currUnit){
        if(currUnit instanceof DefinitionStmt){
            Stmt currStmt = (Stmt) currUnit;
            if(currStmt.containsInvokeExpr()){//call flow
                InvokeExpr invoke = currStmt.getInvokeExpr();
                SootMethod calledMethod = invoke.getMethod();
                return calledMethod.toString();
            }
            else{//ordinary flow
                List<ValueBox> uses = currUnit.getUseBoxes();
                for(ValueBox useValueBox: uses){
                    if(useValueBox.getValue() instanceof Expr){
                        if(useValueBox.getValue() instanceof AddExpr){
                            if(debug_flag){
                                System.out.print("Unit: ");
                                System.out.println(currUnit);
                                System.out.println("It is a AddExpr");
                            }
                            return "Add";
                        }
                        else if(useValueBox.getValue() instanceof AndExpr){
                            if(debug_flag){
                                System.out.print("Unit: ");
                                System.out.println(currUnit);
                                System.out.println("It is a AndExpr");
                            }
                            return "And";
                        }
                        else if(useValueBox.getValue() instanceof  BinopExpr){
                            if(debug_flag){
                                System.out.print("Unit: ");
                                System.out.println(currUnit);
                                System.out.println("It is a BinopExpr");
                            }
                            return "Binop";
                        }
                    }
                }
                return "Equal";
            }
        }else if (currUnit instanceof InvokeStmt){//invokeflow
            InvokeStmt invokeStmt = (InvokeStmt) currUnit;
            InvokeExpr invoke = invokeStmt.getInvokeExpr();
            SootMethod invokedMethod = invoke.getMethod();
            return invokedMethod.toString();
        }
        else{
            return "Unknown_Operation";
        }
}
*/
    protected void callFlow(FlowSet inSet, Unit currUnit,FlowSet outSet, FlowSet kill, FlowSet gen){
        /*AssignStmt containing InvokeExpr*/
        /* Two situation to summary it: 1. def value matched 2. use value matched (use type != String, Integer)*/

        List<ValueBox> defBox = currUnit.getDefBoxes();
        try {
            assert defBox.size() == 1;
        }
        catch(AssertionError e){
            System.out.println("=====================");
            System.out.println("More than one defBoxes");
            System.out.print("Unit: ");
            System.out.println(currUnit.toString());
            for(ValueBox vb: defBox){
                System.out.println(vb.toString());
            }
            System.out.println("=======================");
            throw e;
        }
        Value defValue = defBox.get(0).getValue();
        if(inSet.contains(new DataFact(defValue))){
            kill.add(new DataFact(defValue,currUnit));
            InvokeExpr invokeExpr = ((Stmt)currUnit).getInvokeExpr();
            SootMethod sMethod = invokeExpr.getMethod();
            String calledMethod = sMethod.toString();
            if(calledMethod.startsWith("<java.")||calledMethod.startsWith("<javax.")||calledMethod.startsWith("<android.")||sMethod.isPhantom()){
                includeOrdinaryUnitInSlice(slice,inSet,currUnit,outSet,kill,gen);

            }
            else{
                if(sMethod.isConcrete()) {

                    if(!calleeStack.contains(sMethod)) {
                        List<Object> retValues = linkReturnValueFromCallerToCallee(sMethod);


                        if (debug_flag) {
                            System.out.println("Enter this callee: " + sMethod.toString());
                            System.out.println("Captured Return values: " + retValues);
                        }
                        summaryConcreteMethod(invokeExpr, sMethod, retValues, inSet, currUnit, outSet, kill, gen);
                    }
                    else{
                        dealWithRecursiveCallee(currUnit,kill,gen);
                    }
                }
               else{//Abstract method, interface method
                    //find concrete body for it.
                    try {
                        assert sMethod.isAbstract();
                    }
                    catch(AssertionError e){
                        System.err.println("Found a SootMethod which is not Concrete and is not Abstract");
                        System.err.println(sMethod.toString());
                        throw e;
                    }
                    Set<SootMethod> subMethods = new HashSet<>();
                    String abstClass = sMethod.getDeclaringClass().toString();

                    try {
                        assert classHierarchy.containsKey(abstClass);
                    }
                    catch(AssertionError e){
                        System.err.println("Haven't included class "+abstClass+" in classHierarchy");
                        throw e;
                    }

                    List<SootClass> subClassList = classHierarchy.get(abstClass);
                    if(subClassList!=null) {
                        for (SootClass sClass : subClassList) {
                            if (sClass.isConcrete()) {
                                if (sClass.declaresMethod(sMethod.getSubSignature())) {
                                    SootMethod subMethod = sClass.getMethod(sMethod.getSubSignature());
                                    try {
                                        assert subMethod.isConcrete();
                                    } catch (AssertionError e) {
                                        System.err.println("Found subMethod is still not concrete method");
                                        System.err.println(subMethod.toString());
                                        throw e;
                                    }

                                    subMethods.add(sClass.getMethod(sMethod.getSubSignature()));
                                }


                            }
                        }
                    }

                    if(debug_flag){
                        System.out.println("---------------------------------------------------------");
                        System.out.println("Found implementation for this Abstract method: "+sMethod.toString());
                        for(SootMethod subMethod: subMethods){
                            System.out.println("Implementation"+subMethod);
                            if(!subMethod.isConcrete()){
                                System.out.println("This method is still not concrete");
                            }
                        }
                        System.out.println("---------------------------------------------------------");
                    }

                    if(!subMethods.isEmpty()){
                        boolean hasImplementation = false;
                        for(SootMethod subMethod: subMethods){
                            if(subMethod.isConcrete()) {
                                hasImplementation = true;
                                if(!calleeStack.contains(subMethod)) {
                                    List<Object> retValues = linkReturnValueFromCallerToCallee(subMethod);
                               /* for(Object retV: retValues){
                                    Value retVaule = (Value) retV;
                                    //dfg.addEdge(currUnit,defValue,retVaule,"Equal");
                                }
                                for(Object inV: inSet){
                                    Value inValue = (Value) inV;
                                    if(!inValue.equivTo(defValue)){
                                       // dfg.addEdge(currUnit,inValue,inValue,"Equal");
                                    }
                                }*/
                                    summaryConcreteMethod(invokeExpr, subMethod, retValues, inSet, currUnit, outSet, kill, gen);
                                }
                                else{//recursive
                                    dealWithRecursiveCallee(currUnit,kill,gen);

                                }
                                }
                        }
                        if(!hasImplementation){
                            includeOrdinaryUnitInSlice(slice,inSet,currUnit,outSet,kill,gen);
                        }

                    }
                    else{
                        if(debug_flag){
                            System.out.println("Cannot find implementation for "+sMethod);
                        }
                        includeOrdinaryUnitInSlice(slice,inSet,currUnit,outSet,kill,gen);

                    }

                }

            }
        }
        else{
           //do nothing
        }

    }
    protected void invokeFlow(FlowSet inSet, Unit currUnit,FlowSet outSet, FlowSet kill, FlowSet gen) {
        Stmt s = (Stmt) currUnit;
        InvokeExpr invokeExpr = s.getInvokeExpr();
        ValueBox invokeExprBox = s.getInvokeExprBox();
        if(!invokeExprBox.toString().contains("staticinvoke")){
            Value object=null;
            List<ValueBox> allUses = invokeExprBox.getValue().getUseBoxes();
            List<Value> allArgs = invokeExpr.getArgs();
            for(ValueBox vb: allUses){
                if(!allArgs.contains(vb.getValue())){
                    object = vb.getValue();
                    break;

                }

            }
            if(object!=null&&inSet.contains(new DataFact(object))){

                if(invokeExpr.getMethod().toString().startsWith("<java.")||invokeExpr.getMethod().toString().startsWith("<javax.")||invokeExpr.getMethod().toString().startsWith("<android.")||invokeExpr.getMethod().isPhantom()){

                    kill.add(new DataFact(object,currUnit));
                    includeOrdinaryUnitInSlice(slice,inSet,currUnit,outSet,kill,gen);


                }
                else{
                    //Leave it to solve later




                }





            }
            else{
                //do nothing
            }
        }
        else{//staticinvoke(r1,r2) Context.getParam(Certificate)
            FlowSet atomUses = getAtomUseValueFromUnit(currUnit);
            for(Object atomUse: atomUses){
                DataFact atomValue = (DataFact) atomUse;
                if(inSet.contains(atomValue)){
                    kill.add(atomValue);
                    gen.union(atomUses);
                }
            }

        }


    }

    protected FlowSet getAtomUseValueFromUnit(Unit currUnit){
        FlowSet atomUses = new ArraySparseSet();
        List<ValueBox> useBoxes = currUnit.getUseBoxes();
        for(ValueBox useBox: useBoxes){
            if(!(useBox.getValue() instanceof Expr)){
                atomUses.add(new DataFact(useBox.getValue(),currUnit));
            }
        }
        return atomUses;
    }
    protected void addAtomUseValueFromUnit(Unit currUnit,FlowSet gen){
        FlowSet atomUses = getAtomUseValueFromUnit(currUnit);
        List<ValueBox> useBoxes = currUnit.getUseBoxes();
        if(debug_flag&&currUnit.toString().contains("$r3 = $r4[$i1]")||(debug_flag&&currUnit.toString().contains("staticinvoke <twitter4j.internal.http.HttpParameter: java.lang.String encode(java.lang.String)>($r7)")
        )){
            System.out.println(currUnit);
            System.out.println("UseBoxes of this unit: "+ useBoxes);
        }
        for(ValueBox useBox : useBoxes) {
            if (useBox.getValue() instanceof FieldRef) {
                //System.out.println("Current Unit is: "+currUnit);
                //System.out.println("Find a field:"+ubox.getValue());
                if(debug_flag&&currUnit.toString().contains("$r3 = $r4[$i1]")||(debug_flag&&currUnit.toString().contains("staticinvoke <twitter4j.internal.http.HttpParameter: java.lang.String encode(java.lang.String)>($r7)")
                )){
                    System.out.println("add value: "+useBox);
                }

                //the useBox is a field.
                assert(atomUses.contains(useBox.getValue()));
                gen.add(new DataFact(useBox.getValue(),currUnit));
                //fieldValue = ubox.getValue();
            } else {

                Iterator inUseBox = useBox.getValue().getUseBoxes().iterator();
                if (inUseBox.hasNext()) {
                    if(debug_flag&&currUnit.toString().contains("$r3 = $r4[$i1]")||(debug_flag&&currUnit.toString().contains("staticinvoke <twitter4j.internal.http.HttpParameter: java.lang.String encode(java.lang.String)>($r7)")
                    )){
                        System.out.println("-----------------------------");
                        System.out.println("resolve this value: "+useBox);
                    }
                    while (inUseBox.hasNext()) {

                        ValueBox atomUse = (ValueBox) inUseBox.next();
                        if(debug_flag&&currUnit.toString().contains("$r3 = $r4[$i1]")||(debug_flag&&currUnit.toString().contains("staticinvoke <twitter4j.internal.http.HttpParameter: java.lang.String encode(java.lang.String)>($r7)")
                        )){

                            System.out.println("add value: "+atomUse);
                        }
                        assert(atomUses.contains(useBox.getValue()));
                        gen.add(new DataFact(atomUse.getValue(),currUnit));
                    }

                } else {
                    if(debug_flag&&currUnit.toString().contains("$r3 = $r4[$i1]")||(debug_flag&&currUnit.toString().contains("staticinvoke <twitter4j.internal.http.HttpParameter: java.lang.String encode(java.lang.String)>($r7)")
                    )){
                        System.out.println("add value: "+useBox);
                    }
                    assert(atomUses.contains(useBox.getValue()));
                    gen.add(new DataFact(useBox.getValue(),currUnit));
                }
            }
        }
    }

    protected void addUseFromMethodSummary(Unit currUnit,InvokeExpr invokeExpr, SootMethod sMethod,List<Object> valueSet, FlowSet gen){
        //sMethod may not equals to invokeExpr.getMethod()
        //under the situation that invokeExpr.getMethod() is an abstract one, we find its conrete implementation at sMethod
        ResultInMethod resultInMethod;
        if(analysisResult.containsKey(sMethod)) {
            resultInMethod = analysisResult.get(sMethod);
        }
        else{
            resultInMethod = new ResultInMethod(sMethod);
            analysisResult.put(sMethod,resultInMethod);
        }
        for(Object object:valueSet) {

            Value value = (Value) object;
            if (!resultInMethod.hashSummaryFlowforValue(value)) {
                //new analysis for value in sMethod
                resultInMethod.createSummarySliceForValue(value);
                Slice summarySliceForValue = resultInMethod.getSummarySliceByValue(value);
                slice.getDfg().addCalleeLink(currUnit,summarySliceForValue);
                calleeStack.push(sMethod);
                BackwardSummarySlicer summaryForValue = new BackwardSummarySlicer(value,summarySliceForValue,calleeStack);
                calleeStack.pop();


            }
            FlowSet summaryUse = resultInMethod.getSummaryFlowByValue(value);
            FlowSet useInCaller = linkCalleeToCaller(invokeExpr, summaryUse);
            for(Object summarized: useInCaller){
                DataFact summary = (DataFact) summarized;
                summary.addGenUnit(currUnit);
            }
            gen.union(useInCaller);
        }




    }
    protected List<Object> linkReturnValueFromCallerToCallee(SootMethod sMethod){
        Set<Value> retValueSet = new HashSet<>();
        FlowSet returnValues = new ArraySparseSet();
        try {
            Body summaryBody = sMethod.retrieveActiveBody();
            UnitGraph summaryGraph = new ExceptionalUnitGraph(summaryBody);
            Iterator summaryUnitIt = summaryGraph.iterator();
            while (summaryUnitIt.hasNext()) {
                Unit s = (Unit) summaryUnitIt.next();
                if (s instanceof ReturnStmt) {
                    Value v = ((ReturnStmt) s).getOp();
                    if(debug_flag){
                        System.out.println("Return Stmt in "+sMethod);
                        System.out.println("unit: "+s);
                        System.out.println("add value: "+v);
                    }
                    returnValues.add(v);
                    //retValueSet.add(v);
                }
            }
        }
         catch(RuntimeException e){

                System.err.println("For method");
                System.err.println("method toString: "+sMethod.toString());
                System.err.println("method getName: "+sMethod.getName());
                System.err.println("method Signature: "+sMethod.getSignature());
                System.err.println("method subSignature: "+sMethod.getSubSignature());
                System.err.println("isPhantom: "+sMethod.isPhantom());
                System.err.println("is Concrete: "+sMethod.isConcrete());
                System.err.println("is Abstract: "+sMethod.isAbstract());
                System.err.println("is Static: "+sMethod.isStatic());
                System.err.println("hasActiveBody: "+sMethod.hasActiveBody());

                SootClass sClass = sMethod.getDeclaringClass();
                System.err.println("sClass to String: "+sClass.toString());
                System.err.println("sClass getName: "+sClass.getName());
                assert classHierarchy.containsKey(sClass.getName());
                List<SootClass> subClasses = classHierarchy.get(sClass.getName());
                Set<SootClass> uniqueSubClasses = new HashSet<>();
                System.out.println("found "+subClasses.size()+" subClasses");
                for(SootClass subClass: subClasses){
                    System.out.println("Element: "+subClass.toString());
                    uniqueSubClasses.add(subClass);
                }
                System.out.println("found "+uniqueSubClasses.size()+" unique subClasses");
                for(SootClass subClass: subClasses){
                    if(subClass.isConcrete()){
                        assert !subClass.isAbstract();


                        if(subClass.declaresMethodByName(sMethod.getName())){
                            SootMethod foundMethod = subClass.getMethodByName(sMethod.getName());

                            System.err.println("Found Method by getName: "+sMethod.getName());
                            System.err.println("Found Method is: "+subClass.getMethodByName(sMethod.getName()).toString());
                        }
                        if(subClass.declaresMethod(sMethod.getSubSignature())){
                            System.err.println("Found Method by SubSignature: "+sMethod.getSubSignature());
                            System.err.println("Found Method is: "+subClass.getMethod(sMethod.getSubSignature()).toString());

                        }


                    }
                }


                throw e;
            }
            List returnValueToList = Collections.unmodifiableList(returnValues.toList());
/*
        Body bodyAgain = sMethod.retrieveActiveBody();
        UnitGraph graphAgain = new ExceptionalUnitGraph(bodyAgain);
        Iterator unitItAgain = graphAgain.iterator();
        while(unitItAgain.hasNext()){
            Unit sAgain = (Unit) unitItAgain.next();
            System.out.println(sAgain);
        }*/

        return returnValueToList;



    }

public void dealWithRecursiveCallee(Unit currUnit, FlowSet kill, FlowSet gen){
    addAtomUseValueFromUnit(currUnit,gen);


}
    public int getArgIndexOrThisFromCalleeValue(Value v){
        if(v.toString().contains("@parameter")){
            String paras = v.toString();
            String num = paras.substring(paras.indexOf("@parameter")+10,paras.indexOf("@parameter")+11);
            int paraId = Integer.parseInt(num);
            return paraId;
        }
        else if(v.toString().contains("@this")){
            return -1;
        }
        else{
            return -2;
        }

    }
    protected FlowSet linkCalleeToCaller(InvokeExpr invokeCall, FlowSet calleeFlowSet){
        FlowSet callerFlowSet = new ArraySparseSet();

        for(Object elem: calleeFlowSet) {
            int index = getArgIndexOrThisFromCalleeValue(((DataFact)elem).getValue());
            if(index>=0) {
                callerFlowSet.add(new DataFact(invokeCall.getArg(index)));

            }
            else if(index==-1) {
                List<Value> args = invokeCall.getArgs();
                List<ValueBox>useBoxList = invokeCall.getUseBoxes();
                for(ValueBox useBox: useBoxList) {

                    if(!args.contains(useBox.getValue())){

                        callerFlowSet.add(new DataFact(useBox.getValue()));
                    }
                }
            }
            else {
                if(elem instanceof FieldRef) {
                    try{
                        throw new Exception("Summary Flow from FieldRef");
                    }
                    catch(Exception e){
                        System.out.println("==============================");
                        System.out.print("Link Summary for FieldRef: ");
                        System.out.println(elem.toString());
                        System.out.print("for InvokeExpr: ");
                        System.out.println(invokeCall.toString());
                        System.out.println("==============================");

                    }
                    //System.out.println("FlowSet passed back to caller: "+elem);
				/*	List<MethodWrapper> initMethod =  SlicingEngine.fieldVsMethodWrapper.get(((FieldRef) elem).getField().toString());
					if(initMethod!=null) {
					for(MethodWrapper methodWrapper: initMethod) {
					//System.out.println("Its initialization Method: "+methodWrapper.getMethod());
					}
					}*/
                }

                //callerFlowSet.add(elem);
            }
        }
        if(debug_flag){
            System.out.println("=================================");
            System.out.println("Link value in callee to caller");
            System.out.println("InvodeExpr: "+invokeCall);
            System.out.println("calleeFlowSet: "+calleeFlowSet);
            System.out.println("callerFlowSet: "+callerFlowSet);
            System.out.println("=================================");
        }
        return callerFlowSet;

    }

    private void includeOrdinaryUnitInSlice(Slice s,FlowSet inSet, Unit currUnit,FlowSet outSet, FlowSet kill, FlowSet gen){
        slice.markUnit(currUnit,"ON");
        addAtomUseValueFromUnit(currUnit,gen);

    }

    private void summaryConcreteMethod(InvokeExpr invokeExpr,SootMethod sMethod,List<Object>values,FlowSet inSet,Unit currUnit,FlowSet outSet, FlowSet kill, FlowSet gen){

        FlowSet summaryFlowSet = new ArraySparseSet();
        Set<Pair<SootMethod,Value>> summaryPoints = new HashSet<>();
        for(Object v: values){
            summaryPoints.add(new Pair<SootMethod,Value>(sMethod,(Value)v));
        }

        slice.markUnit(currUnit, summaryPoints);
        addUseFromMethodSummary(currUnit,invokeExpr,sMethod, values, gen);

    }

    public List<String> getUnitCategory(Unit u){
        List<String> subInterface = new ArrayList<>();
        if(u instanceof InvokeStmt){
            subInterface.add("InvokeStmt");

        }
        if(u instanceof AssignStmt){
            subInterface.add("AssignStmt");

        }
        if(u instanceof NopStmt){
            subInterface.add("NopStmt");
        }
        if(u instanceof IdentityStmt){
            subInterface.add("IdentityStmt");
        }
        if(u instanceof IfStmt){
            subInterface.add("IfStmt");
        }
        if(u instanceof  GotoStmt){
            subInterface.add("GotoStmt");
        }
        if(u instanceof TableSwitchStmt){
            subInterface.add("TableSwitchStmt");
        }
        if(u instanceof LookupSwitchStmt){
            subInterface.add("LookupSwitchStmt");
        }
        if(u instanceof ReturnStmt){
            subInterface.add("ReturnStmt");
        }
        if(u instanceof ReturnVoidStmt){
            subInterface.add("ReturnVoidStmt");
        }
        if(u instanceof EnterMonitorStmt){
            subInterface.add("EnterMonitorStmt");
        }
        if(u instanceof ExitMonitorStmt){
            subInterface.add("ExitMonitorStmt");
        }
        if(u instanceof ThrowStmt){
            subInterface.add("ThrowStmt");
        }
        if(u instanceof RetStmt){
            subInterface.add("RetStmt");
        }
        if(u instanceof BreakpointStmt){
            subInterface.add("BreakpointStmt");
        }
        return subInterface;




    }



}
