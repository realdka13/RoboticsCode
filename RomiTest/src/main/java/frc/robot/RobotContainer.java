// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.ArcadeDrive;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

//*****Extra Libraries*****
//import edu.wpi.first.wpilibj2.command.PrintCommand;
//import edu.wpi.first.wpilibj2.command.button.Button;
//import frc.robot.subsystems.OnBoardIO;
//import frc.robot.subsystems.OnBoardIO.ChannelMode;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
  //*****Robot Subsystems*****
  private final Drivetrain driveTrain = new Drivetrain();
  //private final OnBoardIO m_onboardIO = new OnBoardIO(ChannelMode.INPUT, ChannelMode.INPUT);

  //*****Controllers*****
  private final Joystick joystick = new Joystick(0);

  //*****SmartDashboard chooser for autonomous routines*****
  private final SendableChooser<Command> autoChooser = new SendableChooser<>();

  //***** The container for the robot. Contains subsystems, OI devices, and commands*****
  public RobotContainer()
  {
  //*****Configure the button bindings*****
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
    //*****Default command is arcade drive. This will run unless another command is scheduled over it.*****
    driveTrain.setDefaultCommand(new ArcadeDrive(driveTrain, () -> -joystick.getRawAxis(1), () -> joystick.getRawAxis(0)));

    //*****Example of how to use the onboard IO*****
    //Button onboardButtonA = new Button(m_onboardIO::getButtonAPressed);
    //onboardButtonA.whenActive(new PrintCommand("Button A Pressed"));
    //onboardButtonA.whenInactive(new PrintCommand("Button A Released"));

    //*****Setup SmartDashboard options*****
    SmartDashboard.putData(autoChooser);
  }

  //*****Use this to pass the autonomous command to the main {@link Robot} class. @return the command to run in autonomous*****
  public Command getAutonomousCommand()
  {
    return autoChooser.getSelected();
  }
}
