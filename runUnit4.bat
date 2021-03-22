@echo off
echo Move to directory with unit_4 program
call cd unit_4_string
call mvn clean install
call java -jar reverse_application/target/reverse_application-1.0-SNAPSHOT.jar