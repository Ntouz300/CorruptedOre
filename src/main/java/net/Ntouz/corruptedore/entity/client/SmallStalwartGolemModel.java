package net.Ntouz.corruptedore.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.entity.custom.CorruptedGnomeEntity;
import net.Ntouz.corruptedore.entity.custom.SmallStalwartGolemEntity;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SmallStalwartGolemModel<T extends SmallStalwartGolemEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID, "small_stalwart_golem"), "main");
    private final ModelPart head;
    private final ModelPart body;

    public SmallStalwartGolemModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = body.getChild("head");

    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition lower_body = body.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -9.0F, -4.0F, 6.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(14, 15).addBox(-4.0F, -8.0F, -3.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(3.0F, -8.0F, -3.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_leg = lower_body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(16, 26).addBox(-2.0F, -2.0F, 1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_leg = lower_body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(28, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, -4.0F));

        PartDefinition cube_r1 = right_arm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 4).addBox(-5.0F, -1.0F, -1.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 4.0F));

        PartDefinition cube_r2 = left_arm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(28, 7).addBox(-5.0F, -1.0F, 0.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 26).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);

    }


    @Override
    public void setupAnim(SmallStalwartGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(-netHeadYaw, headPitch);

        this.animateWalk(SmallStalwartGolemAnimations.SMALL_STALWART_GOLEM_WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, SmallStalwartGolemAnimations.SMALL_STALWART_GOLEM_IDLE, ageInTicks, 1F);
        this.animate(entity.attackAnimationState, SmallStalwartGolemAnimations.SMALL_STALWART_GOLEM_ATTACKING, ageInTicks, 1F);

    }


    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        poseStack.mulPose(Axis.YP.rotationDegrees(-90.0F));
        poseStack.translate(0, -0.2f, 0);
        poseStack.scale(1.2f, 1.2f, 1.2f);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}
