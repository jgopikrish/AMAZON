package FREERECHARGE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.tango.DeviceState;
import org.tango.server.ServerManager;
import org.tango.server.annotation.Device;
import org.tango.server.annotation.Init;
import org.tango.server.annotation.State;
import org.tango.server.annotation.StateMachine;

/**
 * cardbill Tango-Controls server
 *
 * @author bill <card>
 * @since Tue Jul 27 09:25:49 IST 2021
 */
@Device
public class cardbill {
    private final Logger logger = LoggerFactory.getLogger(cardbill.class);
    private final XLogger xlogger = XLoggerFactory.getXLogger(cardbill.class);

    @State
    private volatile DeviceState state;

    public DeviceState getState() {
        return state;
    }

    public void setState(DeviceState state) {
        this.state = state;
    }

    @Init
    @StateMachine(endState = DeviceState.ON)
    public void init() throws Exception {
        xlogger.entry();

        setState(DeviceState.ON);

        xlogger.exit();
    }

    public static void main(String[] args) {
        ServerManager.getInstance().start(args, cardbill.class);
    }
}