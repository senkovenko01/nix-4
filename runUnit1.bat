@echo off
call cd unit_1_compile/simple
@echo off
call runSimple.bat
call cd..
call cd ant
@echo off
call runAnt.bat
call cd..
call cd maven
@echo off
call runMaven.bat
call pause