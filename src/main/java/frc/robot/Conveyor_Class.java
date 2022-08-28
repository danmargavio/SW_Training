package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.Timer;

public class Conveyor_Class {
  public Talon motor;
  public double volt_command = 0;
  public double time_ref, time_since;
  public int test_count = 1;
  public boolean test_running = false;

    /**
   * This is the Conveyor Class constructor which creates a commandable conveyor object instance.
   *
   * @param device_id This is used to indicate which device you want to create. Options are 1 or 2.
   */
  public Conveyor_Class(int device_id) {

    if (device_id == 1) {
      motor = new Talon(Constants.conveyor_1_port);     // constructs a new motor object using the ID in the constants file
      motor.setInverted(Constants.conveyor_1_direction); // set the motor polarity based on a value in the constants file
    }
    else if (device_id == 2) {
      motor = new Talon(Constants.conveyor_2_port);
      motor.setInverted(Constants.conveyor_2_direction);
    }
    else {
      System.out.println("ERROR! There is no such device id.");
    }
  }

    /**
   * This method commands a conveyor to move with a constant input voltage.
   *
   * @param voltage The input voltage normalized to between -1 and 1.
   */
  public void move_conveyor(double voltage) {
    volt_command = voltage;  // sets the command variable
    motor.set(volt_command);  // issues the command to the motor for whatever instance the method is called against
  }

    /**
   * This method performs a simple test of the conveyor. It will be driven forward for 3 seconds, then stopped for at least 2 seconds. The test will repeat based on the value in the test_count member variable. Use test_running member variable to see if the test is done or not.
   */
  public void test() {
    if ((test_count > 0) && (test_running == false)) {
      time_ref = Timer.getFPGATimestamp();
      test_count = test_count - 1;
      test_running = true;
      time_since = 0.0;
      System.out.println("Visually verify that this conveyor moves forward for 3 seconds then stops for 2 seconds.");
    }
    if ((test_running == true) && (time_since <= 3.0)) {
      motor.set(0.2);
    }
    if ((test_running == true) && (time_since > 3.0) && (time_since < 5.0)) {
      motor.set(0.0);
    }
    if ((test_running == true) && (time_since > 5.0)) {
      test_running = false;
    }
    time_since = Timer.getFPGATimestamp() - time_ref;
  }

}