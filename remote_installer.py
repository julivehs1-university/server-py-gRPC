import paramiko
import time
import argparse

# Argumente für den Befehl
parser = argparse.ArgumentParser(description='SSH to a remote host, clone a git repo, install packages, and start a file.')
parser.add_argument('hostname', type=str, help='The hostname or IP address of the remote host')
args = parser.parse_args()

# Remote host information
hostname = args.hostname
port = 22
username = 'pi'
password = 'raspberry'

# Git repository and commands
git_repo_url = 'https://github.com/julivehs1-university/security-guard-pipuck-client.git'
project_dir = '/home/pi/Lab'
start_file = 'move_control.py'  

# Establish SSH connection
ssh = paramiko.SSHClient()
ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())

try:
    print(f"Connecting to the remote host {hostname}...")
    ssh.connect(hostname, port, username, password)
    print("Connected!")

    # Clone the Git repository
    print("Cloning the repository...")
    clone_cmd = f'git clone {git_repo_url} {project_dir}'
    stdin, stdout, stderr = ssh.exec_command(clone_cmd)
    print(stdout.read().decode())
    print(stderr.read().decode())

    print("Installing missing packages...")
    pip3_cmd = 'pip3 install --upgrade pip'
    stdin, stdout, stderr = ssh.exec_command(pip3_cmd)
    print(stdout.read().decode())
    print(stderr.read().decode())

    # Navigate to the project directory and install the requirements
    print("Installing grpcio-tools==1.44.0...")
    pip3_cmd = 'pip3 install --force-reinstall "grpcio-tools==1.44.0"'
    stdin, stdout, stderr = ssh.exec_command(pip3_cmd)
    print(stdout.read().decode())
    print(stderr.read().decode())

    print("Installing grpcio==1.44.0...")
    pip3_cmd = 'pip3 install grpcio==1.44.0'
    stdin, stdout, stderr = ssh.exec_command(pip3_cmd)
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

