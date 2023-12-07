// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.MotorConstants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  CANSparkMax frontLeftMotor;
  CANSparkMax frontRightMotor;
  CANSparkMax backLeftMotor;
  CANSparkMax backRightMotor;

  MotorControllerGroup leftMotors;
  MotorControllerGroup rightMotors;

  XboxController controller;
  
  
  public DriveTrain() {
    frontLeftMotor = new CANSparkMax (MotorConstants.FRONT_LEFT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushed);
    frontRightMotor = new CANSparkMax (MotorConstants.FRONT_RIGHT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushed);
    backLeftMotor = new CANSparkMax (MotorConstants.BACK_LEFT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushed);
    backRightMotor = new CANSparkMax (MotorConstants.BACK_RIGHT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushed);

    leftMotors = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
    rightMotors = new MotorControllerGroup(frontRightMotor, backRightMotor);
  }

  public void drive (double leftSpeed, double rightSpeed) {
    leftMotors.set(leftSpeed);
    rightMotors.set(-rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    
  }
}
