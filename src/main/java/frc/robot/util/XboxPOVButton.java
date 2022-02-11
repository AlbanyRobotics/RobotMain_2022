/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;


/**
 * @author Ken Streeter (1519)
 */
public class XboxPOVButton extends Button {
    public static final int NORTH = 0;
    public static final int NORTHEAST = 45;
    public static final int EAST = 90;
    public static final int SOUTHEAST = 135;
    public static final int SOUTH = 180;
    public static final int SOUTHWEST = 225;
    public static final int WEST = 270;
    public static final int NORTHWEST = 315;

    private XboxController xboxController;
    private int desiredPOV;

    public XboxPOVButton(XboxController stick, int newDesiredPOV) {
    	xboxController = stick;
        desiredPOV = newDesiredPOV;
    }


	public boolean get() {
    	return (xboxController.getPOV() == desiredPOV);
    }
}
