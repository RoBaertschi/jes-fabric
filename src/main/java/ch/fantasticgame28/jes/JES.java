package ch.fantasticgame28.jes;

import ch.fantasticgame28.jes.items.ModItems;
import net.fabricmc.api.ModInitializer;

public class JES implements ModInitializer {

    public static final String MOD_ID = "jes";

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
    }
}
