package org.csystem.app.staff.configuration;

import org.csystem.util.data.test.factory.StaffFactory;
import org.csystem.util.data.test.staff.StaffInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Configuration
public class StaffConfig {
    @Bean
    public List<StaffInfo> getStaff(@Value("${app.staff.path}") String path) throws IOException
    {
        return StaffFactory.loadFromTextFile(Path.of(path)).STAFF;
    }
}
