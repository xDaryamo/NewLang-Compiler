#!/bin/bash

source-code=$1

index=0
parameters=""
for var in "$@"
do
    if [$index -gt 1]
    then
      parameters+="$var "
    fi
    i+=1
done

java -jar ./NewLangCompiler.jar $1
gcc "test_files/c_out/${onlyname}.c" -o $2 -lm


java -jar .\nlc.jar $1
gcc .\tests\program.c -o .\tests\program -lm
rm .\tests\program.c
.\tests\program $parameters