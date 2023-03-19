@echo off
setlocal enabledelayedexpansion

set source-code=%1




set argCount=0
for %%x in (%*) do (
   set /A argCount+=1
   set "argVec[!argCount!]=%%~x"
)
for /L %%i in (2,1,%argCount%) do call set "parameters=%%parameters%% !argVec[%%i]!"
set parameters=%parameters:~1%

java -jar .\nlc.jar %source-code%
gcc .\tests\program.c -o .\tests\program -lm
del .\tests\program.c
.\tests\program %parameters%