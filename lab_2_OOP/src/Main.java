import IniParser.ConfigMap;
import IniParser.IniConfigException;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            ConfigMap configMap = ConfigMap.fromFile(new File("resources/config.ini"));
            int ivalue = configMap.getIntegerValue("NCMD", "TidPacketVersionForTidControlCommand");
            System.out.println(ivalue);

            double dvalue = configMap.getDoubleValue("ADC_DEV", "SampleRate");
            System.out.println(dvalue);

//            raise wrong parameter exception
//            int value = configMap.getIntegerValue("NCMD", "EnableChannelControl!!!");
//            System.out.println(value);

            // raise no section exception
            int value = configMap.getIntegerValue("NCMD!!!", "EnableChannelControl");
            System.out.println(value);

        } catch (IOException e) {
            System.out.println("Config file is empty or not found");
        } catch (IniConfigException e) {
            System.out.println(e.getMessage());
        }
    }
}
