package logoparsing;

import java.util.HashMap;

class Procedure {

    private final HashMap<String,Integer> varNameMap = new HashMap<String,Integer>();
    private final HashMap<Integer,String> indexMap = new HashMap<Integer,String>();
    private int argCounter = 1;
    private final String name;
    private int index;

    public Procedure(String name) {
        this.name = name;
    }

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

    public boolean hasVar(String varName) {
        return varNameMap.containsKey(varName);
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
