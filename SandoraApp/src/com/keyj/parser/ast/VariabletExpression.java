package com.keyj.parser.ast;

import com.keyj.lib.Value;
import com.keyj.lib.Variables;


public final class VariabletExpression implements Expression {
    
    private final String name;
    
    public VariabletExpression(String name) {
        this.name = name;
    }

    @Override
    public Value eval() {
        if (!Variables.isExists(name)) throw new RuntimeException("Constant does not exists");
        return Variables.get(name);
    }

    @Override
    public String toString() {
//        return String.format("%s [%f]", name, Constants.get(name));
        return String.format("%s", name);
    }
}
