package com.gagharv.springcloud.zipkin.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by wei.wang on 2018/8/3
 */
@Controller
@EnableScheduling
public class SchedulingTask {

    private static final Logger logger = LoggerFactory.getLogger(SchedulingTask.class);

    @SuppressWarnings("all")
    @Autowired
    DataSource source;

    final private int DAYOFFSETMILLIS = 24 * 3600 * 1000;

    final private String sql1 = "delete from zipkin_spans where start_ts < ? ";
    final private String sql2 = "delete from zipkin_annotations where a_timestamp < ? ";

    @Scheduled(cron = "0 0 0 * * ?")
    public void cleanDatabase() {
        final long timestamp = (System.currentTimeMillis() - DAYOFFSETMILLIS) * 1000;

        try (Connection connection = source.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql1);
             PreparedStatement preparedStatement2 = connection.prepareStatement(sql2)
        ) {
            if (connection == null || connection.isClosed()) {
                logger.warn("open database for query execute");
            }
            preparedStatement.setLong(1, timestamp);
            preparedStatement.executeUpdate();
            preparedStatement2.setLong(1, timestamp);
            preparedStatement2.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error for sql  msg is {} ", e.getMessage());
        }
        logger.info("clean data at {}", timestamp);
    }
}
