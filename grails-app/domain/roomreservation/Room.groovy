package roomreservation

import grails.rest.Resource

@Resource(uri = "/rooms", superClass = SearchRestfulController)
class Room {

    String name
    int max

    String toString() {
        "$name ($max)"   // Groovy :-)
    }

    static constraints = {
        name(blank: false)
        max(min: 1)
    }
}

//For search:
//superclass added
//created new controller SearchRestfulController
//url in UrlMappings added
