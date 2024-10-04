# fluentd/Dockerfile

FROM fluent/fluentd:v1.17.1-debian-1.0
USER root
RUN gem install faraday-net_http
RUN ["gem", "install", "fluent-plugin-opensearch"]
USER fluent