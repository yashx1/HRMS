/*
 * $Id: DashboardTilesDispatchServlet.java 791161 2009-07-04 18:53:36Z apetrelli $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.src.hermes.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.TilesContainer;
import org.apache.tiles.reflect.ClassUtil;
import org.apache.tiles.servlet.context.ServletUtil;
import org.apache.tiles.web.util.AttributeContextMutator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Tiles dispatching servlet used to bind Tiles to *.view definition pattern.
 */
@WebServlet(urlPatterns={"*.view"}, loadOnStartup=2)
public class DashboardTilesDispatchServlet extends HttpServlet {

    /**
     * Init parameter to define the key of the container to use.
     *
     * @since 2.1.2
     */
    public static final String CONTAINER_KEY_INIT_PARAMETER =
        "org.apache.tiles.web.util.TilesDispatchServlet.CONTAINER_KEY";

    /**
     * The logging object.
     */
    private final Logger log = LoggerFactory.getLogger(DashboardTilesDispatchServlet.class);

    /**
     * The key under which the container is stored.
     */
    private String containerKey;

    /**
     * The object that will mutate the attribute context so that it uses
     * different attributes.
     */
    private AttributeContextMutator mutator;


    /** {@inheritDoc} */
    public void init() throws ServletException {
        
    	super.init();

        containerKey = getServletConfig().getInitParameter(CONTAINER_KEY_INIT_PARAMETER);

        String temp = getInitParameter("mutator");
        
        if (temp != null) {
            try {
                mutator = (AttributeContextMutator) ClassUtil.instantiate(temp);
            } 
            catch (Exception e) {
                throw new ServletException("Unable to instantiate specified context mutator.", e);
            }
        } else {
            mutator = new DefaultMutator();
        }
    }

    /** {@inheritDoc} */
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        TilesContainer container = ServletUtil.getContainer(getServletContext(), containerKey);
        mutator.mutate(container.getAttributeContext(req, res), req);
        String definition = getDefinitionName(req);
        if (log.isDebugEnabled()) {
            log.info("Dispatching to tile '" + definition + "'");
        }
        container.render(definition, req, res);
    }

    /**
     * Returns the called definition name for the given request.
     *
     * @param request The request to parse.
     * @return The definition name to render.
     */
    protected String getDefinitionName(HttpServletRequest request) {
        String path = (String) request.getAttribute("javax.servlet.include.servlet_path");
        if (path == null) {
            path = request.getServletPath();          
        }

        if (log.isDebugEnabled()) {
            log.info("Displaying getServletPath = '" + path + "'");
        }
        
        int start = path.startsWith("/") ? 1 : 0;
        int end = path.endsWith(".tiles") ? path.indexOf(".tiles") : path.length();

        return path.substring(start, end);
    }

    /** {@inheritDoc} */
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        log.info("Tiles dispatch request received. Redirecting POST to GET.");
        doGet(req, res);
    }

    /**
     * Default no-op mutator.
     */
    class DefaultMutator implements AttributeContextMutator {

        /** {@inheritDoc} */
        public void mutate(AttributeContext context, ServletRequest request) {
            // noop;
        }
    }
}
