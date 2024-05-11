package task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationFormTest {
    private static final String PACKAGE = "task2.";

    private static Stream<Arguments> listOfClasses() {
        return Stream.of(
                Arguments.of("RegistrationForm")
        );
    }

    private static Stream<String> fieldNames() {
        return Stream.of("username", "email", "password");
    }

    private static Stream<Map.Entry<String, Class<?>>> fieldTypePairs() {
        return Stream.of(
                Map.entry("username", String.class),
                Map.entry("email", String.class),
                Map.entry("password", String.class)
        );
    }

    @Test
    @DisplayName("Default constructor of RegistrationForm should be public")
    void testDefaultConstructorIsPublic() {
        try {
            Constructor<RegistrationForm> constructor = RegistrationForm.class.getDeclaredConstructor();
            assertTrue(Modifier.isPublic(constructor.getModifiers()), "Default constructor is not public.");
        } catch (NoSuchMethodException e) {
            fail("Default constructor not found.");
        }
    }

    @Test
    @DisplayName("Parameterized constructor of RegistrationForm should be public")
    void testParameterizedConstructorIsPublic() {
        try {
            Constructor<RegistrationForm> constructor = RegistrationForm.class.getDeclaredConstructor(String.class, String.class, String.class);
            assertTrue(Modifier.isPublic(constructor.getModifiers()), "Parameterized constructor is not public.");
        } catch (NoSuchMethodException e) {
            fail("Parameterized constructor not found.");
        }
    }

    @DisplayName("Check that RegistrationForm fields have correct types")
    @ParameterizedTest
    @MethodSource("fieldTypePairs")
    void testFieldType(Map.Entry<String, Class<?>> fieldTypePair) {
        try {
            Class<?> clazz = Class.forName(PACKAGE + "RegistrationForm");
            assertEquals(clazz.getDeclaredField(fieldTypePair.getKey()).getType(), fieldTypePair.getValue(), "Field '" + fieldTypePair.getKey() + "' should be of type " + fieldTypePair.getValue().getSimpleName() + " in RegistrationForm.");
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            fail("Error testing field types.");
        }
    }

    @DisplayName("Check that RegistrationForm fields are declared")
    @ParameterizedTest
    @MethodSource("fieldNames")
    void testFieldPresence(String fieldName) {
        try {
            Class<?> clazz = Class.forName(PACKAGE + "RegistrationForm");
            assertNotNull(clazz.getDeclaredField(fieldName),
                    "Field '" + fieldName + "' should be declared in RegistrationForm.");
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            fail("Error testing field presence.");
        }
    }

    @DisplayName("Check that RegistrationForm fields are private")
    @ParameterizedTest
    @MethodSource("fieldNames")
    void testFieldPrivate(String fieldName) {
        try {
            Class<?> clazz = Class.forName(PACKAGE + "RegistrationForm");
            assertTrue(Modifier.isPrivate(clazz.getDeclaredField(fieldName).getModifiers()),
                    "Field '" + fieldName + "' should be private in RegistrationForm.");
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            fail("Error testing field privacy.");
        }
    }

    static Stream<Arguments> usernameProvider() {
        return Stream.of(
                Arguments.of("", "Username cannot be null or empty."),
                Arguments.of(" ", "Username cannot be null or empty."),
                Arguments.of("User1", "Username must contain only letters from the Latin alphabet."),
                Arguments.of("ValidUsername", "")
        );
    }

//    @ParameterizedTest
//    @MethodSource("usernameProvider")
//    @DisplayName("Test validateUsername with various usernames")
//    void testValidateUsername(String username, String expectedMessage) {
//        RegistrationForm form = new RegistrationForm(username, "user@example.com", "Password123!");
//        assertEquals(expectedMessage, form.validateUsername());
//    }
//
//    static Stream<Arguments> emailProvider() {
//        return Stream.of(
//                Arguments.of("", "Email cannot be null or empty."),
//                Arguments.of("user", "Email must be at least 5 characters long."),
//                Arguments.of("user@", "Email must contain '@' and '.', with no spaces and '.' must follow '@'."),
//                Arguments.of("user@example", "Email must contain '@' and '.', with no spaces and '.' must follow '@'."),
//                Arguments.of("user@example.com", "")
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("emailProvider")
//    @DisplayName("Test validateEmail with various emails")
//    void testValidateEmail(String email, String expectedMessage) {
//        RegistrationForm form = new RegistrationForm("Username", email, "Password123!");
//        assertEquals(expectedMessage, form.validateEmail());
//    }
//
//    static Stream<Arguments> passwordProvider() {
//        return Stream.of(
//                Arguments.of("short", "Password must be at least 8 characters long."),
//                Arguments.of("Long1!", "Password must be at least 8 characters long."),
//                Arguments.of("longpa1!", "Password must include at least one uppercase letter."),
//                Arguments.of("longenough", "Password must include at least one number."),
//                Arguments.of("LONGPASS1!", "Password must include at least one lowercase letter."),
//                Arguments.of("Longenough1", "Password must include at least one special character."),
//                Arguments.of("", "Password must be at least 8 characters long.")
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("passwordProvider")
//    @DisplayName("Test validatePassword with various passwords")
//    void testValidatePassword(String password, String expectedMessage) {
//        RegistrationForm form = new RegistrationForm("Username", "user@example.com", password);
//        assertEquals(expectedMessage, form.validatePassword());
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "ValidUser,",
//            "AnotherValidUser,"
//    })
//    void testValidateUsernameWithValidInput(String username) {
//        RegistrationForm form = new RegistrationForm(username, "email@example.com", "Password1!");
//        assertEquals("", form.validateUsername());
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "email@example.com,",
//            "another.email@example.co.uk,"
//    })
//    void testValidateEmailWithValidInput(String email) {
//        RegistrationForm form = new RegistrationForm("ValidUser", email, "Password1!");
//        assertEquals("", form.validateEmail());
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "Password1!,",
//            "Another$Password2,"
//    })
//    void testValidatePasswordWithValidInput(String password) {
//        RegistrationForm form = new RegistrationForm("ValidUser", "email@example.com", password);
//        assertEquals("", form.validatePassword());
//    }
//
//    @Test
//    void testRegistrationFormWithValidData() {
//        RegistrationForm form = new RegistrationForm("ValidUser", "email@example.com", "Password1!");
//        assertEquals("", form.validateUsername());
//        assertEquals("", form.validateEmail());
//        assertEquals("", form.validatePassword());
//    }
//
//    @Test
//    void testRegistrationFormWithInvalidData() {
//        RegistrationForm form = new RegistrationForm("", "", "short");
//        assertNotEquals("", form.validateUsername());
//        assertNotEquals("", form.validateEmail());
//        assertNotEquals("", form.validatePassword());
//    }
//
//    @Test
//    void testDefaultConstructor() {
//        RegistrationForm form = new RegistrationForm();
//        assertNotNull(form);
//    }
//
//    @Test
//    void testParameterizedConstructor() {
//        String username = "ValidUser";
//        String email = "email@example.com";
//        String password = "Password1!";
//        RegistrationForm form = new RegistrationForm(username, email, password);
//        assertNotNull(form);
//        assertEquals(username, form.getUsername());
//        assertEquals(email, form.getEmail());
//        assertEquals(password, form.getPassword());
//    }

}
