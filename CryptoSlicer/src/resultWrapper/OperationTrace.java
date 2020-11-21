package resultWrapper;

import javafx.util.Pair;
import soot.Unit;
import soot.Value;

import java.util.ArrayList;
import java.util.List;

public class OperationTrace{
    private Pair<Unit, Value> exitFact;
    private Pair<Unit, Value> currFact;
    List<String> operations = new ArrayList<>();
    public OperationTrace(Pair<Unit,Value> exit){
        exitFact = exit;
    }

    public void appendEdge(Unit currUnit, Value v, Edge e){
        if(!e.getOperation().equals("Equal")) {
            operations.add(e.getOperation());
        }
        currFact = new Pair<>(currUnit,v);
    }







}