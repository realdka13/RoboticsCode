// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.TankDrive_CMD;
import frc.robot.subsystems.DriveTrain_SUB;
import frc.robot.subsystems.Manipulator;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
   //*******Controllers*******
  private final Joystick leftJoystick = new Joystick(0);
  private final Joystick rightJoystick = new Joystick(1);
  //**************************

   //*****Robot Subsystems*****
  private final DriveTrain_SUB driveTrain = new DriveTrain_SUB();
  private final Manipulator manipulator = new Manipulator();
  //**************************


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer()
  {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings()
  {
    //Drive Controls
    driveTrain.setDefaultCommand(new TankDrive_CMD(driveTrain, () -> leftJoystick.getY(), () -> rightJoystick.getY()));
    
    //Manipulator Controls
    //rightJoystick.getRawButton(3)
    //rightJoystick.getRawButton(2)

    //rightJoystick.getRawButton(4)
    //rightJoystick.getRawButton(5)
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
  //  return m_autoCommand;
  //}
}
