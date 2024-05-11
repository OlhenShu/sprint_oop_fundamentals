# Welcome to Practical Test Automation 
## Task 3 Enhancements to the `RegistrationForm` Class

To augment the existing `RegistrationForm` class with functionalities for automatic data generation that meets specific validation criteria, and to implement a method for creating an object populated with these generated values.

### Components to be Added

- **Username Generation Method (`generateUsername`):**
    - Should automatically generate a username adhering to the validation requirements specified in `validateUsername`.
    - For instance, the username may only include Latin letters and must have a predetermined length.

- **Email Generation Method (`generateEmail`):**
    - Aimed at creating a valid email address for the user, meeting common email validation standards (presence of '@', a domain part, absence of prohibited characters).

- **Password Generation Method (`generatePassword`):**
    - Ensures the generation of a secure password that conforms to specified criteria, including minimum length, inclusion of digits, both uppercase and lowercase letters, and special characters.

- **Object Creation with Generated Data (`createRandomUser`):**
    - Uses the above methods to instantiate a new `RegistrationForm` object with a valid username, email, and password.

### Implementation Requirements

- All generated data must successfully pass through the validation checks provided by `validateUsername`, `validateEmail`, and `validatePassword` methods.
- The generated password should align with contemporary security standards.