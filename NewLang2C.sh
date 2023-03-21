#!/bin/bash

source_code=$1
output_file=$2

index=0
parameters=""
for var in "$@"
do
    if [$index -gt 2]
    then
      parameters+="$var "
    fi
    i+=1
done

java -jar .\nlc.jar $source_code $output_file
gcc -c $source_code+".c" -o $output_file -lm
$output_file $parameters