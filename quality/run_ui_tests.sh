#!/usr/bin/env bash

# Quit when a command returns non-zero code
set -e

# Create, launch and unlock the emulator
./quality/launch_emulator.sh

# Wait emulator complete boot
sleep 90

# Run the tests
./gradlew connectedAndroidTest

# Finish the process
./quality/kill_emulators.sh
