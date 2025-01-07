package dto;

import com.github.javafaker.Faker;

public class TestRunFactory {

    public static TestRun getRandom() {
        Faker faker = new Faker();
        return TestRun.builder()
                .references(faker.book().title())
                .assignTo("Bruce Lee")
                .description("Test Run")
                .build();
    }
}
