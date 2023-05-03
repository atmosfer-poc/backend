#!/bin/bash

echo 'Enter packages zip file name (Example : 23.11.2022 ) :'

read packageZipFileName

scp -r /home/c0192102/suit/$packageZipFileName.zip c0192102@10.220.15.6:/home/c0192102/suit/

