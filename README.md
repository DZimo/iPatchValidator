# iPatchValidator
A tool that calculate the differences between source code and patch, a sort of validating a patch to rank it.

# How to run ?
1) Put your desired source code in CodeExamples.
2) Compile the codes with "mvn compile".
2) Create a new environment variable "iPatchValidator" and set the path to target ( where your compiled codes are located in this project PATH TO ~\iPatchValidator\target)
3) Run the tool and you will get the output in a log file and terminal.

## Project Description:

Implement a Dynamic Analysis for  testing a (Passing/Failing) test cases using patches as input: 
- Input can be a manually inserted patches.

The expected output: calculate the patches (to find the changes) for below:
- ControlFlow
- Variables

# Dependencies 
Every dependency is already mentioned in the pom, mainly this project is based on Sootup 1.1.2 Version

# REQUIREMENTS:
JAVA 17
Apache Maven 3.9.1

# VERSION:
V1.0


