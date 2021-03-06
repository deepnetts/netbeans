/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.ide.branding;

import javax.script.ScriptEngine;
import junit.framework.Test;
import org.netbeans.core.network.proxy.pac.impl.NbPacScriptEvaluatorTest;
import org.netbeans.junit.NbModuleSuite;
import org.netbeans.junit.NbTestCase;

public class RealPacEngineTest extends NbTestCase {

    public RealPacEngineTest(String name) {
        super(name);
    }

    public static Test suite() {
        return NbModuleSuite.createConfiguration(RealPacEngineTest.class)
            .clusters(".*")
            .enableModules(".*")
            .honorAutoloadEager(true)
            .gui(false)
            .suite();
    }

    public void testRealEngineForPacEvaluation() {
        StringBuilder err = new StringBuilder();
        ScriptEngine eng = NbPacScriptEvaluatorTest.findDefaultEngineInTheSystem(err);
        assertEquals("No error: " + err, 0, err.length());
        assertNotNull("Engine found", eng);
        assertEquals("GraalVM:js", eng.getFactory().getEngineName());
    }
}
