package frc.robot.util;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.button.Button;



/**
 *
 */
public class IOButtonOrButton extends Button {

	private DigitalInput button1;
	private DigitalInput button2;
	
	public IOButtonOrButton(DigitalInput digitalInput1,DigitalInput digitalInput2){
		button1 = digitalInput1;
		button2 = digitalInput2;
	}
	
	/**
	 * Returns True if switch is closed
	 */
    public boolean get() {
        return !button1.get()||!button2.get();
    }
}
