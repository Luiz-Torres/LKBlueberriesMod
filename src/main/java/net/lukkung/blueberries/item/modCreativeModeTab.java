package net.lukkung.blueberries.item;

import net.lukkung.blueberries.Blueberries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


@Mod.EventBusSubscriber(modid = Blueberries.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class modCreativeModeTab {
    public static CreativeModeTab LK_BLUEBERRIES_TAB;

    @SubscribeEvent
    public static void registerTabs(CreativeModeTabEvent.Register event)
    {
        LK_BLUEBERRIES_TAB = event.registerCreativeModeTab(new ResourceLocation(Blueberries.MOD_ID, "lk_blueberries"), builder -> builder
                .icon(() -> new ItemStack(modItems.BLUEBERRIES.get()))
                .title(Component.translatable("itemGroup." + Blueberries.MOD_ID + ".lk_blueberries"))
                .displayItems((featureFlags, output, hasPermissions) -> {
                    output.accept(new ItemStack(modItems.BLUEBERRIES.get()));
                    output.accept(modItems.BLUEBERRIES.get(), CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
                })
        );
    };
}
