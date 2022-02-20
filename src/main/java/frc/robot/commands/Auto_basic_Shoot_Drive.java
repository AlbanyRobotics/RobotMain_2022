// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.BallSurvey;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ShootBall;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Auto_basic_Shoot_Drive extends SequentialCommandGroup {
  /** Creates a new Auto_basic_Shoot_Drive. */
  public Auto_basic_Shoot_Drive(ShootBall shootBall, BallSurvey ballsurvey, DriveTrain driveTrain) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
                parallel(new SpinFlywheels(() -> .18, () -> .61, shootBall).withTimeout(5),
                          sequence(new WaitCommand(2),
                                    new Survey(ballsurvey).withTimeout(5)
                                  )
                
                        ), 
                new Drive_For_Distance(48, () -> -0.5 , () -> 0.0, driveTrain),
                new Drive_For_Distance(12, () -> 0.5 , () -> 0.0, driveTrain)
    );
  }
}
