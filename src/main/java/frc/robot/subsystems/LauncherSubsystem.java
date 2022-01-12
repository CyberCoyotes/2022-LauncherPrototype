// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts; // Displaying data?
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard; // Displaying data?
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab; // Displaying data?

import com.ctre.phoenix.motorcontrol.ControlMode; // Added for Talons
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX; // Added for Talons


import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LauncherSubsystem extends SubsystemBase {

  // Falcon 500 is controlled by TalonFX
  // These are the two motors ? for launching the cargo
  public final WPI_TalonFX leftTalon = new WPI_TalonFX(1);
  public final WPI_TalonFX rightTalon = new WPI_TalonFX(2);
  
  /** Creates a new Subsystem. */
  public LauncherSubsystem() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
