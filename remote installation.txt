import paramiko
import time

# Remote host information
hostname = 'pi5780'
port = 22
username = 'pi'
password = 'raspberry'

# Git repository and commands
git_repo_url = 'https://github.com/julivehs1-university/security-guard-pipuck-client.git'
project_dir = '/home/pi/lab'  # The directory where you want to clone the repo
start_file = 'move_control.py'  # The file you want to start

# Establish SSH connection
ssh = paramiko.SSHClient()
ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())

try:
    print("Connecting to the remote host...")
    ssh.connect(hostname, port, username, password)
    print("Connected!")

    # Clone the Git repository
    print("Cloning the repository...")
    clone_cmd = f'git clone {git_repo_url} {project_dir}'
    stdin, stdout, stderr = ssh.exec_command(clone_cmd)
    print(stdout.read().decode())
    print(stderr.read().decode())

    # Navigate to the project directory and install the requirements
    print("Installing missing packages...")
    install_cmd = f'cd {project_dir} && pip install -r requirements.txt'
    stdin, stdout, stderr = ssh.exec_command(install_cmd)
    print(stdout.read().decode())
    print(stderr.read().decode())

    # Start the file
    print(f"Starting the file {start_file}...")
    start_cmd = f'cd {project_dir} && python {start_file}'
    stdin, stdout, stderr = ssh.exec_command(start_cmd)

    # Output the result
    print("Output:")
    print(stdout.read().decode())
    print(stderr.read().decode())

finally:
    ssh.close()
    print("SSH connection closed.")

