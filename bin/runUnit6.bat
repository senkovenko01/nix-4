@echo off
call cd..
echo Move to directory with unit_6 program
call cd unit_6_exception
call mvn clean install
call java -jar target/crud.jar