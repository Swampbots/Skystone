package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.opencv.core.MatOfPoint;

import java.util.List;

import static org.firstinspires.ftc.teamcode.SkystonePlacement.CENTER;

@Autonomous(name = "Blue Foundation", group = "Autonomous")
public class AutoBlueFoundation extends LinearOpMode {

    // Hardware
    SlippyBotHardware hardware = new SlippyBotHardware();

    // Hardware class initialization variables
    private final boolean INIT_CAMERA   = false;
    private final boolean INIT_IMU      = true;

    // Drive motor speeds
    private final double DRIVE_SPEED    = 0.5;
    private final double STRAFE_SPEED   = 0.5;

    // Variables for sleeping at start
    private final boolean SLEEP_AT_START    = false;
    private final int SLEEP_TIME_MILLIS     = 10000;    // 10,000 milliseconds = 10.0 seconds. May not finish if above 17 seconds.



    public void runOpMode() {

        hardware.init(hardwareMap, INIT_CAMERA, INIT_IMU);

        telemetry.addLine("Ready");
        telemetry.update();

        waitForStart();

        // Optional pause at start for compliance with alliance partner strategy
        if(SLEEP_AT_START) sleep(SLEEP_TIME_MILLIS);

        // Step 1: drive to Foundation


        // Step 2: grab Foundation


        // Step 3: pull Foundation into Building Site


        // Step 4: release Foundation


        // Step 5: park under Skybridge


        while(opModeIsActive()) {
            telemetry.addLine("Running");
            telemetry.update();
        }
    }





    // Encoder-controlled movement
    private void driveInches(double inches) {
        driveInches(inches, DRIVE_SPEED);   // Defaults to local field member speed
    }
    private void driveInches(double inches, double speed) {
        driveEncoderCounts((int)(inches * hardware.COUNTS_PER_INCH_EMPIRICAL), speed);
    }

    private void driveEncoderCounts(int counts, double speed) {
        hardware.frontLeft.setTargetPosition    (hardware.frontLeft.getCurrentPosition()    + counts);
        hardware.frontRight.setTargetPosition   (hardware.frontRight.getCurrentPosition()   + counts);
        hardware.rearLeft.setTargetPosition     (hardware.rearLeft.getCurrentPosition()     + counts);
        hardware.rearRight.setTargetPosition    (hardware.rearRight.getCurrentPosition()    + counts);

        hardware.frontLeft.setMode  (DcMotor.RunMode.RUN_TO_POSITION);
        hardware.frontRight.setMode (DcMotor.RunMode.RUN_TO_POSITION);
        hardware.rearLeft.setMode   (DcMotor.RunMode.RUN_TO_POSITION);
        hardware.rearRight.setMode  (DcMotor.RunMode.RUN_TO_POSITION);

        hardware.setLeftPower(speed);
        hardware.setRightPower(speed);

        while(opModeIsActive() &&
                hardware.frontLeft.isBusy() &&
                hardware.frontRight.isBusy() &&
                hardware.rearLeft.isBusy() &&
                hardware.rearRight.isBusy()) {
            telemetry.addData("Front left encoder",     hardware.frontLeft.getCurrentPosition());
            telemetry.addData("Front right encoder",    hardware.frontRight.getCurrentPosition());
            telemetry.addData("Rear left encoder",      hardware.rearLeft.getCurrentPosition());
            telemetry.addData("Rear right encoder",     hardware.rearRight.getCurrentPosition());
            telemetry.update();
        }

        hardware.setLeftPower(0.0);
        hardware.setRightPower(0.0);

        hardware.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        hardware.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        hardware.rearLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        hardware.rearRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    private void strafeEncoderCounts(int counts, double speed) {
        hardware.frontLeft.setTargetPosition    (hardware.frontLeft.getCurrentPosition()    + counts);
        hardware.frontRight.setTargetPosition   (hardware.frontRight.getCurrentPosition()   - counts);
        hardware.rearLeft.setTargetPosition     (hardware.rearLeft.getCurrentPosition()     - counts);
        hardware.rearRight.setTargetPosition    (hardware.rearRight.getCurrentPosition()    + counts);

        hardware.frontLeft.setMode  (DcMotor.RunMode.RUN_TO_POSITION);
        hardware.frontRight.setMode (DcMotor.RunMode.RUN_TO_POSITION);
        hardware.rearLeft.setMode   (DcMotor.RunMode.RUN_TO_POSITION);
        hardware.rearRight.setMode  (DcMotor.RunMode.RUN_TO_POSITION);

        hardware.setLeftPower(speed);
        hardware.setRightPower(speed);

        while(opModeIsActive() &&
                hardware.frontLeft.isBusy() &&
                hardware.frontRight.isBusy() &&
                hardware.rearLeft.isBusy() &&
                hardware.rearRight.isBusy()) {
            telemetry.addData("Front left encoder",     hardware.frontLeft.getCurrentPosition());
            telemetry.addData("Front right encoder",    hardware.frontRight.getCurrentPosition());
            telemetry.addData("Rear left encoder",      hardware.rearLeft.getCurrentPosition());
            telemetry.addData("Rear right encoder",     hardware.rearRight.getCurrentPosition());
            telemetry.update();
        }

        hardware.setLeftPower(0.0);
        hardware.setRightPower(0.0);

        hardware.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        hardware.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        hardware.rearLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        hardware.rearRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
