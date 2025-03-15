package Preferences;

import java.util.prefs.Preferences;

public class PreferencesLesson {
    private String name;
    private Integer volume;
    private Boolean isDarkMode;

    // Конструктор
    public PreferencesLesson(String name, Integer volume, Boolean isDarkMode) {
        this.name = name;
        this.volume = volume;
        this.isDarkMode = isDarkMode;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Boolean getDarkMode() {
        return isDarkMode;
    }

    public void setDarkMode(Boolean darkMode) {
        isDarkMode = darkMode;
    }


    public void savePreferences() {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesLesson.class); //HKEY_CURRENT_USER\Software\JavaSoft\Prefs
        prefs.put("name", name);
        prefs.putInt("volume", volume);
        prefs.putBoolean("isDarkMode", isDarkMode);
    }

    public void loadPreferences() {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesLesson.class);
        name = prefs.get("name", "DefaultName");
        volume = prefs.getInt("volume", 50);
        isDarkMode = prefs.getBoolean("isDarkMode", false);
    }

    @Override
    public String toString() {
        return "PreferencesLesson{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", isDarkMode=" + isDarkMode +
                '}';
    }
}