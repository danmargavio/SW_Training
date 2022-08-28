// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  // Class instance constructors
  private final Conveyor_Class conveyor_1 = new Conveyor_Class(1);
  private final Conveyor_Class conveyor_2 = new Conveyor_Class(2);
  private final Joystick driver_joystick = new Joystick(0);

  @Override
  public void robotInit() { 
    System.out.println("==========================");
    System.out.println("SW Training Program");
    System.out.println("Project: Test1");
    System.out.println("Version: v0.1");
    System.out.println("==========================");
  }

  @Override
  public void robotPeriodic() {
    // This just provides data to the SmartDashboard in case we want to see or plot it.
    SmartDashboard.putNumber("Conveyor 1 command", conveyor_1.volt_command);
    SmartDashboard.putNumber("Conveyor 2 command", conveyor_2.volt_command);
  }

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    // code below simply passes the driver joystick value to the conveyor move method
    conveyor_1.move_conveyor(driver_joystick.getRawAxis(Constants.left_stick_up_down));
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {
    conveyor_1.test_count = 2;
    conveyor_1.test_running = false;
  }

  @Override
  public void testPeriodic() {
    conveyor_1.test();
  }

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}