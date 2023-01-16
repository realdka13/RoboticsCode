// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain_SUB extends SubsystemBase {
  private Talon lefTalon;
  private Talon rightTalon;

  private DifferentialDrive driveTrain;
  
  //Constructor
  public DriveTrain_SUB()
  {
    lefTalon = new Talon(Constants.DriveTrain.LEFT_TALON);
    rightTalon = new Talon(Constants.DriveTrain.RIGHT_TALON);

    //Invert left motor
    lefTalon.setInverted(true);

    driveTrain = new DifferentialDrive(lefTalon, rightTalon);
  }

  //Drive with Square Inputs
  public void Drive(double leftSpeed, double rightSpeed)
  {
    //driveTrain.tankDrive(leftSpeed, rightSpeed, Constants.DriveTrain.SQUARE_INPUTS);
    System.out.println("Drive Called");
    driveTrain.tankDrive(leftSpeed, rightSpeed);
  }

  // This method will be called once per scheduler run
  @Override
  public void periodic(){}
}