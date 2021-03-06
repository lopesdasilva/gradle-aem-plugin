#!/bin/bash

export CQ_PORT={{instance.httpPort}}
export CQ_RUNMODE='{{instance.typeName}},local'
export CQ_JVM_OPTS='-server -Xmx1024m -XX:MaxPermSize=256M -Djava.awt.headless=true -Xdebug -Xrunjdwp:transport=dt_socket,address={{instance.debugPort}},server=y,suspend=n'

chmod u+x crx-quickstart/bin/start
./crx-quickstart/bin/start