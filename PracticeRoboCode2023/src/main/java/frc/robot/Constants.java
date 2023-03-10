// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{
    public static final class DriveTrainConst
    {
        public static final int LEFT_TALON = 0;
        public static final int RIGHT_TALON = 1;

        public static final boolean SQUARE_INPUTS = false;
        public static final float DEADBAND = 0.02f;
    }

    public static final class ManipulatorConst
    {
        public static final int ELEVATOR_JAGUAR = 2;
        public static final int CLAW_FORWARD = 0;
        public static final int CLAW_REVERSE = 1;
    }
}