package roomreservation

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PersonSpec extends Specification implements DomainUnitTest<Person> {

    void "First name can NEITHER be null NOR blank"() {
        expect:
            domain != null

        when:
        domain.firstName = null
        then:
        !domain.validate(['firstName'])
        domain.errors['firstName'].code == 'nullable'
    }

    void "Insert a new person and delete it"() {
        // Insert
        setup:
        def person = new Person(firstName: "Norberto", lastName: "Sennrich", email: "norberto.sennrich@students.fhnw.ch")

        when:
        person.validate()
        then:
        def saved = person.save()
        and:
        Person.count() == old(Person.count()) + 1
        saved.id == 1

        // Delete
        when:
        def found = Person.get(1)
        then:
        found.id == 1
        found.firstName == 'Norberto'
        and:
        found.delete()
        and:
        Person.count() == 0

    }
}
