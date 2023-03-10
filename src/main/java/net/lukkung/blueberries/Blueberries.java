package net.lukkung.blueberries;

import com.mojang.logging.LogUtils;
import net.lukkung.blueberries.item.modItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.lukkung.blueberries.item.modCreativeModeTab;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(net.lukkung.blueberries.Blueberries.MOD_ID)
public class Blueberries
{
    public static final String MOD_ID = "blueberries";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public Blueberries()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modItems.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);


    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        /*
         Some common setup code
         LOGGER.info("HELLO FROM COMMON SETUP");
         LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
        */
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == modCreativeModeTab.LK_BLUEBERRIES_TAB)
            event.accept(modItems.BLUEBERRIES);
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            /*
             Some client setup code
             LOGGER.info("HELLO FROM CLIENT SETUP");
             LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            */
        }
    }
}
