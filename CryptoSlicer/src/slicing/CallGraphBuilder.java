package slicing;

import main.analyzer.backward.MethodWrapper;
import main.util.NamedMethodMap;
import main.util.Utils;
import org.jboss.util.Null;
import soot.*;
import soot.options.Options;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.util.Chain;

import java.io.IOException;
import java.util.*;


import static slicing.SlicingEngine.CRITERIA_CLASSES;

public class CallGraphBuilder{

    private String analyzedProjectName;
    public static Map<String, List<SootClass>> classHierarchy=null;
    public static Map<String, List<MethodWrapper>> fieldVsMethodWrapper=null;
    public static List<String> classNames;


    public CallGraphBuilder(String name,List<String> classes){
        analyzedProjectName=name;
        classNames=classes;

    }

    public void buildCallGraph() throws IOException {


        //Use callgraph builder from cryptoGuard
        NamedMethodMap.build(classNames);
        NamedMethodMap.addCriteriaClasses(CRITERIA_CLASSES);

        NamedMethodMap.buildCallerCalleeRelation(classNames);
        classHierarchy = Utils.getClassHierarchyAnalysis(classNames);
        BuildFieldMap();

    }
    public static void BuildFieldMap() {
        if (fieldVsMethodWrapper == null) {

            fieldVsMethodWrapper = new HashMap<>();

            for (String className : classNames) {

                SootClass sClass = Scene.v().loadClassAndSupport(className);

                Chain<SootField> sootFields = sClass.getFields();

                for (SootField field : sootFields) {

                    List<MethodWrapper> initMethods = new ArrayList<>();

                    List<SootMethod> methodList = sClass.getMethods();

                    for (SootMethod method : methodList) {

                        if (method.isConcrete()) {

                            StringBuilder methodBody = new StringBuilder();

                            try {
                                Body initBody = method.retrieveActiveBody();
                                UnitGraph graph = new ExceptionalUnitGraph(initBody);

                                for (Object aGraph : graph) {
                                    methodBody.append(aGraph);
                                }

                                if (methodBody.toString().contains(field.toString() + " =")) {
                                    initMethods.add(NamedMethodMap.getMethod(method.toString()));
                                }
                            } catch (RuntimeException e) {
                                System.err.println(e);
                                continue;
                            }
                        }

                    }

                    fieldVsMethodWrapper.put(field.toString(), initMethods);
                }

            }
        }
    }








    public String getAnalyzedProjectName(){
        return analyzedProjectName;
    }






}