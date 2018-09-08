#!/bin/bash

goal_build() {
  ./gradlew build
}

goal_run() {
  ./gradlew bootRun
}

goal_run-production() {
  SPRING_PROFILES_ACTIVE=production ./gradlew bootRun
}

goal_test-unit() {
  ./gradlew test
}

goal_help() {
  echo "usage: $0 <goal>

    goal:

    build                    -- Build the deployable artifacts

    run                      -- Start the backend application
    run-production           -- Start the application without mocks

    test-unit                -- Run unit tests
    "
  exit 1
}

main() {
  TARGET=${1:-}
  if [ -n "${TARGET}" ] && type -t "goal_$TARGET" &>/dev/null; then
    "goal_$TARGET" "${@:2}"
  else
    goal_help
  fi
}

main "$@"
