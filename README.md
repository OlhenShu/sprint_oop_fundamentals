# Welcome to PRACTICAL TEST AUTOMATION

You can begin by cloning the repository to your computer using the command below:
```sh
git clone <url>
```
You can copy the URL in the following way:

<img width="968" alt="Screenshot 2022-05-10 at 23 06 42" src="https://user-images.githubusercontent.com/61456363/167713268-c89a4125-9467-47a6-a2d8-eb6fcefcc1dd.png">


This sprint includes several tasks with unit tests for these tasks located in separate branches **task1**, **task2**, **task3** and other.  


You can switch between branches by using a specific command:
```sh
 git checkout <branch name>
```
 e.g.
```sh
 git checkout task1
 ```
 > Remember to commit your code before switching to a different branch!

In the **main** folder, first, you need to finalize your code by implementing the solution for the task.

Then, uncomment all the tests in the **test** folder and execute the code using the command:
```sh
mvn test
```
or (if you haven't installed Maven on your PC) you can use the Maven wrapper script with:
```sh
./mvnw test
```
or use the `Run` command from your IDE to execute the tests.
