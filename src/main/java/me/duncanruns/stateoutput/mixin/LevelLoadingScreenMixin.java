package me.duncanruns.stateoutput.mixin;

import me.duncanruns.stateoutput.StateOutputHelper;
import net.minecraft.client.gui.WorldGenerationProgressTracker;
import net.minecraft.client.gui.screen.LevelLoadingScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelLoadingScreen.class)
public abstract class LevelLoadingScreenMixin {
    @Inject(method = "<init>", at = @At(value = "TAIL"))
    public void worldpreview_init(WorldGenerationProgressTracker progressProvider, CallbackInfo ci) {
        StateOutputHelper.loadingProgress = 0;
        StateOutputHelper.outputState("generating,0");
    }
}
