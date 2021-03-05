@echo off
echo This is an example how works running from terminal:
call javac -d build/classes -cp ./libs/commons-lang3-3.11.jar;./libs/commons-math3-3.6.1.jar;. -sourcepath src\ src\ua\com\alevel\Main.java
call java -cp build\classes\;.\libs\commons-lang3-3.11.jar;.\libs\commons-math3-3.6.1.jar;. ua.com.alevel.Main
echo ---------------------
