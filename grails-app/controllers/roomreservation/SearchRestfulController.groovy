package roomreservation

import grails.rest.RestfulController
import org.apache.commons.lang.StringUtils

class SearchRestfulController<T> extends RestfulController<T>{

    SearchRestfulController(Class<T> resource) {
        super(resource)
    }

    SearchRestfulController(Class<T> resource, boolean readOnly) {
        super(resource, readOnly)
    }

    //implemented in class
    def search(String q) {
        if (q) {
            def list = resource.all.findAll {               //resource = rooms
                StringUtils.containsIgnoreCase it.name, q   //each item from list contains q
            }
            respond list
        } else {
            respond([])
        }
    }
}
