/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frc.robot.util;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;


/**
 *
 * @author Noel
 */
public class XboxControllerAxisButton extends Button {
    public static final int BOTH_WAYS = 1;
    public static final int POSITIVE_ONLY = 2;
    public static final int NEGATIVE_ONLY = 3;
    
    private static final double AXIS_THRESHOLD = 0.2;
    
    private XboxController XboxController;
    private XboxController.Axis axis;
    private int axisInt;
    private int direction;
    
    public XboxControllerAxisButton(XboxController stick, XboxController.Axis axis) {
        this(stick, axis, BOTH_WAYS);
    }
    
    public XboxControllerAxisButton(XboxController stick, XboxController.Axis axis, int direction) {
        XboxController = stick;
        this.axis = axis;
        this.direction = direction;
    }
    
    public XboxControllerAxisButton(XboxController stick, int axis) {
        this(stick, axis, BOTH_WAYS);
    }
    
    public XboxControllerAxisButton(XboxController stick, int axis, int direction) {
        XboxController = stick;
        this.axis = null;
        axisInt = axis;
        this.direction = direction;
    }
    
    public boolean get() {
        switch (direction) {
            case BOTH_WAYS:
                    return Math.abs(XboxController.getRawAxis(axisInt)) > AXIS_THRESHOLD;
            
            case POSITIVE_ONLY:
                    return XboxController.getRawAxis(axisInt) > AXIS_THRESHOLD;
                
            case NEGATIVE_ONLY:
                    return XboxController.getRawAxis(axisInt) < -AXIS_THRESHOLD;
        }
        
        return false;
    }
}
