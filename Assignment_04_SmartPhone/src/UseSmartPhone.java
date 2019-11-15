//This is the main Application
import java.util.ArrayList;
import java.util.List;

public class UseSmartPhone {

    public static void main(String[] args) {

        CookingDevices newDevice = SmartPhone.getDevice();  //returns all Devices linked to the SmartPhone

        SwitchOnOven onCommand = new SwitchOnOven(newDevice);

        DeviceButton onPressed = new DeviceButton(onCommand);

        onPressed.press();


    }


}
