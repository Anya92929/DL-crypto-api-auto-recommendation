package resultWrapper;


import soot.SootMethod;
import soot.Unit;

public class UnitWrapper{
    private Unit unit;
    private SootMethod containerMethod;
    private boolean isAtom;
    private boolean isInSlice = true;

    public UnitWrapper(Unit u){
        unit = u;
        set_isAtom_by_default();

    }
    public UnitWrapper(Unit u, SootMethod m){
        unit = u;
        containerMethod = m;
        set_isAtom_by_default();

    }
    public UnitWrapper(Unit u, SootMethod m, boolean inSlice){
        unit = u;
        containerMethod = m;
        isInSlice = inSlice;
        set_isAtom_by_default();
    }









    //Default method to answer isAtom, exceptional case need to manually set the isAtom with setIsAtom().
    public void set_isAtom_by_default(){
        /* Example of unit_string:
        $r1 = virtualinvoke $r3.<java.lang.String: byte[] getBytes(java.lang.String)>("UTF-8")
         */
        String unit_string = unit.toString();
        if (unit_string.contains("invoke")){
            String called_method = unit_string.substring(unit_string.indexOf("<"));
            if (called_method.startsWith("<java.") || called_method.startsWith("<javax.") || called_method.startsWith("<android.")){
                //standard api
                isAtom = true;
            }
            else{
                isAtom = false;
            }

        }
        else{//No invoke in this statement, must be atom statement
            isAtom = true;
        }
    }

    //Manually set isAtom
    public void setIsAtom(boolean atom){
        isAtom = atom;
    }




    //Fetch field methods:

    public Unit getUnit(){
        return unit;
    }
    public SootMethod getContainerMethod(){
        return containerMethod;
    }
    public boolean isAtom(){
        return isAtom;
    }
    public boolean isInSlice(){
        return isInSlice;
    }







}