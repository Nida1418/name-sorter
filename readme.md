## **Description**

name-sorter is a maven project written in java.
It is used to sort a list of names supplied via an input file, the sorted output is written to "sorted-names-list.txt" file 
in the same directory from which the program is executed.
If any error is encountered during the execution then it's description will be written to "errors.txt" file 
in the same directory from which the program is executed.
If error message can't be written to the errors.txt file then it will be written to application logs.

## **Steps to execute the program**

- A jar file can be generated for the application by running "mvn install" in the root directory.
- jar file will be generated inside "target" directory (inside root directory)
- Application can then be executed by running following command:
`java -jar name-sorter-1.0.jar unsorted-names-list.txt`
assuming that we are inside the folder where the jar file exists and unsorted-names-list.txt file exists in the same 
folder as well.

An alternate way of executing the program is by running the Main.java file directly along with path to the 
input file (unsorted-names-list.txt) as command line argument.

## **Assumptions**

Following assumptions have been made:

- Each name in the input file is on a separate line
- Each name in the input file is a space separated string (if name has more than one given name / last name)
- If a name is a substring (from beginning) of another name then it will appear before the longer name in the sorted list 