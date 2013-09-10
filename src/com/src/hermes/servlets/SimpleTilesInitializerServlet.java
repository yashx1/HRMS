/*
 * $Id: SimpleTilesInitializerServlet.java 797540 2009-07-24 15:42:00Z apetrelli $
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

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import org.apache.tiles.startup.TilesInitializer;
import org.apache.tiles.web.startup.AbstractTilesInitializerServlet;

import com.src.hermes.helpers.HermesTilesInitializer;


/**
 * A Tiles initializer servlet that is responsible for setting up Tiles using Tiles Factory.
 * @author Yashaswi Kumar <yashx1@gmail.com>
 * @since 2.2.0
 */
@WebServlet(loadOnStartup=1,urlPatterns={"/_init"})
public class SimpleTilesInitializerServlet extends AbstractTilesInitializerServlet {

	public SimpleTilesInitializerServlet() {
		super();
	}
    /** {@inheritDoc} */
    @Override
    protected TilesInitializer createTilesInitializer() {
        return new HermesTilesInitializer();
    }
}
