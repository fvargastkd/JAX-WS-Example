@echo off
REM Install jaxwsWCFSSLClient shaded jar to maven local repository: C:\Documents and Settings\{your-username}\.m2

set curDir=%~dp0

echo +++++++++++++++++++++++++++++++++++++++++++
echo ++ install jaxwsWCFSSLClient sharded jar ++
echo +++++++++++++++++++++++++++++++++++++++++++
call mvn clean install -f %~dp0\pom.xml

start %userprofile%\.m2\repository\xiuzhu\test\jaxwsWCFSSLClient