package mods.cc.rock.core.helpers;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocalizationHelper
{

    public static boolean isXMLLanguageFile(String fileName)
    {
        return fileName.endsWith(".xml");
    }


    /***
     * Returns the locale from file name
     * 
     * @param fileName
     *            String representing the file name of the file in question
     * @return String representation of the locale snipped from the file name
     */
    public static String getLocaleFromFileName(String fileName)
    {
        return fileName.substring(fileName.lastIndexOf('/') + 1, fileName.lastIndexOf('.'));
    }


    public static String getLocalizedString(String key)
    {
        return LanguageRegistry.instance().getStringLocalization(key);
    }

}
