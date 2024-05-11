# Welcome to Practical Test Automation 
## Task 2 `RegistrationForm` Validation Methods

**Username Validation (`validateUsername`)**

- **Non-Empty String**: The username must not be empty.
- **Latin Alphabet Only**: Each character in the username must be a letter from the Latin alphabet.
- **Error Message**: Return an appropriate error message if the username does not meet the criteria.

**Email Validation (`validateEmail`)**

- **Presence of "@" and ".":** The email address must contain the "@" symbol and a dot (".") after the "@" in the correct order.
- **No Spaces**: The email address must not contain any spaces.
- **Sufficient Length**: The email address must be at least 5 characters long.
- **Error Message**: Provide a detailed error message if the email address does not meet the requirements.

**Password Validation (`validatePassword`)**

- **Minimum Length**: The password must be at least 8 characters long.
- **Complexity**: The password should include at least one digit, one uppercase letter, one lowercase letter, and one special character.
- **Error Message**: Return an error message detailing the required complexity if the password does not meet the standards.

**Validation Feedback**

Each validation method should return a string with a detailed description of the error. 
When validation failures are detected or an empty string/`null` if the data passes validation successfully.