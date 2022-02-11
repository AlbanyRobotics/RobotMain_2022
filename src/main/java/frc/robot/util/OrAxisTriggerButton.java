package frc.robot.util;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;


public class OrAxisTriggerButton extends Button {
	//Button Variables
	GenericHID joystick1;
    int buttonNumber1;
    
	//Axis Variables
	public static final int BOTH_WAYS = 1;
    public static final int POSITIVE_ONLY = 2;
    public static final int NEGATIVE_ONLY = 3;
    
    private static final double AXIS_THRESHOLD = 0.2;
    
    private Joystick joystick;
    private Joystick.AxisType axis;
    private int axisInt;
    private int direction;
    
    public OrAxisTriggerButton(GenericHID joystick1, int buttonNumber1, Joystick stick, Joystick.AxisType axis) {
    	this(joystick1, buttonNumber1,stick, axis, BOTH_WAYS);
    }
    
    public OrAxisTriggerButton(GenericHID joystick1, int buttonNumber1, Joystick stick, Joystick.AxisType axis, int direction) {
    	this.joystick1 = joystick1;
        this.buttonNumber1 = buttonNumber1;
    	joystick = stick;
        this.axis = axis;
        this.direction = direction;
    }
    
    public OrAxisTriggerButton(GenericHID joystick1, int buttonNumber1, Joystick stick, int axis) {
    	this(joystick1, buttonNumber1, stick, axis, BOTH_WAYS);
    }
    
    public OrAxisTriggerButton(GenericHID joystick1, int buttonNumber1, Joystick stick, int axis, int direction) {
    	this.joystick1 = joystick1;
        this.buttonNumber1 = buttonNumber1;
    	joystick = stick;
        this.axis = null;
        axisInt = axis;
        this.direction = direction;
    }
    
    public boolean get() {
    	
        switch (direction) {
            case BOTH_WAYS:

                    return joystick1.getRawButton(buttonNumber1) || Math.abs(joystick.getRawAxis(axisInt)) > AXIS_THRESHOLD;
                           
            case POSITIVE_ONLY:
                    return joystick1.getRawButton(buttonNumber1) || joystick.getRawAxis(axisInt) > AXIS_THRESHOLD;

                
            case NEGATIVE_ONLY:
                    return joystick1.getRawButton(buttonNumber1) || joystick.getRawAxis(axisInt) < -AXIS_THRESHOLD;
        }
        
        return false;
    }
}