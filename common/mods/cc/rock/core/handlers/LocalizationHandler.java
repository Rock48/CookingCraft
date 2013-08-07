package mods.cc.rock.core.handlers;


import mods.cc.rock.core.util.LocalizationHelper;
import mods.cc.rock.core.util.LogUtil;
import mods.cc.rock.lib.Localizations;
import mods.cc.rock.lib.Messages;

import cpw.mods.fml.common.registry.LanguageRegistry;


public class LocalizationHandler
{

    public static void loadLanguages()
    {
        for (String localizationFile : Localizations.localeFiles)
            LanguageRegistry.instance().loadLocalization(localizationFile, LocalizationHelper.getLocaleFromFileName(localizationFile), LocalizationHelper.isXMLLanguageFile(localizationFile));
        
        LogUtil.info(Messages.MSG_LOCALIZATION_INITIALIZATION_SUCCESS);
    }   
    
}
