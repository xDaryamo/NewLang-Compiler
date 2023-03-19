echo off
set source-code=%1

java -jar .\nlc.jar %source-code%
gcc .\tests\program.c -o .\tests\program -lm
.\tests\program %2