package mods.cc.rock.core.handlers;


import mods.cc.rock.core.helpers.LocalizationHelper;
import mods.cc.rock.lib.Localizations;

import cpw.mods.fml.common.registry.LanguageRegistry;


public class LocalizationHandler
{

    public static void loadLanguages()
    {
        for (String localizationFile : Localizations.localeFiles)
        {
            LanguageRegistry.instance().loadLocalization(localizationFile, LocalizationHelper.getLocaleFromFileName(localizationFile), LocalizationHelper.isXMLLanguageFile(localizationFile));
        }
    }   
    
}
