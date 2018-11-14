#!/bin/bash

set -e

if [[ $# -lt 2 ]]
then
    echo "$0 ref_name project_name"
    exit 1
fi

REF_NAME=$1
DEPLOY_PATH=/deploy/$REF_NAME
MODULE_NAME=`echo $2 | awk -F "/" '{print $NF}'`

if [[ "$REF_NAME" =~ master|^[0-9]+\.[0-9]+$ ]]
then
    mvn clean package -Dmaven.test.skip=true
else
    mvn clean package -Dmaven.test.skip=true -Dims.version=$REF_NAME
fi 

mkdir -p $MODULE_NAME
cp -rf run-${MODULE_NAME}/* $MODULE_NAME/
mv target/lib $MODULE_NAME/
mv target/*.jar $MODULE_NAME/lib/

git log -n 1 | grep -v Author > $MODULE_NAME/commit.info
zip -r $MODULE_NAME.zip $MODULE_NAME

mkdir -p $DEPLOY_PATH
mv $MODULE_NAME.zip $DEPLOY_PATH
