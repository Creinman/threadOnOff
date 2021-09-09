import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class Switch {
    OnOff onoff = new OnOff();

    //public static boolean tumbler = false;

    public void user() {
        onoff.switchOn();
    }

    public void toy() {
        onoff.switchOff();
    }
}