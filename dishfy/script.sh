#!/bin/bash

## preparando o ambiente ##

sudo cp -R d2rq-0.8.1 /opt/ 
sudo chmod +x /opt/d2rq-0.8.1/d2r1
sudo chmod +x /opt/d2rq-0.8.1/d2r2
sudo chmod +x /opt/d2rq-0.8.1/d2r-server
sudo cp d2r1.service d2r2.service /etc/systemd/system/
sudo systemctl enable d2r1.service
sudo systemctl enable d2r2.service
sudo systemctl stop d2r1.service
sudo systemctl stop d2r2.service
sudo systemctl start d2r1.service
sudo systemctl start d2r2.service
