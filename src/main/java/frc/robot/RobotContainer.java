// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import static edu.wpi.first.wpilibj.XboxController.Button;

// import frc.robot.Constants.LauncherConstants;
import frc.robot.commands.LaunchCargo;
import frc.robot.commands.LaunchCargoHigh;
import frc.robot.commands.StopLaunch;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Robot Subsystems 
  private final LauncherSubsystem m_launcherSubsystem = new LauncherSubsystem();
  // Robot Commands
  private final LaunchCargo m_autoCommand = new LaunchCargo(m_launcherSubsystem);

  
  // Driver Controller ID value (0) but probably set to (1) if using two controllers
  private final XboxController m_joystick = new XboxController(0); 
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
  
    // Configure the button bindings
    configureButtonBindings();

  }  

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
    private void configureButtonBindings() {

      //declaring buttons on controller
      
      final JoystickButton r1 = new JoystickButton(m_joystick, Button.kRightBumper.value);
      final JoystickButton l1 = new JoystickButton(m_joystick, Button.kLeftBumper.value);

      // Connect the buttons to commands
      // Launch the Cargo when either left bumper or right bumper is held
      // left bumper = low shot, right bumper = high shot
      /* We tried whileHeld command initially, but it only starts the motors, it does not stop the motors automatically
      upon button release as it should */
      //this is working to start falcon motors when button held
      l1.whenHeld(new LaunchCargo(m_launcherSubsystem));
      r1.whenHeld(new LaunchCargoHigh(m_launcherSubsystem));
      //added a when button released command until we have whileHeld working as it should
      l1.whenReleased(new StopLaunch(m_launcherSubsystem));
      r1.whenReleased(new StopLaunch(m_launcherSubsystem));


    /** Use this to pass the autonomous command to the main {@link Robot} class.
    * @return the command to run in autonomous
   */
  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    new LaunchCargo(m_launcherSubsystem);
    return m_autoCommand;
  }
}

