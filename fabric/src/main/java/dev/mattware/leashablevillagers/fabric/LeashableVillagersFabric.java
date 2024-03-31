package dev.mattware.leashablevillagers.fabric;

import dev.mattware.leashablevillagers.LeashableVillagers;
import net.fabricmc.api.ModInitializer;

public class LeashableVillagersFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        LeashableVillagers.init();
    }
}
