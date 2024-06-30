FROM jenkins/jenkins:lts

# ... any other custom commands you might have ...

USER root

# Install wget 
RUN apt-get update && apt-get install -y wget

# Create keyring directory
RUN mkdir -p /usr/local/share/keyrings/ 

# Add Google Chrome repository key 
RUN curl -fsSL https://dl-ssl.google.com/linux/linux_signing_key.pub | gpg --dearmor -o /usr/local/share/keyrings/google-chrome.gpg

# Add Google Chrome repository
RUN echo 'deb [signed-by=/usr/local/share/keyrings/google-chrome.gpg arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main' | tee /etc/apt/sources.list.d/google-chrome.list

# Reset APT Configuration and Permissions
RUN rm -rf /var/lib/apt/lists/*  && \ 
    apt-get clean && \
    apt-get update && \
    chown -R root:root /var/lib/apt

# Install Chrome
RUN apt-get update && \
    apt-get install -y \
        google-chrome-stable 

# ... your other commands, including:
#   - ChromeDriver installation (if not using WebDriverManager)
#   - Any other tools or dependencies your project needs

USER jenkins 
# Switch back to the Jenkins user (important if your setup requires it)