package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;
import org.openftc.easyopencv.OpenCvPipeline;

import java.util.ArrayList;
import java.util.List;

@Autonomous
public class TestCropCamera extends LinearOpMode {

    OpenCvCamera phoneCam;
    StageSwitchingPipeline stageSwitchingPipeline;

    public void runOpMode() {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        phoneCam = new OpenCvInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);
        phoneCam.openCameraDevice();
        stageSwitchingPipeline = new StageSwitchingPipeline();
        phoneCam.setPipeline(stageSwitchingPipeline);
        phoneCam.startStreaming(640, 480, OpenCvCameraRotation.UPRIGHT);

        waitForStart();

        while(opModeIsActive()) {
//            telemetry.addData("Num contours found", stageSwitchingPipeline.getNumContoursFound());
//            telemetry.update();
//            sleep(100);
        }



    }

    static class StageSwitchingPipeline extends OpenCvPipeline {
//        Mat yCbCrChan2Mat = new Mat();
//        Mat thresholdMat = new Mat();
//        Mat contoursOnFrameMat = new Mat();
//        List<MatOfPoint> contoursList = new ArrayList<>();
//        int numContoursFound;
//
//        enum Stage {
//            YCbCr_CHAN2,
//            THRESHOLD,
//            CONTOURS_OVERLAYED_ON_FRAME,
//            RAW_IMAGE,
//        }
//
//        private PipelineStageSwitchingExample.StageSwitchingPipeline.Stage stageToRenderToViewport = PipelineStageSwitchingExample.StageSwitchingPipeline.Stage.RAW_IMAGE;
//        private PipelineStageSwitchingExample.StageSwitchingPipeline.Stage[] stages = PipelineStageSwitchingExample.StageSwitchingPipeline.Stage.values();

//        @Override
//        public void onViewportTapped() {
//            /*
//             * Note that this method is invoked from the UI thread
//             * so whatever we do here, we must do quickly.
//             */
//
////            int currentStageNum = stageToRenderToViewport.ordinal();
////
////            int nextStageNum = currentStageNum + 1;
////
////            if (nextStageNum >= stages.length) {
////                nextStageNum = 0;
////            }
////
////            stageToRenderToViewport = stages[nextStageNum];
//        }

        @Override
        public Mat processFrame(Mat input) {
//            contoursList.clear();
//
//            /*
//             * This pipeline finds the contours of yellow blobs such as the Gold Mineral
//             * from the Rover Ruckus game.
//             */
////            Imgproc.cvtColor(input, yCbCrChan2Mat, Imgproc.COLOR_RGB2YCrCb);
////            Core.extractChannel(yCbCrChan2Mat, yCbCrChan2Mat, 2);
////            Imgproc.threshold(yCbCrChan2Mat, thresholdMat, 102, 255, Imgproc.THRESH_BINARY_INV);
////            Imgproc.findContours(thresholdMat, contoursList, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
////            numContoursFound = contoursList.size();
////            input.copyTo(contoursOnFrameMat);
////            Imgproc.drawContours(contoursOnFrameMat, contoursList, -1, new Scalar(0, 0, 255), 3, 8);
//
//            switch (stageToRenderToViewport) {
//                case YCbCr_CHAN2: {
//                    return yCbCrChan2Mat;
//                }
//
//                case THRESHOLD: {
//                    return thresholdMat;
//                }
//
//                case CONTOURS_OVERLAYED_ON_FRAME: {
//                    return contoursOnFrameMat;
//                }
//
//                case RAW_IMAGE: {
//                    return input;
//                }
//
//                default: {
                    return input;
//                }
//            }
        }
//
//        public int getNumContoursFound() {
//            return numContoursFound;
//        }
    }

}
