#!/bin/bash

source_code=$1
output_file=$2

index=0
parameters=""
for var in "$@"
do
    if [ $index -gt 2 ]
    then
      parameters+="$var "
    fi
    i+=1
done

cl
java -jar ./nlc.jar $source_code $output_file

if [[ -f $output_file+".c" ]]
then
  gcc -c $output_file+".c" -o $output_file -lm
  $output_file $parameters
fi