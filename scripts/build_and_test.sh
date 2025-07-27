#!/bin/bash

# Exit immediately if a command exits with a non-zero status.
set -e

echo "--- Building with Maven (skipping tests) ---"
mvn clean install -DskipTests

echo "--- Running tests ---"
mvn test

echo "--- Maven build and tests completed successfully ---"