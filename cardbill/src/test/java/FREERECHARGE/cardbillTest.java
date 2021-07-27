package FREERECHARGE;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import FREERECHARGE.cardbill;
import org.junit.Test;
import org.tango.DeviceState;

public class cardbillTest {

    @Test
    public void testInit() throws Exception {
        cardbill instance = new cardbill();

        instance.init();

        assertThat(instance.getState(), is(DeviceState.ON));
    }
}