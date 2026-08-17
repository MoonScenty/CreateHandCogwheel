package me.moonscenty.createhandcogwheel.ponder;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.base.RotatedPillarKineticBlock;
import com.simibubi.create.content.kinetics.crank.HandCrankBlock;
import com.simibubi.create.foundation.ponder.CreateSceneBuilder;

import me.moonscenty.createhandcogwheel.CreateHandCogwheel;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

public final class HandCogwheelPonderScenes {
    private HandCogwheelPonderScenes() {
    }

    public static void manualPower(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("hand_cogwheel_manual", "Generating Rotational Force with a Hand Cogwheel");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();

        BlockPos handCogwheel = util.grid().at(2, 2, 2);
        BlockState handCogwheelState = CreateHandCogwheel.HAND_COGWHEEL.get().defaultBlockState()
                .setValue(HandCrankBlock.FACING, Direction.UP);

        scene.world().setBlock(handCogwheel, handCogwheelState, false);
        scene.world().showSection(util.select().layersFrom(1), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(70)
                .text("The Hand Cogwheel combines a Hand Crank with a small Cogwheel")
                .pointAt(util.vector().centerOf(handCogwheel))
                .placeNearTarget();
        scene.idle(80);

        scene.overlay().showControls(util.vector().topOf(handCogwheel), Pointing.DOWN, 40)
                .rightClick();
        scene.overlay().showText(60)
                .text("Hold Right-Click to turn the handle and generate temporary rotational force")
                .pointAt(util.vector().topOf(handCogwheel))
                .placeNearTarget()
                .attachKeyFrame();
        scene.world().setKineticSpeed(util.select().everywhere(), 32);
        scene.effects().rotationDirectionIndicator(handCogwheel);
        scene.idle(70);

        scene.world().setKineticSpeed(util.select().everywhere(), 0);
        scene.overlay().showControls(util.vector().topOf(handCogwheel), Pointing.DOWN, 35)
                .rightClick()
                .whileSneaking();
        scene.overlay().showText(55)
                .text("Sneak while using it to reverse the generated rotation")
                .pointAt(util.vector().topOf(handCogwheel))
                .placeNearTarget();
        scene.world().setKineticSpeed(util.select().everywhere(), -32);
        scene.effects().rotationDirectionIndicator(handCogwheel);
        scene.idle(65);

        scene.overlay().showText(70)
                .colored(PonderPalette.RED)
                .text("Turning it consumes hunger according to Create's crankHungerMultiplier setting")
                .pointAt(util.vector().centerOf(handCogwheel))
                .placeNearTarget()
                .attachKeyFrame();
        scene.idle(80);

        scene.overlay().showText(60)
                .text("The Extendo Grip retains Create's normal exemption from crank hunger consumption")
                .pointAt(util.vector().centerOf(handCogwheel))
                .placeNearTarget();
        scene.idle(70);
    }

    public static void cogConnection(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("hand_cogwheel_cogs", "Connecting a Hand Cogwheel to Cogwheels");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();

        BlockPos handCogwheel = util.grid().at(2, 1, 2);
        BlockPos cogwheel = util.grid().at(3, 1, 2);
        BlockPos secondCogwheel = util.grid().at(4, 1, 2);
        BlockState handState = CreateHandCogwheel.HAND_COGWHEEL.get().defaultBlockState()
                .setValue(HandCrankBlock.FACING, Direction.UP);
        BlockState cogState = AllBlocks.COGWHEEL.get().defaultBlockState()
                .setValue(RotatedPillarKineticBlock.AXIS, Direction.Axis.Y);

        scene.world().setBlock(handCogwheel, handState, false);
        scene.world().setBlock(cogwheel, cogState, false);
        scene.world().setBlock(secondCogwheel, cogState, false);
        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(70)
                .text("Its cogwheel teeth mesh with adjacent small Cogwheels on the same axis")
                .pointAt(util.vector().blockSurface(handCogwheel, Direction.EAST))
                .placeNearTarget();
        scene.effects().indicateSuccess(cogwheel);
        scene.idle(80);

        scene.world().setKineticSpeed(util.select().position(handCogwheel), 32);
        scene.world().setKineticSpeed(util.select().position(cogwheel), -32);
        scene.world().setKineticSpeed(util.select().position(secondCogwheel), 32);
        scene.effects().rotationDirectionIndicator(handCogwheel);
        scene.effects().rotationDirectionIndicator(cogwheel);
        scene.overlay().showText(65)
                .text("Each meshed Cogwheel rotates in the opposite direction and relays the generated force")
                .pointAt(util.vector().centerOf(cogwheel))
                .placeNearTarget()
                .attachKeyFrame();
        scene.idle(75);

        scene.overlay().showText(65)
                .colored(PonderPalette.RED)
                .text("Cogwheels only mesh when their rotation axes and relative positions are compatible")
                .pointAt(util.vector().centerOf(secondCogwheel))
                .placeNearTarget();
        scene.idle(75);

        scene.overlay().showControls(util.vector().topOf(handCogwheel), Pointing.DOWN, 35)
                .withItem(CreateHandCogwheel.HAND_COGWHEEL_ITEM.get().getDefaultInstance());
        scene.overlay().showText(65)
                .text("Hold a Hand Cogwheel and look near a Cogwheel's rim to preview a valid placement")
                .pointAt(util.vector().topOf(cogwheel))
                .placeNearTarget()
                .attachKeyFrame();
        scene.idle(75);
    }

    public static void shaftConnection(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("hand_cogwheel_shafts", "Connecting a Hand Cogwheel to Shafts");
        scene.configureBasePlate(0, 0, 5);
        scene.showBasePlate();

        BlockPos handCogwheel = util.grid().at(1, 1, 2);
        BlockPos shaft1 = util.grid().at(2, 1, 2);
        BlockPos shaft2 = util.grid().at(3, 1, 2);
        BlockState handState = CreateHandCogwheel.HAND_COGWHEEL.get().defaultBlockState()
                .setValue(HandCrankBlock.FACING, Direction.WEST);
        BlockState shaftState = AllBlocks.SHAFT.get().defaultBlockState()
                .setValue(RotatedPillarKineticBlock.AXIS, Direction.Axis.X);

        scene.world().setBlock(handCogwheel, handState, false);
        scene.world().setBlock(shaft1, shaftState, false);
        scene.world().setBlock(shaft2, shaftState, false);
        scene.world().showSection(util.select().layer(1), Direction.DOWN);
        scene.idle(20);

        scene.overlay().showText(65)
                .text("The back of the Hand Cogwheel exposes a direct shaft connection")
                .pointAt(util.vector().blockSurface(handCogwheel, Direction.EAST))
                .placeNearTarget();
        scene.effects().indicateSuccess(shaft1);
        scene.idle(75);

        scene.world().setKineticSpeed(util.select().fromTo(handCogwheel, shaft2), 32);
        scene.effects().rotationDirectionIndicator(handCogwheel);
        scene.effects().rotationDirectionIndicator(shaft2);
        scene.overlay().showText(65)
                .text("Shafts on the same axis receive the generated speed without a gear ratio change")
                .pointAt(util.vector().centerOf(shaft1))
                .placeNearTarget()
                .attachKeyFrame();
        scene.idle(75);

        scene.overlay().showControls(util.vector().centerOf(shaft2), Pointing.DOWN, 35)
                .withItem(CreateHandCogwheel.HAND_COGWHEEL_ITEM.get().getDefaultInstance());
        scene.overlay().showText(70)
                .text("Looking at a Shaft end while holding the item shows a placement preview on that axis")
                .pointAt(util.vector().centerOf(shaft2))
                .placeNearTarget();
        scene.idle(80);

        scene.overlay().showControls(util.vector().centerOf(shaft2), Pointing.DOWN, 35)
                .withItem(CreateHandCogwheel.HAND_COGWHEEL_ITEM.get().getDefaultInstance())
                .whileSneaking();
        scene.overlay().showText(65)
                .text("Hold Sneak while placing to bypass the guide and use normal block placement")
                .pointAt(util.vector().centerOf(handCogwheel))
                .placeNearTarget()
                .attachKeyFrame();
        scene.idle(75);

        scene.overlay().showText(65)
                .text("The block can be oriented along X, Y, or Z and can also be waterlogged")
                .pointAt(util.vector().centerOf(handCogwheel))
                .placeNearTarget();
        scene.idle(75);
    }
}
