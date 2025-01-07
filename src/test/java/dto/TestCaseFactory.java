package dto;

import com.github.javafaker.Faker;

public class TestCaseFactory {

    public static TestCase getRandom() {
        Faker faker = new Faker();
        return TestCase.builder()
                .title(faker.book().title())
                .section("Test Case")
                .template("Test Case (Text)")
                .type("Automated")
                .priority("Low")
                .steps(faker.book().title())
                .preconditions(faker.book().title())
                .expectedResult(faker.book().title())
                .estimate("12")
                .references(faker.book().title())
                .automationType("Ranorex")
                .build();
    }
}
