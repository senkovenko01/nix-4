@echo off
call cd..
echo Move to directory with unit_5 program
call cd unit_5_oop
call mvn clean install
call java -jar target/crud.jar