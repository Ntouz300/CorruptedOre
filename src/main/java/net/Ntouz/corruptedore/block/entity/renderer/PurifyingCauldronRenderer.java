package net.Ntouz.corruptedore.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.Ntouz.corruptedore.block.entity.custom.PurifyingCauldronEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class PurifyingCauldronRenderer implements BlockEntityRenderer<PurifyingCauldronEntity> {
    public PurifyingCauldronRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(PurifyingCauldronEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = pBlockEntity.itemHandler.getStackInSlot(1);

        pPoseStack.pushPose();
        pPoseStack.translate(0.5f, 1.15f, 0.5f);
        pPoseStack.scale(0.5f, 0.5f, 0.5f);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pBlockEntity.getRenderingRotation()));

        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
        pPoseStack.popPose();

        Level level = pBlockEntity.getLevel();
        if (level != null && level.isClientSide()) {
            if (level.random.nextFloat() < 0.005f) {
                for (int i = 0; i < 2; i++) {
                    double baseX = pBlockEntity.getBlockPos().getX() + 0.5;
                    double baseY = pBlockEntity.getBlockPos().getY() + 1.1;
                    double baseZ = pBlockEntity.getBlockPos().getZ() + 0.5;

                    double spread = 0.3;
                    double offsetX = (level.random.nextDouble() - 0.5) * 2 * spread;
                    double offsetZ = (level.random.nextDouble() - 0.5) * 2 * spread;

                    double x = baseX + offsetX;
                    double y = baseY + level.random.nextDouble() * 0.1;
                    double z = baseZ + offsetZ;

                    level.addParticle(ParticleTypes.ENCHANT, x, y, z, 0, 0.02, 0);
                }
            }
        }
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
