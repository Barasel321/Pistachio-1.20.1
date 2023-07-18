package net.barasel321.pistachio.painting;

import net.barasel321.pistachio.Pistachio;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PistachioPaintings {

    public static final PaintingVariant TOFU = registerPainting("tofu", new PaintingVariant(16,32));

    private static PaintingVariant registerPainting(String name, PaintingVariant painting){
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(Pistachio.MOD_ID, name), painting);
    }

    public static void registerPaintings(){
        Pistachio.LOGGER.info("registering paintings");
    }
}
