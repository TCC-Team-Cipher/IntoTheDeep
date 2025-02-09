package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.back_arm.BackArmCommand;
import org.firstinspires.ftc.teamcode.back_arm.BackArmSubsystem;
import org.firstinspires.ftc.teamcode.drive.DriveCommand;
import org.firstinspires.ftc.teamcode.drive.DriveSubsystem;
import org.firstinspires.ftc.teamcode.front_arm.FrontArmCommand;
import org.firstinspires.ftc.teamcode.front_arm.FrontArmSubsystem;

@TeleOp(name = "Driver Controlled", group = "Into the Deep")
public class DriverControlled extends CommandOpMode {
    @Override
    public void initialize() {
        GamepadEx driveGamepad = new GamepadEx(gamepad1);
        GamepadEx armGamepad = new GamepadEx(gamepad2);

        DriveSubsystem driveSubsystem = new DriveSubsystem(hardwareMap);
        DriveCommand driveCommand = new DriveCommand(driveSubsystem, driveGamepad);
        driveSubsystem.setDefaultCommand(driveCommand);
        driveCommand.schedule();

        FrontArmSubsystem frontArmSubsystem = new FrontArmSubsystem(hardwareMap);
        FrontArmCommand frontArmCommand = new FrontArmCommand(frontArmSubsystem, armGamepad);
        frontArmSubsystem.setDefaultCommand(frontArmCommand);
        frontArmCommand.schedule();

        BackArmSubsystem backArmSubsystem = new BackArmSubsystem(hardwareMap);
        BackArmCommand backArmCommand = new BackArmCommand(backArmSubsystem, armGamepad);
        backArmSubsystem.setDefaultCommand(backArmCommand);
        backArmCommand.schedule();

//        IntakeSubsystem intakeSubsystem = new IntakeSubsystem(hardwareMap);
//        armGamepad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN)
//                .whenPressed(new InstantCommand(intakeSubsystem::down, intakeSubsystem));
//        armGamepad.getGamepadButton(GamepadKeys.Button.DPAD_UP)
//                .whenPressed(new InstantCommand(intakeSubsystem::up, intakeSubsystem));

        register(driveSubsystem, frontArmSubsystem);
    }
}
