package mods.cc.rock.client.audio;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

import mods.cc.rock.core.util.LogUtil;
import mods.cc.rock.lib.Messages;
import mods.cc.rock.lib.Sounds;

public class SoundHandler
{
    @ForgeSubscribe
    public void onSoundLoad(SoundLoadEvent event)
    {
        
        // For each custom sound file we have defined in Sounds
        for (String soundFile : Sounds.soundFiles)
        {
            // Add the custom sound file to the pool of sounds
            try
            {
                event.manager.addSound(soundFile);
            }
            catch (Exception e)
            {
                LogUtil.warning(Messages.MSG_SOUNDS_FAILED + soundFile);
            }
        }
        
        LogUtil.info(Messages.MSG_SOUNDS_LOADED);
    }
}
