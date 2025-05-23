package dev.miwycet;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public final class NoHurtCam implements ModInitializer {
    public static boolean enabled = true;
    public static KeyBinding enableKey;

    @Override
    public void onInitialize() {
        ConfigManager.loadConfig();
        KeyInput.register();

        enableKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Key:",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_F8,
                "[miwycet] NoHurtCam"
        ));
    }
}