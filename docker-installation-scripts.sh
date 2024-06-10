#!/bin/bash

# Update the system
sudo apt update
sudo hostnamectl set-hostname jendarey-docker-engine

# Install Dependencies (only if not already installed)
sudo apt install -y git curl maven tree

# Set up Docker's apt repository.
# Add Docker's official GPG key:
sudo apt-get update -y
sudo apt-get install ca-certificates curl gnupg
sudo install -m 0755 -d /etc/apt/keyrings
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
sudo chmod a+r /etc/apt/keyrings/docker.gpg

# Add the repository to Apt sources:
echo \
  "deb [arch="$(dpkg --print-architecture)" signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu \
  "$(. /etc/os-release && echo "$VERSION_CODENAME")" stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
sudo apt-get update -y

#Install the latest version, run:
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin docker-compose -y

# Add the current user to the 'docker' group
sudo usermod -aG docker ubuntu
sudo usermod -aG docker $USER

# Relogin as ubuntu user to apply group membership changes
sudo su - ubuntu
