package logoparsing;

import java.util.HashMap;

class VarProcedureStorer {

    private final HashMap<String,Integer> varNameMap = new HashMap<String,Integer>();
    private final HashMap<Integer,String> indexMap = new HashMap<Integer,String>();
    private int argCounter = 1;

    public void addVar(String varName) {
        String value = "---";
        
        varNameMap.put(varName, argCounter);
        indexMap.put(argCounter, value);

        argCounter++;
    }

    public void initVar(int index, String value) {
        indexMap.put(index, value);
    }

    public String getValue(String name) {
        int index = varNameMap.get(name);
        return indexMap.get(index);
    }

    public Iterable<String> getVarNames() {
        return varNameMap.keySet();
    }
}
