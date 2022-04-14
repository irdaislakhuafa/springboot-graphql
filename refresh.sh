#!/bin/sh
mvn clean package

tagName="$1"
containerName="$2"

if [ "$tagName" = "" ]; then
    echo -n "Input Tag : "
    read tagName;
fi
if [ "$containerName" = "" ]; then
    echo -n "Input Container Name : "
    read containerName;
fi

doas docker stop "$containerName"
echo "Stoping container \"$containerName\""
echo ""

echo "Removing container \"$tagName\""
doas docker rm "$containerName"
echo ""

echo "Removing image \"$tagName\""
doas docker rmi "$tagName"
echo ""

echo "Building image \"$tagName\""
doas docker build --tag "$tagName" .
echo "Success build image \"$tagName\""
echo ""

echo "Running container \"$containerName\""
doas docker run --rm -d --env-file dep.env --name $containerName -p 8080:8080 $tagName