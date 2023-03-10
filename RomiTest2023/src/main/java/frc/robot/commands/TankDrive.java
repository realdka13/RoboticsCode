// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {
  private Drivetrain driveTrain;
  private Supplier<Double> leftSpeedSupplier;
  private Supplier<Double> rightSpeedSupplier;


  /** Creates a new TankDrive. */
  public TankDrive(Drivetrain drivetrain, Supplier<Double> leftSpeedSupplier, Supplier<Double> rightSpeedSupplier)
  {
    this.driveTrain = drivetrain;
    this.leftSpeedSupplier = leftSpeedSupplier;
    this.rightSpeedSupplier = rightSpeedSupplier;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute()
  {
    driveTrain.tankDrive(leftSpeedSupplier.get(), rightSpeedSupplier.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    return false;
  }
}
