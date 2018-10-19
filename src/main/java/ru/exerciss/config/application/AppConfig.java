package ru.exerciss.config.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.exerciss.dao.PeopleDao;
import ru.exerciss.dao.RockGroupsDao;
import ru.exerciss.dao.SongPlayersDao;
import ru.exerciss.dao.impl.PeopleDaoImpl;
import ru.exerciss.dao.impl.RockGroupsDaoImpl;
import ru.exerciss.dao.impl.SongPlayersDaoImpl;
import ru.exerciss.entity.People;
import ru.exerciss.entity.RockGroups;
import ru.exerciss.entity.SongPlayers;

@Configuration
@PropertySource(value = "classpath:util.properties")
public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.mariadb.driver"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.mariadb.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.mariadb.user"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.mariadb.password"));
        return dataSource;
    }

    @Bean
    public PeopleDao peopleDao(){
        return new PeopleDaoImpl(People.class);
    }

    @Bean
    public RockGroupsDao rockGroupsDao(){
        return new RockGroupsDaoImpl(RockGroups.class);
    }

    @Bean
    public SongPlayersDao songPlayersDao(){
        return new SongPlayersDaoImpl(SongPlayers.class);
    }
}
