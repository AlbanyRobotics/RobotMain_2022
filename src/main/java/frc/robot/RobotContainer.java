// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.util.XboxControllerAxisButton;
import frc.robot.util.XboxPOVButton;
import oi.limelightvision.limelight.frc.LimeLight;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // _BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final BallSurvey m_ballSurvey = new BallSurvey();
    public final TurretCon m_turretCon = new TurretCon();
    public final ShootBall m_shootBall = new ShootBall();
    public final IntakeArm m_intakeArm = new IntakeArm();
    public final IntakeSpin m_intakeSpin = new IntakeSpin();
    public final DriveTrain m_driveTrain = new DriveTrain();

// Joysticks
private final XboxController xboxController1 = new XboxController(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public final LimeLight m_limeLight = new LimeLight();

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems
    SmartDashboard.putData(m_ballSurvey);
    SmartDashboard.putData(m_turretCon);
    SmartDashboard.putData(m_shootBall);
    SmartDashboard.putData(m_intakeArm);
    SmartDashboard.putData(m_intakeSpin);
    SmartDashboard.putData(m_driveTrain);


    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    SmartDashboard.putData("IntakeArmUpDown", new IntakeArmUp( m_intakeArm ));
    SmartDashboard.putData("IntakeSpinning", new IntakeSpinning( m_intakeSpin ));
    SmartDashboard.putData("SpinFlywheels", new SpinFlywheels(() ->.75, () -> .5, m_shootBall ));
    SmartDashboard.putData("Rotate Right", new RotateRight( m_turretCon ));
    SmartDashboard.putData("Rotate Left", new RotateLeft( m_turretCon ));
    SmartDashboard.putData("Survey", new Survey( m_ballSurvey ));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    SmartDashboard.putData("LimeLight Turt Tracking", new Turret_LimeLight_Cont(1, m_limeLight, m_turretCon));
    SmartDashboard.putNumber("Kp", 4.5);
    SmartDashboard.putNumber("Upper Percent", .75);
    SmartDashboard.putNumber("Lower Percent", .5);
    // Configure the button bindings

    configureButtonBindings();

    // Configure default commands
        // _BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    //m_driveTrain.setDefaultCommand(new DriveWithJoysticks(0, 0, m_driveTrain) );


    // _END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_driveTrain.setDefaultCommand (new DriveWithJoysticks (() -> -xboxController1.getRawAxis(1), () -> -xboxController1.getRawAxis(4), m_driveTrain ));
    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.setDefaultOption("Auto Basic Shoot and Drive", new Auto_basic_Shoot_Drive(m_shootBall, m_ballSurvey));
    m_chooser.addOption("name", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
//Do NOT TOUCH
    final XboxControllerAxisButton rightTrigger = new XboxControllerAxisButton(xboxController1, XboxController.Axis.kRightTrigger.value);        
rightTrigger.whileHeld(new SpinFlywheels(() -> SmartDashboard.getNumber("Upper Percent", .75), () -> SmartDashboard.getNumber("Lower Percent", .5), m_shootBall ) ,true);
    SmartDashboard.putData("rightTrigger",new SpinFlywheels(() -> SmartDashboard.getNumber("Upper Percent", .75), () -> SmartDashboard.getNumber("Lower Percent", .5), m_shootBall ) );
    
    final XboxControllerAxisButton leftTrigger = new XboxControllerAxisButton(xboxController1, XboxController.Axis.kLeftTrigger.value);        
leftTrigger.whileHeld(new IntakeSpinning( m_intakeSpin ) ,true);
        SmartDashboard.putData("leftTrigger",new IntakeSpinning( m_intakeSpin ) );
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
final XboxPOVButton DpadRight = new XboxPOVButton(xboxController1, XboxPOVButton.EAST);
DpadRight.whileHeld(new FlywheelReverse ( m_shootBall ) ,true);

final XboxPOVButton DpadUp = new XboxPOVButton(xboxController1, XboxPOVButton.NORTH);
DpadUp.whileHeld(new SurveyReverse ( m_ballSurvey ) ,true);

final JoystickButton xButton = new JoystickButton(xboxController1, XboxController.Button.kX.value);
xButton.whileHeld(new IntakeReverse ( m_intakeSpin ) ,true);

final JoystickButton bButton = new JoystickButton(xboxController1, XboxController.Button.kB.value);
bButton.whileHeld(new IntakeArmDown( m_intakeArm ) ,true);
    SmartDashboard.putData("bButton",new IntakeArmDown( m_intakeArm ) );

final JoystickButton rightBumper = new JoystickButton(xboxController1, XboxController.Button.kRightBumper.value);        
rightBumper.whileHeld(new Survey( m_ballSurvey ) ,true);
    SmartDashboard.putData("rightBumper",new Survey( m_ballSurvey ) );

final JoystickButton start = new JoystickButton(xboxController1, XboxController.Button.kStart.value);        
start.whileHeld(new RotateRight( m_turretCon ) ,true);
    SmartDashboard.putData("Start",new RotateRight( m_turretCon ) );

final JoystickButton back = new JoystickButton(xboxController1, XboxController.Button.kBack.value);        
back.whileHeld(new RotateLeft( m_turretCon ) ,true);
    SmartDashboard.putData("Back",new RotateLeft( m_turretCon ) );

final JoystickButton leftBumper = new JoystickButton(xboxController1, XboxController.Button.kLeftBumper.value);        
leftBumper.whileHeld(new IntakeArmUp( m_intakeArm ) ,true);
    SmartDashboard.putData("LeftBumper",new IntakeArmUp( m_intakeArm ) );



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public XboxController getXboxController1() {
      return xboxController1;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

