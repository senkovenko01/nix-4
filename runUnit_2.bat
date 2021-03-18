@echo off
echo Move to directory with unit_2 program
call cd unit_2_algorithmic_tasks
call mvn clean install
call java -jar target/unit_2_algorithmic_tasks-1.0-SNAPSHOT.jar