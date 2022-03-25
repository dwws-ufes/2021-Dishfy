#!/bin/bash

## preparando o ambiente ##

cp -R d2rq-0.8.1 /opt/ 
chmod +x /opt/d2rq-0.8.1/d2r1
chmod +x /opt/d2rq-0.8.1/d2r2
chmod +x /opt/d2rq-0.8.1/d2r-server
cp d2r1.service d2r2.service /etc/systemd/system/
systemctl enable d2r1.service
systemctl enable d2r2.service
systemctl start d2r1.service
systemctl enable d2r2.service


