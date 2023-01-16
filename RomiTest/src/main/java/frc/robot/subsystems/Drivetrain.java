// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.sensors.RomiGyro;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private static final double kCountsPerRevolution = 1440.0;
  private static final double kWheelDiameterInch = 2.75591; // 70 mm

  //*****The Romi has the left and right motors set to PWM channels 0 and 1 respectively*****
  private final Spark leftMotor = new Spark(0);
  private final Spark rightMotor = new Spark(1);

  //*****The Romi has onboard encoders that are hardcoded to use DIO pins 4/5 and 6/7 for the left and right*****
  private final Encoder leftEncoder = new Encoder(4, 5);
  private final Encoder rightEncoder = new Encoder(6, 7);

  //*****Set up the differential drive controller*****
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotor, rightMotor);

  //*****Built in components*****
  private final RomiGyro gyro = new RomiGyro();
  private final BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();

  //*****Constructor*****
  public Drivetrain()
  {
    rightMotor.setInverted(true);
    diffDrive.setDeadband(Constants.DriveTrain.DEADBAND);

    //*****Use inches as unit for encoder distances*****
    leftEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
    rightEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
    resetEncoders();
  }

  public void arcadeDrive(double xaxisSpeed, double zaxisRotate)
  {
    diffDrive.arcadeDrive(xaxisSpeed, zaxisRotate);
  }

  public void tankDrive(double leftSpeed, double rightSpeed)
  {
    diffDrive.tankDrive(leftSpeed, rightSpeed, Constants.DriveTrain.SQUARE_INPUTS);
  }

  public void resetEncoders()
  {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public int getLeftEncoderCount()
  {
    return leftEncoder.get();
  }

  public int getRightEncoderCount()
  {
    return rightEncoder.get();
  }

  public double getLeftDistanceInch()
  {
    return leftEncoder.getDistance();
  }

  public double getRightDistanceInch()
  {
    return rightEncoder.getDistance();
  }

  public double getAverageDistanceInch()
  {
    return (getLeftDistanceInch() + getRightDistanceInch()) / 2.0;
  }

  //*****The acceleration in the X-axis. @return The acceleration of the Romi along the X-axis in Gs*****
  public double getAccelX()
  {
    return accelerometer.getX();
  }

  //*****The acceleration in the Y-axis. @return The acceleration of the Romi along the Y-axis in Gs*****
  public double getAccelY()
  {
    return accelerometer.getY();
  }

  //*****The acceleration in the Z-axis. @return The acceleration of the Romi along the Z-axis in Gs*****
  public double getAccelZ()
  {
    return accelerometer.getZ();
  }

  //*****Current angle of the Romi around the X-axis. @return The current angle of the Romi in degrees*****
  public double getGyroAngleX()
  {
    return gyro.getAngleX();
  }

  //*****Current angle of the Romi around the Y-axis. @return The current angle of the Romi in degrees*****
  public double getGyroAngleY()
  {
    return gyro.getAngleY();
  }

  //*****Current angle of the Romi around the Z-axis. @return The current angle of the Romi in degrees*****
  public double getGyroAngleZ()
  {
    return gyro.getAngleZ();
  }

  //*****Reset the gyro*****
  public void resetGyro()
  {
    gyro.reset();
  }

  @Override
  public void periodic()
  {
    // This method will be called once per scheduler run
  }
}
