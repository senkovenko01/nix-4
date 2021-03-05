@echo off
set MAVEN_OPTS=-Xmx1G -Dfile.encoding=UTF-8
set MAVEN_HOME=%~dp0apache-mvn
set PATH=%MAVEN_HOME%\bin;%PATH%
rem deleting CLASSPATH as a workaround for PLA-8702
set CLASSPATH=
echo Setting ant home to: %MAVEN_HOME%
mvn -version