package frc.robot.util;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Button;


public class OrJoystickButton extends Button {
	GenericHID joystick1;
    GenericHID joystick2;
    int buttonNumber1;
    int buttonNumber2;

    public OrJoystickButton(GenericHID joystick1, int buttonNumber1, GenericHID joystick2, int buttonNumber2) {
        this.joystick1 = joystick1;
        this.buttonNumber1 = buttonNumber1;
        this.joystick2 = joystick2;
        this.buttonNumber2 = buttonNumber2;
    }

    public boolean get() {
        return joystick1.getRawButton(buttonNumber1) || joystick2.getRawButton(buttonNumber2);
    }

}
