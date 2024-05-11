package task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.Tester;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationFormTest {
    private static final String PACKAGE = "task1.";

    private static Stream<Arguments> listOfClasses() {
        return Stream.of(
                Arguments.of("RegistrationForm")
        );
    }

    private static Stream<String> fieldNames() {
        return Stream.of("username", "email", "password", "confirmPassword", "phoneNumber", "birthDate");
    }

    private static Stream<Map.Entry<String, Class<?>>> fieldTypePairs() {
        return Stream.of(
                Map.entry("username", String.class),
                Map.entry("email", String.class),
                Map.entry("password", String.class),
                Map.entry("confirmPassword", String.class),
                Map.entry("phoneNumber", String.class),
                Map.entry("birthDate", String.class)
        ).map(entry -> Map.entry(entry.getKey(), entry.getValue()));
    }

    private static Stream<Arguments> provideInvalidBirthDates() {
        return Stream.of(
                Arguments.of(null, IllegalArgumentException.class, "Birth date cannot be null or empty"),
                Arguments.of("", IllegalArgumentException.class, "Birth date cannot be null or empty"),
                Arguments.of("01-01-2000", DateTimeParseException.class, "Invalid birth date format"),
                Arguments.of("2100-01-01", IllegalArgumentException.class, "Birth date cannot be in the future")
        );
    }

//    private static Stream<Arguments> provideBirthDatesAndExpectedAges() {
//        LocalDate now = LocalDate.now();
//        int currentYear = now.getYear();
//        return Stream.of(
//                Arguments.of((Supplier<RegistrationForm>) () -> new RegistrationForm("Alice Green", "alice.green@example.com", "password123", "password123", "1234567890", "1990-01-01"), currentYear - 1990),
//                Arguments.of((Supplier<RegistrationForm>) () -> new RegistrationForm("Bob Brown", "bob.brown@example.com", "password123", "password123", "1234567890", now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))), 0),
//                Arguments.of((Supplier<RegistrationForm>) () -> new RegistrationForm("Davide Black", "davide.black@example.com", "password123", "password123", "1234567890", "2020-02-29"), now.isAfter(LocalDate.of(currentYear, 2, 29)) ? currentYear - 2020 : currentYear - 2020 - 1)
//        );
//    }
//
//    @Test
//    @DisplayName("Default constructor of RegistrationForm should be public")
//    void testDefaultConstructorIsPublic() {
//        try {
//            Constructor<RegistrationForm> constructor = RegistrationForm.class.getDeclaredConstructor();
//            assertTrue(Modifier.isPublic(constructor.getModifiers()), "Default constructor is not public.");
//        } catch (NoSuchMethodException e) {
//            fail("Default constructor not found.");
//        }
//    }
//
//    @Test
//    @DisplayName("Parameterized constructor of RegistrationForm should be public")
//    void testParameterizedConstructorIsPublic() {
//        try {
//            Constructor<RegistrationForm> constructor = RegistrationForm.class.getDeclaredConstructor(String.class, String.class, String.class, String.class, String.class, String.class);
//            assertTrue(Modifier.isPublic(constructor.getModifiers()), "Parameterized constructor is not public.");
//        } catch (NoSuchMethodException e) {
//            fail("Parameterized constructor not found.");
//        }
//    }
//
//    @DisplayName("Check that RegistrationForm fields have correct types")
//    @ParameterizedTest
//    @MethodSource("fieldTypePairs")
//    void testFieldType(Map.Entry<String, Class<?>> fieldTypePair) {
//        assertTrue(Tester.hasFieldType("task1.RegistrationForm", fieldTypePair.getKey(), fieldTypePair.getValue()),
//                "Field '" + fieldTypePair.getKey() + "' should be of type " + fieldTypePair.getValue().getSimpleName() + " in RegistrationForm.");
//    }
//
//    @DisplayName("Check that Classes are public")
//    @ParameterizedTest
//    @MethodSource("listOfClasses")
//    void isClassPublic(String className) {
//        try {
//            assertTrue(Tester.isClassPublic(PACKAGE + className), "Class " + className + " should be public");
//        } catch (AssertionError e) {
//            fail("Class " + className + " is not public");
//        }
//    }
//
//    @DisplayName("Check that calculateAge method is present in RegistrationForm")
//    @Test
//    void testCalculateAgeMethodPresence() {
//        assertTrue(Tester.hasTypeDeclaredMethod("task1.RegistrationForm", "calculateAge", new Class<?>[0]),
//                "Method 'calculateAge' should be declared in RegistrationForm.");
//    }
//
//
//    @DisplayName("Check that calculateAge method is public in RegistrationForm")
//    @Test
//    void testCalculateAgeMethodPublic() {
//        assertTrue(Tester.isMethodPublic("task1.RegistrationForm", "calculateAge", new Class<?>[0]),
//                "Method 'calculateAge' should be public in RegistrationForm.");
//    }
//
//    @DisplayName("Check that RegistrationForm fields are declared")
//    @ParameterizedTest
//    @MethodSource("fieldNames")
//    void testFieldPresence(String fieldName) {
//        assertTrue(Tester.hasTypeDeclaredField("task1.RegistrationForm", fieldName),
//                "Field '" + fieldName + "' should be declared in RegistrationForm.");
//    }
//
//    @DisplayName("Check that RegistrationForm fields are private")
//    @ParameterizedTest
//    @MethodSource("fieldNames")
//    void testFieldPrivate(String fieldName) {
//        assertTrue(Tester.isFieldPrivate("task1.RegistrationForm", fieldName),
//                "Field '" + fieldName + "' should be private in RegistrationForm.");
//    }
//
//
//    @DisplayName("Calculate Age: Verifies age calculation is correct")
//    @ParameterizedTest
//    @MethodSource("provideBirthDatesAndExpectedAges")
//    public void testCalculateAge(Supplier<RegistrationForm> formSupplier, int expectedAge) {
//        RegistrationForm form = formSupplier.get();
//        int actualAge = form.calculateAge();
//        assertEquals(expectedAge, actualAge, "Age calculation should be correct for birth date: " + form.getBirthDate());
//    }
//
//
//    @DisplayName("Throw an exception when birth date is null")
//    @Test
//    public void testThrowExceptionWhenBirthDateIsNull() {
//        RegistrationForm form = new RegistrationForm("JohnDoe", "johndoe@example.com", "password123", "password123", "1234567890", null);
//        assertThrows(IllegalArgumentException.class, form::calculateAge);
//    }
//
//    @DisplayName("Throw an exception when birth date is empty")
//    @Test
//    public void testThrowExceptionWhenBirthDateIsEmpty() {
//        RegistrationForm form = new RegistrationForm("JohnDoe", "johndoe@example.com", "password123", "password123", "1234567890", "");
//        assertThrows(IllegalArgumentException.class, form::calculateAge);
//    }
//
//    @DisplayName("Throw an exception when birth date is not in the correct format")
//    @Test
//    public void testThrowExceptionWhenBirthDateIsNotInCorrectFormat() {
//        RegistrationForm form = new RegistrationForm("JohnDoe", "johndoe@example.com", "password123", "password123", "1234567890", "01-01-2000");
//        assertThrows(DateTimeParseException.class, form::calculateAge);
//    }
//
//    @DisplayName("Throw an exception when birth date is in the future")
//    @Test
//    public void testThrowExceptionWhenBirthDateIsInFuture() {
//        RegistrationForm form = new RegistrationForm("JohnDoe", "johndoe@example.com", "password123", "password123", "1234567890", "2100-01-01");
//        assertThrows(IllegalArgumentException.class, form::calculateAge);
//    }
//
//    @DisplayName("Ensure calculateAge throws exceptions for invalid birth dates")
//    @ParameterizedTest
//    @MethodSource("provideInvalidBirthDates")
//    void testCalculateAgeExceptions(String birthDate, Class<? extends Throwable> expectedException, String expectedMessage) {
//        RegistrationForm form = new RegistrationForm("John Doe", "john.doe@example.com", "password123", "password123", "1234567890", birthDate);
//        Exception exception = (Exception) assertThrows(expectedException, form::calculateAge);
//        assertTrue(exception.getMessage().contains(expectedMessage));
//    }
//
//    @DisplayName("Verify RegistrationForm state after setting values")
//    @Test
//    void testRegistrationFormState() {
//        RegistrationForm form = new RegistrationForm();
//        form.setUsername("NewUser");
//        form.setEmail("newuser@example.com");
//        assertEquals("NewUser", form.getUsername());
//        assertEquals("newuser@example.com", form.getEmail());
//    }
//
//    @DisplayName("Verify calculateAge returns the correct age")
//    @ParameterizedTest
//    @MethodSource("provideBirthDatesAndExpectedAges")
//    void testCalculateAgeCorrectness(Supplier<RegistrationForm> formSupplier, int expectedAge) {
//        RegistrationForm form = formSupplier.get();
//        assertEquals(expectedAge, form.calculateAge(), "Age should be calculated correctly based on the birth date");
//    }

}
