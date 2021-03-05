@echo off
echo Now you set M2_HOME
call cd maven_home
call setmvnenv.bat
call cd..
call cd app
call mvn clean install
echo This is an example how works running with Maven:
call java -jar target/app-1.0-SNAPSHOT.jar