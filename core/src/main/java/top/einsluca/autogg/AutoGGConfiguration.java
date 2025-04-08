package top.einsluca.autogg;

import net.labymod.api.Laby;
import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.ButtonWidget;
import net.labymod.api.client.gui.screen.widget.widgets.input.SliderWidget;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget;
import net.labymod.api.client.gui.screen.widget.widgets.input.TextFieldWidget;
import net.labymod.api.configuration.loader.annotation.ConfigName;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingSection;
import net.labymod.api.util.MethodOrder;

@ConfigName("settings")
public class AutoGGConfiguration extends AddonConfig {
    @SwitchWidget.SwitchSetting
    private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

    @SwitchWidget.SwitchSetting
    private final ConfigProperty<Boolean> custom = new ConfigProperty<>(true);

    @SwitchWidget.SwitchSetting
    private final ConfigProperty<Boolean> defaults = new ConfigProperty<>(true);

    @TextFieldWidget.TextFieldSetting
    public final ConfigProperty<String> message = new ConfigProperty<>("gg");

    @SliderWidget.SliderSetting(min = 0.1F, max = 10F, steps = 0.0F)
    public final ConfigProperty<Double> delay = new ConfigProperty<>(1.0);

    @SettingSection("help")
    @ButtonWidget.ButtonSetting
    @MethodOrder(after = "delay")
    public void openServerList() {
        Laby.labyAPI().minecraft().chatExecutor().openUrl("https://github.com/EinsLucaaa/AutoGG/wiki/Supported-server");
    }

    @Override
    public ConfigProperty<Boolean> enabled() {
        return this.enabled;
    }

    public ConfigProperty<Boolean> getCustom() {
        return custom;
    }

    public ConfigProperty<Boolean> getDefaults() {
        return defaults;
    }

}
