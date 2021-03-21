@echo off
echo Move to directory with unit_3 program
call cd unit_3_oop
call mvn clean install
call java -jar app/target/app-1.0-SNAPSHOT.jar