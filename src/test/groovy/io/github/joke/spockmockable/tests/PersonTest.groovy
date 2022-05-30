package io.github.joke.spockmockable.tests

import io.github.joke.spockmockable.Mockable
import org.spockframework.mock.MockUtil
import spock.lang.Specification

@Mockable([Person, Address])
class PersonTest extends Specification {

    Person person = Mock()
    def mockUtil = new MockUtil()

    def 'final from class is removed'() {
        expect:
        mockUtil.isMock person
    }

    def 'final from method is removed'() {
        when:
        def res = person.firstName

        then:
        1 * person.firstName >> 'Dorothy'

        expect:
        res == 'Dorothy'
    }

    def 'private on method is now protected'() {
        when:
        def res = person.lastName

        then:
        1 * person.lastName >> 'Gale'

        expect:
        res == 'Gale'
    }

    def 'final is removed and private on method is now protected'() {
        when:
        def res = person.address.street

        then:
        1 * person.address >> new Address('Yellow Brick Road', 'Blue City')

        expect:
        res == 'Yellow Brick Road'
    }

}
