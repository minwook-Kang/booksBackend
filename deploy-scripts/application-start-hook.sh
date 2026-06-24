#!/bin/bash

pkill -f bookapp || true
cd /home/ec2-user/app
nohup java -jar ./build/libs/bookapp-0.0.1-SNAPSHOT.jar > app.log 2>&1 &