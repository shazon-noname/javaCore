package src.Preferences;

import java.util.prefs.Preferences;

public class Main {
    public static void main(String[] args) {
        PreferencesLesson lesson = new PreferencesLesson("MyApp", 75, true);

        //save settings
        lesson.savePreferences();
        System.out.println("settings saved: " + lesson);

        //load settings
        PreferencesLesson newLesson = new PreferencesLesson(null, null, null);
        newLesson.loadPreferences();
        System.out.println("settings loaded: " + newLesson);



        Preferences preferences = Preferences.userRoot().node("myApp");
        preferences.put("username", "User123");
        preferences.putInt("volume", 75);
        preferences.putBoolean("isDarkMode", true);

        String username =  preferences.get("username", "defaultUser");
        int volume =  preferences.getInt("volume", 50);
        boolean isDarkMode =  preferences.getBoolean("isDarkMode", false);

        System.out.println(username);
        System.out.println(volume);
        System.out.println(isDarkMode);

    }
}
