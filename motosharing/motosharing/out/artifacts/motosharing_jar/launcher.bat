#!/bin/bash

java --module-path C:/Users/mount/Downloads/openjfx-18.0.1_windows-x64_bin-sdk/javafx-sdk-18.0.1/lib C:\Users\mount\.m2\repository\com\googlecode\json-simple\json-simple\1.1.1  --add-modules javafx.controls,javafx.fxml,json-simple-1 -jar motosharing.jar 
timeout /t 100

#"C:\Program Files\Java\jdk-17\bin\java.exe" --module-path C:/Users/mount/Downloads/openjfx-18.0.1_windows-x64_bin-sdk/javafx-sdk-18.0.1/lib --add-modules javafx.controls,javafx.fxml -Dfile.encoding=windows-1252 -jar E:\Facultate\ProiectSEF\MotoSharing\motosharing\motosharing\out\artifacts\motosharing_jar\motosharing.jar