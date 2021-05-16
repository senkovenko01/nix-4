@echo off
call mvn clean install
call java -jar target/module_2-nix_4-1.0-SNAPSHOT.jar