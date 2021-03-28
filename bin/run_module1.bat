@echo off
call cd..
echo Move to directory with module program
call cd module_1-nix_4
call mvn clean install
call java -jar target/module_1-nix_4-1.0-SNAPSHOT.jar