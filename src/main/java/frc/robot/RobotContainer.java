// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AutoAlignCommand;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Mechanism;
import frc.robot.subsystems.LimelightUpgrade;
import frc.robot.subsystems.Pneumatics;
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
LimelightUpgrade m_limelight = new LimelightUpgrade();
Drivetrain m_drivetrain = new Drivetrain();
Mechanism m_Mechanism = new Mechanism();
Pneumatics m_Pneuatics = new Pneumatics();
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */

  private void configureBindings() {
    
     double sensitivity = 0.5;
     double pLength = 0.75;//how long to fire
    m_drivetrain.setDefaultCommand(
      new RunCommand(
          () -> m_drivetrain.arcadeDrive(
                  MathUtil.applyDeadband(-m_driverController.getLeftY(), 0.3) * sensitivity,
                  MathUtil.applyDeadband(-m_driverController.getRightX(), 0.3) * sensitivity),
          m_drivetrain));

           m_driverController
            .a()
            .whileTrue(new AutoAlignCommand(m_drivetrain, m_limelight));

            m_driverController.leftBumper().whileTrue(new AutoAlignCommand(m_drivetrain, m_limelight).alongWith(m_Mechanism.ArmExtend(0.2))).onFalse(m_Mechanism.ArmStop()); // Auto-align while extending arm slowly
            m_driverController.povRight().whileTrue(m_Mechanism.ArmExtend(0.3)).whileFalse(m_Mechanism.ArmStop());
            m_driverController.rightTrigger().whileTrue(m_Pneuatics.SolenoidFire(pLength)).whileFalse(m_Pneuatics.SolenoidIdle());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
