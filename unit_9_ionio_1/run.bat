@echo off
call mvn clean install
call java -jar target/unit_9_ionio_1-1.0-SNAPSHOT.jar