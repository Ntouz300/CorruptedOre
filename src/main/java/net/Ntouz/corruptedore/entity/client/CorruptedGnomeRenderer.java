package net.Ntouz.corruptedore.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.entity.custom.CorruptedGnomeEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CorruptedGnomeRenderer extends MobRenderer<CorruptedGnomeEntity, CorruptedGnomeModel<CorruptedGnomeEntity>> {
    public CorruptedGnomeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CorruptedGnomeModel<>(pContext.bakeLayer(CorruptedGnomeModel.LAYER_LOCATION)), 0.85f);
    }

    @Override
    public ResourceLocation getTextureLocation(CorruptedGnomeEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID, "textures/entity/corrupted_gnome/corrupted_gnome_skin_1.png");
    }

    @Override
    public void render(CorruptedGnomeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.7f, 0.7f, 0.7f);
        } else {
            pPoseStack.scale(1f, 1f, 1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
