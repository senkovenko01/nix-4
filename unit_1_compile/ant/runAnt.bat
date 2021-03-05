@echo off
echo Now you set ANT_HOME
call cd ant_home
call setantenv.bat
call cd..
call ant
call ant clean
call ant compile
call ant jar
echo This is an example how works running with Ant:
call ant run