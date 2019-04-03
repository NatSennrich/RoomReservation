package roomreservation

import grails.rest.RestfulController

class NonDeleteRestfulController<T> extends RestfulController<T>{

    NonDeleteRestfulController(Class<T> resource) {
        super(resource)
    }

    NonDeleteRestfulController(Class<T> resource, boolean readOnly) {
        super(resource, readOnly)
    }

    @Override
    Object delete() {
        render status: METHOD NOT ALLOWED
    }
}
