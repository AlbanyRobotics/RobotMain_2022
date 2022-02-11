package frc.robot.util;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.button.Button;


/**
 *
 */
public class IOButton extends Button {

	private DigitalInput button;
	
	
	public IOButton(DigitalInput digitalInput){
		button = digitalInput;
	
	}
	
	/**
	 * Returns the status of a Normaly Open Switch connected to the RoboRio
	 */
    public boolean get() {
        return !button.get();
    }
}
