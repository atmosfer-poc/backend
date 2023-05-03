#!/bin/bash

cp -R /tmp/test-lts /data01/suit/

cd /data01/suit/test-lts

cp -R . ..

cd ..

rm -rf test-lts
