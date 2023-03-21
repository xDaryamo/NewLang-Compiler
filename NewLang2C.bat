@echo off
setlocal enabledelayedexpansion

set source-code=%1
set output-file=%2



set argCount=0
for %%x in (%*) do (
   set /A argCount+=1
   set "argVec[!argCount!]=%%~x"
)
for /L %%i in (3,1,%argCount%) do call set "parameters=%%parameters%% !argVec[%%i]!"
set parameters=%parameters:~1%

cls
java -jar .\nlc.jar %source-code% %output-file%
gcc %output-file%.c -o %output-file% -lm
%output-file% %parameters%