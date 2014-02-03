package commerce

import grails.plugin.multitenant.core.annotation.MultiTenant

@MultiTenant
class Store {

    String name

    String address

    static constraints = {
    }
}
