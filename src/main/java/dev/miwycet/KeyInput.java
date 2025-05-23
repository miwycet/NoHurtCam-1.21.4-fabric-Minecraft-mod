package dev.miwycet;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class KeyInput {
    private static boolean keyPressed = false;

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            boolean isPressed = NoHurtCam.enableKey.isPressed();

            if (isPressed && !keyPressed) {
                NoHurtCam.enabled = !NoHurtCam.enabled;
                ConfigManager.saveConfig();
                String status = NoHurtCam.enabled ? "enabled" : "disabled";
                if (client.player != null) {
                    client.inGameHud.getChatHud().addMessage(
                            Text.literal(Formatting.BOLD + "[NoHurtCam] -> " + (NoHurtCam.enabled ? Formatting.GREEN : Formatting.RED) + status));
                }
            }
            keyPressed = isPressed;
        });
    }
}