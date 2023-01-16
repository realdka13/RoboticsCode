// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.motorcontrol.Jaguar;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Manipulator extends SubsystemBase {
  
  //******Manipulator Components*****
  private final Jaguar elevatorJaguar = new Jaguar(Constants.ManipulatorConst.ELEVATOR_JAGUAR);

  private final DoubleSolenoid claw = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.ManipulatorConst.CLAW_FORWARD, Constants.ManipulatorConst.CLAW_REVERSE);

  /*The Compressor object is only needed if you want the ability to turn off the
  compressor, change the pressure sensor (PH only), or query compressor status. */
  //*********************************

  /** Creates a new Manipulator. */
  public Manipulator()
  {}

  public void ElevatorUp()
  {
    elevatorJaguar.set(.5f);
  }

  public void ElevatorDown()
  {
    elevatorJaguar.set(-0.5f);
  }

  public void ElevatorStop()
  {
    elevatorJaguar.stopMotor();
  }

  public void OpenClaw()
  {
    claw.set(Value.kReverse);
  }

  public void CloseClaw()
  {
    claw.set(Value.kForward);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
