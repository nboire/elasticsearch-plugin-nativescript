package org.nboire.elasticsearch.plugin;

import org.elasticsearch.common.Nullable;
import org.elasticsearch.script.ExecutableScript;
import org.elasticsearch.script.NativeScriptFactory;

import java.util.Map;

/**
 * User: nboire
 * Date: 23/10/12
 */
public class EsScore implements NativeScriptFactory {

    public ExecutableScript newScript(@Nullable Map<String, Object> params) {
        return new EsScoreScript(params);
    }
}
