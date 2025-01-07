package dto;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProjectFactory {

    public static Project getRandom() {
        Faker faker = new Faker();
        log.info("Create project by project factory");
        return Project.builder()
                .name(faker.name().firstName())
                .announcement(faker.ancient().hero())
                .build();
    }
}
