@echo off
set M2_OPTS=-Xmx512G -Dfile.encoding=UTF-8
set M2_HOME=%~dp0apache-mvn
set PATH=%M2_HOME%\bin;%PATH%
rem deleting CLASSPATH as a workaround for PLA-8702
set CLASSPATH=
echo Setting ant home to: %M2_HOME%
mvn -version