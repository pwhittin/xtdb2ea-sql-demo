#!/usr/bin/env bash

echo "======================================="
echo "===== Starting XTDB Docker Server ====="
echo "======================================="
docker run -tip 3000:3000 ghcr.io/xtdb/xtdb-ea