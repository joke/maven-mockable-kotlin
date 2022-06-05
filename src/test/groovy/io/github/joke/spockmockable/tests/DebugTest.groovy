package io.github.joke.spockmockable.tests

import groovy.util.logging.Slf4j
import spock.lang.Specification
import spock.util.environment.Jvm

import java.lang.management.ManagementFactory
import java.lang.management.RuntimeMXBean

@Slf4j
class DebugTest extends Specification {

    static {
        log.error("@@@@@@@@@@@@@@@@@@@@@ {}", System.properties)
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        List<String> arguments = runtimeMxBean.getInputArguments();
        log.error("@@@@@@@@@@@@@@@@@@@@@ {}", arguments)
    }

    def yes() {
        expect:
        true
    }

}
