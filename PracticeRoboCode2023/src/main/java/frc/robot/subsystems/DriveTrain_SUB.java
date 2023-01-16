// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain_SUB extends SubsystemBase {

  //*****Drive Train Componenets*****
  private Talon lefTalon = new Talon(Constants.DriveTrainConst.LEFT_TALON);
  private Talon rightTalon = new Talon(Constants.DriveTrainConst.RIGHT_TALON);

  private DifferentialDrive driveTrain = new DifferentialDrive(lefTalon, rightTalon);;
  //*********************************

  //Constructor
  public DriveTrain_SUB()
  {
    //Invert left motor
    lefTalon.setInverted(true);

    //Set Deadband
    driveTrain.setDeadband(Constants.DriveTrainConst.DEADBAND);
  }

  //Drive with Square Inputs
  public void Drive(double leftSpeed, double rightSpeed)
  {
    System.out.println("Drive Called");
    driveTrain.tankDrive(leftSpeed, rightSpeed, Constants.DriveTrainConst.SQUARE_INPUTS);
  }

  // This method will be called once per scheduler run
  @Override
  public void periodic(){}
}