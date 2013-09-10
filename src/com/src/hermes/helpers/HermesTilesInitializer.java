package com.src.hermes.helpers;

import org.apache.tiles.TilesApplicationContext;
import org.apache.tiles.factory.AbstractTilesContainerFactory;
import org.apache.tiles.startup.AbstractTilesInitializer;

/**
 * Tiles Initializer which uses Tiles Initialer Factory.
 * 
 * @author Yashaswi Kumar <yashx1@gmail.com>
 * 
 */
public class HermesTilesInitializer extends AbstractTilesInitializer {

	@Override
	protected AbstractTilesContainerFactory createContainerFactory(TilesApplicationContext arg0) {
		return new TilesContainerFactory();
	}
	
}
