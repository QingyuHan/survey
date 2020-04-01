# Survey
![image](https://github.com/QingyuHan/survey/blob/master/icon.png)
## Project Description
 This is a questionnaire software. Users can scan the QR code link of the questionnaire, download the corresponding JSON file and generate the questionnaire dynamically. The download and upload of files are completed through the server, and users do not need to download a huge questionnaire database by themselves. It is also convenient to update and add the questionnaire. It only needs to meet the JSON format. This project obtains the web page link by scanning the QR code, and then downloads the corresponding file by pressing the key. The project is transferred through JSON file, and the questionnaire is generated dynamically after transformation. The questionnaire includes single choice questions, multiple choice questions, nine palace unlocking, longitude and latitude acquisition and precise time acquisition. Although it is just a simple demo, it has covered a lot of functional points and can be more convenient for function improvement and expansion. Through this project, we can fully review the knowledge about mobile application development, improve the proficiency, and exercise the ability of team cooperation. You can also see our efforts and knowledge through the prototype of this project.
 ## Functionalities
  + Server
    + Create,Edit,Delete surveys
    + Generate QRCode
    + Look details of response
    + Delete useless responses
  + Client
    + Scan QRCode(Input URL)
    + Download surveys
    + Fill in surveys
    + Upload or store answers
    + Pattern lock
    + ~~Create surveys~~

## SurveyServer URL
 http://120.79.148.199/SurveyServer
## How to use
 ### Step 1
  Log in to the survey server: http://120.79.148.199/SurveyServer .
  Create a survey and add some questions.
  ![image](https://github.com/QingyuHan/survey/blob/master/gif/step1.gif)
 ### Step 2
  Open this app and scan the QRCode.
  Fill in the survey and upload.
  Unlock the pattern lock.
  ![image](https://github.com/QingyuHan/survey/blob/master/gif/step2.gif)
 ### Step 3
  Check the respeonses on the survey server.
  ![image](https://github.com/QingyuHan/survey/blob/master/gif/step3.gif)
## Members Introduction
 + 20171655 Qingyu Han
    **Group leader**
    + Responsible for the construction of the server.
    + Overall task arrangement and personnel scheduling.
    + Overall UI design
    + System function logic design
    ---
 + 20171654 Shujie Wang
    Group member
    + Data structure design
    + Database design
    + Dynamic page generation
    ---
 + 20171656 Qirong Zhao
    Group menber
    + Gesture unlocking function
    + Time acquisition implementation
    + Realization of longitude and latitude acquisition
    ---
 + 20171659 Yi Liu
    Group menber
    + QR code scanning
    + File download
    + File upload
    ---