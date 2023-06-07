package dev.mattware.leashablevillagers;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeashableVillagers implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("leashablevillagers");

    @Override
    public void onInitialize() {
        LOGGER.info("Leashable Villagers has initialised. You're awful.");
    }
}
