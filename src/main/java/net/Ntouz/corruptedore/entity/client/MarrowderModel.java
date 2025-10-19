package net.Ntouz.corruptedore.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.entity.custom.MarrowderEntity;
import net.Ntouz.corruptedore.entity.custom.SmallStalwartGolemEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class MarrowderModel<T extends MarrowderEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID, "marrowder"), "main");
    private final ModelPart head;
    private final ModelPart body;

    public MarrowderModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = body.getChild("head");

    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 1.0F));

        PartDefinition lower_body = body.addOrReplaceChild("lower_body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition spine = lower_body.addOrReplaceChild("spine", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bottom_spine = spine.addOrReplaceChild("bottom_spine", CubeListBuilder.create().texOffs(40, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(30, 45).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition middle_spine = spine.addOrReplaceChild("middle_spine", CubeListBuilder.create().texOffs(18, 37).addBox(-1.0F, -9.0F, -2.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(36, 36).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 1.0F));

        PartDefinition upper_spine = spine.addOrReplaceChild("upper_spine", CubeListBuilder.create().texOffs(36, 32).addBox(-1.5F, -5.0F, -3.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 1.0F));

        PartDefinition left_lower_rib = lower_body.addOrReplaceChild("left_lower_rib", CubeListBuilder.create().texOffs(22, 46).addBox(-4.5F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 46).addBox(-4.0F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(18, 43).addBox(-3.6F, 0.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 40).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -3.2F, 1.0F));

        PartDefinition cube_r1 = left_lower_rib.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(46, 7).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 5.0F, -5.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r2 = left_lower_rib.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 40).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 5.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition left_upper_rib = lower_body.addOrReplaceChild("left_upper_rib", CubeListBuilder.create().texOffs(44, 42).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 43).addBox(-3.6F, 0.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 47).addBox(-4.0F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 47).addBox(-4.5F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -8.7F, 1.0F));

        PartDefinition cube_r3 = left_upper_rib.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(42, 46).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 5.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r4 = left_upper_rib.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(46, 46).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 5.0F, -5.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition left_middle_rib = lower_body.addOrReplaceChild("left_middle_rib", CubeListBuilder.create().texOffs(44, 38).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 7).addBox(-3.6F, 0.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 45).addBox(-4.0F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 45).addBox(-4.5F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -6.2F, 1.0F));

        PartDefinition cube_r5 = left_middle_rib.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(46, 5).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 5.0F, -7.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r6 = left_middle_rib.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(46, 3).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 5.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r7 = left_middle_rib.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 46).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 5.0F, -5.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition right_lower_rib = lower_body.addOrReplaceChild("right_lower_rib", CubeListBuilder.create().texOffs(6, 45).addBox(0.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 44).addBox(1.6F, 0.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 47).addBox(3.0F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 48).addBox(3.5F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -3.2F, 1.0F));

        PartDefinition cube_r8 = right_lower_rib.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(18, 45).addBox(0.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 5.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r9 = right_lower_rib.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(48, 0).addBox(0.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 5.0F, -5.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition right_upper_rib = lower_body.addOrReplaceChild("right_upper_rib", CubeListBuilder.create().texOffs(44, 44).addBox(0.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 43).addBox(1.6F, 0.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 47).addBox(3.0F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 47).addBox(3.5F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -8.7F, 1.0F));

        PartDefinition cube_r10 = right_upper_rib.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(34, 47).addBox(0.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 5.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r11 = right_upper_rib.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(30, 47).addBox(0.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 5.0F, -5.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition right_middle_rib = lower_body.addOrReplaceChild("right_middle_rib", CubeListBuilder.create().texOffs(12, 45).addBox(0.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 36).addBox(1.6F, 0.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 48).addBox(3.0F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 34).addBox(3.5F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -6.2F, 1.0F));

        PartDefinition cube_r12 = right_middle_rib.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(20, 48).addBox(0.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 5.0F, -7.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r13 = right_middle_rib.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(24, 48).addBox(0.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 5.0F, -6.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r14 = right_middle_rib.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(48, 32).addBox(0.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 5.0F, -5.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, -1.0F));

        PartDefinition left_eye = head.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(0, 38).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -7.0F, -1.0F));

        PartDefinition right_eye = head.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(8, 38).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -7.0F, -1.0F));

        PartDefinition skull = head.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(24, 50).addBox(-3.0F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 50).addBox(2.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 37).addBox(-2.0F, -4.0F, -5.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 6).addBox(-3.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 4).addBox(2.0F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 42).addBox(3.0F, -4.0F, -6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 22).addBox(-5.0F, -5.0F, -6.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 42).addBox(-5.0F, -4.0F, -6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 20).addBox(-5.0F, -2.0F, -6.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 49).addBox(-3.0F, -8.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 49).addBox(2.0F, -8.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 49).addBox(1.0F, -6.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 48).addBox(-2.0F, -6.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 42).addBox(-1.0F, -8.0F, -6.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 40).addBox(3.0F, -8.0F, -6.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 3).addBox(-5.0F, -8.0F, -6.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 17).addBox(-5.0F, -10.0F, -6.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -10.0F, 3.0F, 10.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r15 = skull.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 10).addBox(-4.0F, -6.0F, 2.0F, 8.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -4.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r16 = skull.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(18, 10).addBox(-4.0F, -6.0F, 2.0F, 8.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -4.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r17 = skull.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -6.0F, 2.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -7.0F, -1.0F, 0.0F, -1.5708F, 1.5708F));

        PartDefinition cube_r18 = skull.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(18, 20).addBox(-4.0F, -6.0F, 2.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 1.0F, -1.0F, 0.0F, -1.5708F, 1.5708F));

        PartDefinition cube_r19 = skull.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(22, 0).addBox(-4.0F, -6.0F, 2.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, -1.0F, 0.0F, -1.5708F, 1.5708F));

        PartDefinition cube_r20 = skull.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(18, 29).addBox(-4.0F, -5.0F, 2.0F, 8.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -7.0F, -1.0F, 0.0F, -1.5708F, 3.1416F));

        PartDefinition cube_r21 = skull.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 29).addBox(-4.0F, -6.0F, 2.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -8.0F, -1.0F, 0.0F, -1.5708F, 1.5708F));

        PartDefinition cube_r22 = skull.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(36, 9).addBox(-4.0F, 0.0F, 2.0F, 8.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 7.0F, -3.1416F, 0.0F, 0.0F));

        PartDefinition cube_r23 = skull.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(36, 9).addBox(-4.0F, -5.0F, 2.0F, 8.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -7.0F, -1.0F, 0.0F, -1.5708F, 3.1416F));

        PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(8.5F, -11.5F, -4.7F));

        PartDefinition right_arm_finger_1 = right_arm.addOrReplaceChild("right_arm_finger_1", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -5.8F));

        PartDefinition cube_r24 = right_arm_finger_1.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(36, 49).addBox(3.0F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -4.0F, -4.0F, 0.0F, -1.5708F, 3.1416F));

        PartDefinition right_arm_finger_3 = right_arm.addOrReplaceChild("right_arm_finger_3", CubeListBuilder.create(), PartPose.offset(1.0F, 0.0F, -5.8F));

        PartDefinition cube_r25 = right_arm_finger_3.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 50).addBox(3.0F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -5.0F, -4.0F, 0.0F, -1.5708F, 3.1416F));

        PartDefinition right_arm_finger_2 = right_arm.addOrReplaceChild("right_arm_finger_2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -5.8F));

        PartDefinition cube_r26 = right_arm_finger_2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(50, 2).addBox(3.0F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -5.0F, -4.0F, 0.0F, -1.5708F, 3.1416F));

        PartDefinition right_arm_base = right_arm.addOrReplaceChild("right_arm_base", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r27 = right_arm_base.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(36, 24).addBox(-2.0F, -5.0F, 2.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -3.5F, -4.3F, 0.0F, -1.5708F, 3.1416F));

        PartDefinition cube_r28 = right_arm_base.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(50, 38).addBox(3.0F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -4.0F, -4.0F, 0.0F, -1.5708F, 3.1416F));

        PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(-8.5F, -11.5F, -4.7F));

        PartDefinition left_arm_finger_2 = left_arm.addOrReplaceChild("left_arm_finger_2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -5.8F));

        PartDefinition cube_r29 = left_arm_finger_2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(32, 49).addBox(-4.0F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -5.0F, -4.0F, 0.0F, 1.5708F, -3.1416F));

        PartDefinition left_arm_finger_3 = left_arm.addOrReplaceChild("left_arm_finger_3", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, -5.8F));

        PartDefinition cube_r30 = left_arm_finger_3.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(28, 49).addBox(-4.0F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -5.0F, -4.0F, 0.0F, 1.5708F, -3.1416F));

        PartDefinition left_arm_finger_1 = left_arm.addOrReplaceChild("left_arm_finger_1", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -5.8F));

        PartDefinition cube_r31 = left_arm_finger_1.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(16, 49).addBox(-4.0F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, -4.0F, 0.0F, 1.5708F, -3.1416F));

        PartDefinition left_arm_base = left_arm.addOrReplaceChild("left_arm_base", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r32 = left_arm_base.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(36, 28).addBox(-4.0F, -5.0F, 2.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -3.5F, -4.3F, 0.0F, 1.5708F, -3.1416F));

        PartDefinition cube_r33 = left_arm_base.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(50, 36).addBox(-4.0F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -4.0F, -4.0F, 0.0F, 1.5708F, -3.1416F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }


    @Override
    public void setupAnim(MarrowderEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(MarrowderAnimations.MARROWDER_ATTACKING, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, MarrowderAnimations.MARROWDER_IDLE, ageInTicks, 1F);
        this.animate(entity.attackAnimationState, MarrowderAnimations.MARROWDER_ATTACKING, ageInTicks, 1F);

    }


    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}
