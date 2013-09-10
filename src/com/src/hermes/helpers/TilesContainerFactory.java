package com.src.hermes.helpers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.tiles.TilesApplicationContext;
import org.apache.tiles.context.TilesRequestContextFactory;
import org.apache.tiles.factory.BasicTilesContainerFactory;
import org.apache.tiles.factory.TilesContainerFactoryException;


/**
 * Loads definitions from tiles-defs.xml
 * 
 * @author Yashaswi Kumar <yashx1@gmail.com>
 * 
 */

public class TilesContainerFactory extends BasicTilesContainerFactory {
	@Override
	protected List<URL> getSourceURLs(
			TilesApplicationContext applicationContext,
			TilesRequestContextFactory contextFactory) {
		List<URL> retValue = new ArrayList<URL>(1);
		try {
			retValue.add(applicationContext
					.getResource("/WEB-INF/tiles-defs.xml"));
		} catch (IOException e) {
			throw new TilesContainerFactoryException(
					"Cannot get URL: /WEB-INF/tiles-defs.xml", e);
		}
		return retValue;
	}
}
