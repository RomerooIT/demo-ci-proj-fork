FROM ubuntu:latest
LABEL authors="fenty"

ENTRYPOINT ["top", "-b"]