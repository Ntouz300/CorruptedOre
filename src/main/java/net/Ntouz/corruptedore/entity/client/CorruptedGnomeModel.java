package net.Ntouz.corruptedore.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.entity.custom.CorruptedGnomeEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class CorruptedGnomeModel<T extends CorruptedGnomeEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID, "corrupted_gnome"), "main");
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart main;

    public CorruptedGnomeModel(ModelPart root) {
        this.main = root.getChild("main");
        this.body = main.getChild("body");
        this.head = main.getChild("head");
;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = main.addOrReplaceChild("head", CubeListBuilder.create().texOffs(44, 62).addBox(-2.0F, -6.0F, 3.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 62).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(62, 12).addBox(-4.0F, -6.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(62, 21).addBox(3.0F, -6.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 39).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -4.0F));

        PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 19).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(56, 47).addBox(-5.0F, -2.0F, -6.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(56, 49).addBox(-5.0F, -2.0F, 5.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 39).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(18, 52).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(18, 61).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(54, 62).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 63).addBox(-1.0F, -8.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

        PartDefinition cube_r1 = hat.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(40, 60).addBox(-5.0F, -1.0F, -6.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r2 = hat.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(18, 59).addBox(-5.0F, -1.0F, -6.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition left_foot = main.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(62, 0).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(64, 57).addBox(-1.5F, 1.0F, -4.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -2.0F, 1.0F));

        PartDefinition right_foot = main.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(62, 6).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(62, 64).addBox(-1.5F, 1.0F, -4.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -2.0F, 1.0F));

        PartDefinition left_arm = main.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(62, 60).addBox(-4.0F, 0.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -11.0F, 0.5F));

        PartDefinition left_hand = left_arm.addOrReplaceChild("left_hand", CubeListBuilder.create().texOffs(62, 62).addBox(-4.0F, 0.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 0.0F));

        PartDefinition left_thumb = left_hand.addOrReplaceChild("left_thumb", CubeListBuilder.create(), PartPose.offset(-3.3F, 0.0F, -0.5F));

        PartDefinition cube_r3 = left_thumb.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 63).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition left_thumb_tip = left_thumb.addOrReplaceChild("left_thumb_tip", CubeListBuilder.create(), PartPose.offset(-0.2F, 0.0F, -4.0F));

        PartDefinition cube_r4 = left_thumb_tip.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 67).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition left_pinkie = left_hand.addOrReplaceChild("left_pinkie", CubeListBuilder.create().texOffs(0, 65).addBox(-3.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 0.0F));

        PartDefinition left_pinkie_tip = left_pinkie.addOrReplaceChild("left_pinkie_tip", CubeListBuilder.create().texOffs(16, 67).addBox(-2.0F, 0.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 0.0F, 0.0F));

        PartDefinition left_pointy = left_hand.addOrReplaceChild("left_pointy", CubeListBuilder.create().texOffs(18, 48).addBox(-5.0F, 0.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, -1.0F));

        PartDefinition left_pointy_tip = left_pointy.addOrReplaceChild("left_pointy_tip", CubeListBuilder.create().texOffs(8, 66).addBox(-3.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 0.0F));

        PartDefinition right_arm = main.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(64, 51).addBox(0.0F, 0.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -11.0F, 0.5F));

        PartDefinition right_hand = right_arm.addOrReplaceChild("right_hand", CubeListBuilder.create().texOffs(64, 53).addBox(0.0F, 0.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.0F));

        PartDefinition right_thumb = right_hand.addOrReplaceChild("right_thumb", CubeListBuilder.create(), PartPose.offset(3.5F, 0.0F, -0.5F));

        PartDefinition cube_r5 = right_thumb.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(64, 55).addBox(0.0F, 0.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition right_thumb_tip = right_thumb.addOrReplaceChild("right_thumb_tip", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -4.0F));

        PartDefinition cube_r6 = right_thumb_tip.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(22, 67).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition right_pinkie = right_hand.addOrReplaceChild("right_pinkie", CubeListBuilder.create().texOffs(54, 66).addBox(0.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.0F));

        PartDefinition right_pinkie_tip = right_pinkie.addOrReplaceChild("right_pinkie_tip", CubeListBuilder.create().texOffs(28, 67).addBox(0.0F, 0.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, 0.0F));

        PartDefinition right_pointy = right_hand.addOrReplaceChild("right_pointy", CubeListBuilder.create().texOffs(18, 50).addBox(0.0F, 0.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, -1.0F));

        PartDefinition right_pointy_tip = right_pointy.addOrReplaceChild("right_pointy_tip", CubeListBuilder.create().texOffs(62, 66).addBox(0.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 0.0F, 0.0F));

        PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -10.0F, -5.0F, 12.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(44, 0).addBox(-7.0F, -9.0F, -4.0F, 1.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 48).addBox(6.0F, -9.0F, -4.0F, 1.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(34, 68).addBox(7.0F, -6.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(52, 68).addBox(-8.0F, -6.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(42, 52).addBox(-5.0F, -9.0F, -6.0F, 10.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 30).addBox(-5.0F, -6.0F, -7.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(2.0F, -6.0F, -7.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 23).addBox(-5.0F, -6.0F, 6.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 19).addBox(-2.0F, -7.0F, -7.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(56, 39).addBox(-5.0F, -9.0F, 5.0F, 10.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-5.0F, -11.0F, -4.0F, 10.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(36, 30).addBox(-5.0F, -1.0F, -4.0F, 10.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(5.0F, -6.0F, 5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 19).addBox(5.0F, -6.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 2).addBox(-6.0F, -6.0F, 5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 8).addBox(-6.0F, -6.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 0).addBox(6.0F, -6.0F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 19).addBox(6.0F, -6.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 6).addBox(-7.0F, -6.0F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(-7.0F, -6.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 96, 96);
    }


    @Override
    public void setupAnim(CorruptedGnomeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(-netHeadYaw, headPitch);

        this.animateWalk(CorruptedGnomeAnimations.CORRUPTED_GNOME_RUNNING_CLOSELY, -limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, CorruptedGnomeAnimations.CORRUPTED_GNOME_IDLE, ageInTicks, 1F);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        main.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return main;
    }
}
