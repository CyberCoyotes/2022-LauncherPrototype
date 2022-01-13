// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LauncherConstants;

// Shuffleboard imports
// import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts; // Displaying data?
// import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard; // Displaying data?
// import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab; // Displaying data?

// CTRE imports
// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.NeutralMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
// import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;

public class LauncherSubsystem extends SubsystemBase {

  // Falcon 500 is controlled by TalonFX
  // These are the two motors for launching the cargo
  // This might need to go in the subsystem below

  private final MotorController m_LauncherMotors = 
    new MotorControllerGroup(
      new WPI_TalonFX(LauncherConstants.leftLaunchMotor), 
      new WPI_TalonFX(LauncherConstants.rightLaunchMotor));
    
    MotorController m_rightLaunchMotor; //Needed to setInverted

    public LauncherSubsystem() {
     m_rightLaunchMotor.setInverted(true);

  }

  /** Launches the Cargo with speed set for low hub
    *  Eventually the absolute value could be replaced with sensor-driven values
    **/
  public void launchCargo() {
    double cargoSpeed = 0.25;
    m_LauncherMotors.set(cargoSpeed);
  }

  // Speed to launch the Cargo for High Hub
    // Eventually the absolute value could be replaced with sensor-driven values

  public void launchCargoHigh() {
    double cargoSpeed = 0.50;
    m_LauncherMotors.set(cargoSpeed);
  }

  // Shaun or Jackson: Create an action to "releaseCargo" if needed by the drive team

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
