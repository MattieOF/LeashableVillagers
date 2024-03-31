package dev.mattware.leashablevillagers.forge;

import dev.mattware.leashablevillagers.LeashableVillagers;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LeashableVillagers.MOD_ID)
public class LeashableVillagersForge {
    public LeashableVillagersForge() {
        LeashableVillagers.init();
    }
}
