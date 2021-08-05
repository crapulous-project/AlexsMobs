package com.github.alexthe666.alexsmobs.client.model;


import com.github.alexthe666.alexsmobs.entity.EntitySeagull;
import com.github.alexthe666.citadel.client.model.AdvancedEntityModel;
import com.github.alexthe666.citadel.client.model.AdvancedModelBox;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelSeagull extends AdvancedEntityModel<EntitySeagull> {
	private final AdvancedModelBox root;
	private final AdvancedModelBox body;
	private final AdvancedModelBox tail;
	private final AdvancedModelBox head;
	private final AdvancedModelBox beak;
	private final AdvancedModelBox left_wing;
	private final AdvancedModelBox left_wingtip;
	private final AdvancedModelBox left_wingtip_r1;
	private final AdvancedModelBox right_wing;
	private final AdvancedModelBox right_wingtip;
	private final AdvancedModelBox right_wingtip_r1;
	private final AdvancedModelBox left_leg;
	private final AdvancedModelBox right_leg;

	public ModelSeagull() {
		textureWidth = 64;
		textureHeight = 64;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		body = new AdvancedModelBox(this);
		body.setRotationPoint(0.0F, -6.6F, -0.5F);
		root.addChild(body);
		body.setTextureOffset(0, 0).addBox(-2.0F, -2.5F, -4.5F, 4.0F, 5.0F, 9.0F, 0.0F, false);

		tail = new AdvancedModelBox(this);
		tail.setRotationPoint(0.0F, -1.5F, 4.5F);
		body.addChild(tail);
		setRotationAngle(tail, -0.3927F, 0.0F, 0.0F);
		tail.setTextureOffset(18, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);

		head = new AdvancedModelBox(this);
		head.setRotationPoint(0.0F, -0.5F, -4.0F);
		body.addChild(head);
		head.setTextureOffset(16, 26).addBox(-1.5F, -6.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		beak = new AdvancedModelBox(this);
		beak.setRotationPoint(0.0F, -4.0F, -1.5F);
		head.addChild(beak);
		beak.setTextureOffset(11, 15).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		left_wing = new AdvancedModelBox(this);
		left_wing.setRotationPoint(2.0F, -1.5F, -2.5F);
		body.addChild(left_wing);
		left_wing.setTextureOffset(0, 15).addBox(0.0F, -1.0F, -1.0F, 1.0F, 4.0F, 8.0F, 0.0F, false);

		left_wingtip = new AdvancedModelBox(this);
		left_wingtip.setRotationPoint(1.5F, 0.0F, 8.0F);
		left_wing.addChild(left_wingtip);
		

		left_wingtip_r1 = new AdvancedModelBox(this);
		left_wingtip_r1.setRotationPoint(-1.0F, 1.0F, -3.0F);
		left_wingtip.addChild(left_wingtip_r1);
		setRotationAngle(left_wingtip_r1, 0.2182F, 0.0F, 0.0F);
		left_wingtip_r1.setTextureOffset(19, 15).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F, false);

		right_wing = new AdvancedModelBox(this);
		right_wing.setRotationPoint(-2.0F, -1.5F, -2.5F);
		body.addChild(right_wing);
		right_wing.setTextureOffset(0, 15).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 4.0F, 8.0F, 0.0F, true);

		right_wingtip = new AdvancedModelBox(this);
		right_wingtip.setRotationPoint(-1.5F, 0.0F, 8.0F);
		right_wing.addChild(right_wingtip);
		

		right_wingtip_r1 = new AdvancedModelBox(this);
		right_wingtip_r1.setRotationPoint(1.0F, 1.0F, -3.0F);
		right_wingtip.addChild(right_wingtip_r1);
		setRotationAngle(right_wingtip_r1, 0.2182F, 0.0F, 0.0F);
		right_wingtip_r1.setTextureOffset(19, 15).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F, true);

		left_leg = new AdvancedModelBox(this);
		left_leg.setRotationPoint(1.0F, 2.5F, 2.0F);
		body.addChild(left_leg);
		left_leg.setTextureOffset(27, 8).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		right_leg = new AdvancedModelBox(this);
		right_leg.setRotationPoint(-1.0F, 2.5F, 2.0F);
		body.addChild(right_leg);
		right_leg.setTextureOffset(27, 8).addBox(-2.0F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F, 0.0F, true);
		this.updateDefaultPose();
	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root, body, tail, left_wing, left_wingtip, left_wingtip_r1, right_wing, right_wingtip, right_wingtip_r1, right_leg, left_leg, head, beak);
	}

	@Override
	public void setRotationAngles(EntitySeagull entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.resetToDefaultPose();
		float flapSpeed = 0.6F;
		float flapDegree = 0.2F;
		float walkSpeed = 0.8F;
		float walkDegree = 0.6F;
		float idleSpeed = 0.1F;
		float idleDegree = 0.1F;
		float partialTick = Minecraft.getInstance().getRenderPartialTicks();
		float flyProgress = entity.prevFlyProgress + (entity.flyProgress - entity.prevFlyProgress) * partialTick;
		float groundProgress = 5F - flyProgress;
		float flapAmount = (entity.prevFlapAmount + (entity.flapAmount - entity.prevFlapAmount) * partialTick) * flyProgress * 0.2F;
		float biteProgress = entity.prevAttackProgress + (entity.attackProgress - entity.prevAttackProgress) * partialTick;
		progressRotationPrev(head, biteProgress, (float)Math.toRadians(60), 0, 0, 5F);
		progressPositionPrev(head, flyProgress, 0F, 1F, -1F, 5f);
		progressRotationPrev(left_leg, flyProgress, (float) Math.toRadians(85), 0, 0, 5F);
		progressRotationPrev(right_leg, flyProgress, (float) Math.toRadians(85), 0, 0, 5F);
		progressRotationPrev(right_wing, flyProgress,  (float) Math.toRadians(-90),  0,  (float) Math.toRadians(90), 5F);
		progressRotationPrev(left_wing, flyProgress,  (float) Math.toRadians(-90),  0,  (float) Math.toRadians(-90), 5F);
		progressPositionPrev(right_wing, flyProgress, -1F, 0, 2F, 5f);
		progressPositionPrev(left_wing, flyProgress, 1F, 0, 2F, 5f);
		progressPositionPrev(right_wingtip, flyProgress, 0, 0, 2, 5f);
		progressPositionPrev(left_wingtip, flyProgress, 0, 0, 2, 5f);
		progressRotationPrev(left_wingtip, flyProgress, (float) Math.toRadians(-10), 0, 0, 5F);
		progressRotationPrev(right_wingtip, flyProgress, (float) Math.toRadians(-10), 0, 0, 5F);
		progressRotationPrev(tail, flyProgress, (float) Math.toRadians(20), 0, 0, 5F);
		if(flyProgress > 0) {
			this.flap(left_wing, flapSpeed, flapDegree * 5, true, 0F, 0F, ageInTicks, flapAmount);
			this.flap(right_wing, flapSpeed, flapDegree * 5, false, 0F, 0F, ageInTicks, flapAmount);
			this.bob(body, flapSpeed * 0.5F, flapDegree * 10, true, ageInTicks, flapAmount);
			this.walk(head, flapSpeed, flapDegree * 0.4F, true, 2F, -0.1F, ageInTicks, 1);
			this.walk(tail, flapSpeed, flapDegree * 0.6F, true, 3F, 0.1F, ageInTicks, 1);
			this.walk(right_leg, flapSpeed, flapDegree * 0.5F, false, 0F, -0.2F, ageInTicks, 1);
			this.walk(left_leg, flapSpeed, flapDegree * 0.5F, true, 0F, 0.2F, ageInTicks, 1);
		}else{
			this.bob(body, walkSpeed * 1F, walkDegree * 1.3F, true, limbSwing, limbSwingAmount);
			this.walk(right_leg, walkSpeed, walkDegree * 1.85F, false, 0F, 0.2F, limbSwing, limbSwingAmount);
			this.walk(left_leg, walkSpeed, walkDegree * 1.85F, true, 0F, 0.2F, limbSwing, limbSwingAmount);
			this.walk(head, walkSpeed, walkDegree * 0.4F, false, 2F, -0.01F, limbSwing, limbSwingAmount);
			this.flap(tail, walkSpeed, walkDegree * 0.5F, false, 1F, 0F, limbSwing, limbSwingAmount);
		}
		this.swing(tail, idleSpeed, idleDegree, false, 1F, 0F, ageInTicks, 1);
		this.bob(head, idleSpeed * 0.5F, idleDegree * 1.5F, true, ageInTicks, 1);
		head.rotateAngleY += Math.toRadians(entity.getFlightLookYaw()) * flyProgress * 0.2F;
		head.rotateAngleY += netHeadYaw / 57.295776F * groundProgress * 0.2F;
		head.rotateAngleX += headPitch / 57.295776F * groundProgress * 0.2F;

	}

	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}
}