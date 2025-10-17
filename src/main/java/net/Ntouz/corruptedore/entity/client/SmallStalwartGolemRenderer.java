package net.Ntouz.corruptedore.entity.client;

import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.entity.custom.SmallStalwartGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SmallStalwartGolemRenderer extends MobRenderer<SmallStalwartGolemEntity, SmallStalwartGolemModel<SmallStalwartGolemEntity>> {

    @Override
    public ResourceLocation getTextureLocation(SmallStalwartGolemEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID, "textures/entity/small_stalwart_golem/small_stalwart_golem_skin_1.png");
    }

    public SmallStalwartGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new SmallStalwartGolemModel<>(context.bakeLayer(SmallStalwartGolemModel.LAYER_LOCATION)), 0.4F);
    }
}
