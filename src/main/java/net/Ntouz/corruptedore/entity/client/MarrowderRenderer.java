package net.Ntouz.corruptedore.entity.client;

import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.entity.custom.MarrowderEntity;
import net.Ntouz.corruptedore.entity.custom.SmallStalwartGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MarrowderRenderer extends MobRenderer<MarrowderEntity, MarrowderModel<MarrowderEntity>> {

    @Override
    public ResourceLocation getTextureLocation(MarrowderEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID, "textures/entity/marrowder/marrowder_skin_1.png");
    }

    public MarrowderRenderer(EntityRendererProvider.Context context) {
        super(context, new MarrowderModel<>(context.bakeLayer(MarrowderModel.LAYER_LOCATION)), 0.6F);
    }
}
