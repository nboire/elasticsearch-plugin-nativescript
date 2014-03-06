package org.nboire.elasticsearch.plugin;

import org.elasticsearch.index.fielddata.ScriptDocValues;
import org.elasticsearch.script.AbstractDoubleSearchScript;

import java.util.List;
import java.util.Map;

public class EsScoreScript extends AbstractDoubleSearchScript {

    private final Map<String, Object> params;

    public EsScoreScript(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public double runAsDouble() {


        ScriptDocValues monfield = (ScriptDocValues) doc().get("name");
        List<?> values = monfield.getValues();
        if(!values.isEmpty()) {
            Object o = params.get((String) values.get(0));
            if(o == null) {
                return -1D;
            }
            return (Double) o;
        }

        return 0.0;
    }
}