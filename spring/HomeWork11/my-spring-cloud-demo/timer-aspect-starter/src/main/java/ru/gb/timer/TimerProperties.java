package ru.gb.timer;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("application.timer")
public class TimerProperties {

    /**
     * Включить\выключить замер времени выполнения метода бина, помеченного аннотацией @Timer
     */
    private boolean timer = false;
}
