#!/usr/bin/env bash

# Quit when a command returns non-zero code
# or a variable has not being set
set -eu

# Create the emulator
echo no | $ANDROID_HOME/tools/android create avd --force -n test --abi google_apis/armeabi-v7a --package 'system-images;android-29;google_apis;armeabi-v7a'
$ANDROID_HOME/tools/android list avd
$ANDROID_HOME/tools/emulator -avd test -no-window -no-boot-anim -no-audio -verbose &

bootanim=""
failcounter=0
timeout_in_sec=360

until [[ "$bootanim" =~ "stopped" ]]; do
  bootanim=`adb -e shell getprop init.svc.bootanim 2>&1 &`
  if [[ "$bootanim" =~ "device not found" || "$bootanim" =~ "device offline"
    || "$bootanim" =~ "running" ]]; then
    let "failcounter += 1"
    echo "Waiting for emulator to start"
    if [[ $failcounter -gt timeout_in_sec ]]; then
      echo "Timeout ($timeout_in_sec seconds) reached; failed to start emulator"
      exit 1
    fi
  fi
  sleep 1
done

# Unlock the Lock Screen
$ANDROID_HOME/platform-tools/adb shell input keyevent 82 &
$ANDROID_HOME/platform-tools/adb shell input keyevent 4 &

echo "Emulator is ready"