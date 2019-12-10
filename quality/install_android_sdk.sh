#!/usr/bin/env bash

# Quit when a command returns non-zero code
# or a variable has not being set
set -eu

wget --quiet --output-document=android-sdk.zip https://dl.google.com/android/repository/sdk-tools-linux-4333796.zip
sudo unzip -d $ANDROID_HOME android-sdk.zip > /dev/null
